package com.example.bheya_network.core.telephony

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.telephony.NeighboringCellInfo
import android.telephony.ServiceState
import android.telephony.SignalStrength
import android.telephony.TelephonyManager
import androidx.annotation.RequiresPermission
import androidx.annotation.WorkerThread
import com.example.bheya_network.core.callback.CellCallbackError
import com.example.bheya_network.core.callback.CellCallbackSuccess
import com.example.bheya_network.core.db.NetworkTypeTable
import com.example.bheya_network.core.db.model.NetworkType
import com.example.bheya_network.core.feature.config.CellLocationSource
import com.example.bheya_network.core.feature.config.ServiceStateSource
import com.example.bheya_network.core.feature.config.SignalStrengthsSource
import com.example.bheya_network.core.model.DisplayInfo
import com.example.bheya_network.core.model.Network
import com.example.bheya_network.core.model.cell.ICell
import com.example.bheya_network.core.model.model.CellError
import com.example.bheya_network.core.telephony.mapper.CellInfoMapper
import com.example.bheya_network.core.telephony.mapper.CellLocationMapper
import com.example.bheya_network.core.telephony.mapper.NeighbouringCellInfoMapper
import com.example.bheya_network.core.telephony.network.NetworkOperatorGetter
import com.example.bheya_network.core.telephony.network.SimOperatorGetter
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

/**
 * Modifies some functionalities of [TelephonyManager] and unifies access to
 * methods across all platform versions.
 */
internal open class TelephonyManagerCompat14(
    protected val context: Context,
    protected val subId: Int
) : ITelephonyManagerCompat {

    protected val telephony: TelephonyManager
        get() = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            (context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager).createForSubscriptionId(
                subId
            )
        } else {
            context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        }

    private val serviceStateSource = ServiceStateSource()
    private val signalStrengthsSource = SignalStrengthsSource()
    private val cellLocationSource = CellLocationSource()

    private val networkOperatorGetter = NetworkOperatorGetter()
    private val simOperatorGetter = SimOperatorGetter()

    protected val cellInfoMapper = CellInfoMapper(subId)
    @SuppressLint("MissingPermission")
    private val cellLocationMapper = CellLocationMapper(
        telephony,
        cellLocationSource,
        signalStrengthsSource
    ) { getNetworkOperator() }
    private val neighbouringCellInfoMapper = NeighbouringCellInfoMapper(telephony, subId)

    override fun getTelephonyManager(): TelephonyManager? = telephony

    override fun getSubscriberId(): Int = subId

    @WorkerThread
    @RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    override fun getAllCellInfo(
        onSuccess: CellCallbackSuccess
    ) = getAllCellInfo(onSuccess, null)

    @WorkerThread
    @RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    override fun getAllCellInfo(
        onSuccess: CellCallbackSuccess,
        onError: CellCallbackError?
    ) =
        if (onError != null) {
            onError.invoke(CellError.UNSUPPORTED_AOSP_VERSION)
        } else {
            onSuccess.invoke(emptyList())
        }

    @WorkerThread
    @RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    override fun getAllCellInfo(timeoutMilliseconds: Long): List<ICell> {
        var result = emptyList<ICell>()
        val asyncLock = CountDownLatch(1)

        getAllCellInfo { data ->
            result = data
            asyncLock.countDown()
        }

        try {
            asyncLock.await(timeoutMilliseconds, TimeUnit.MILLISECONDS)
        } catch (ignored: InterruptedException) {

        }

        return result
    }

    @Suppress("DEPRECATION")
    @WorkerThread
    @RequiresPermission(
        allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.READ_PHONE_STATE]
    )
    override fun getCellLocation(): List<ICell> =
        cellLocationMapper.map(subId)

    @Suppress("DEPRECATION", "UNCHECKED_CAST")
    @WorkerThread
    @RequiresPermission(
        allOf = [Manifest.permission.ACCESS_COARSE_LOCATION]
    )
    override fun getNeighboringCellInfo(): List<ICell> =
        try {
            // Reflection required cause we compile against SDK 29+ where this method
            // was removed
            val method = TelephonyManager::class.java.getMethod("getNeighboringCellInfo")
            val cells = method.invoke(telephony) as? List<NeighboringCellInfo>?
            neighbouringCellInfoMapper.map(cells)
        } catch (e: Exception) {
            emptyList()
        }

    @RequiresPermission(
        allOf = [Manifest.permission.READ_PHONE_STATE]
    )
    override fun getNetworkType(): NetworkType =
        NetworkTypeTable.get(telephony.networkType)

    @RequiresPermission(allOf = [Manifest.permission.READ_PHONE_STATE, Manifest.permission.ACCESS_COARSE_LOCATION])
    override fun getServiceState(): ServiceState? =
        serviceStateSource.get(telephony, subId)

    @RequiresPermission(allOf = [Manifest.permission.READ_PHONE_STATE, Manifest.permission.ACCESS_COARSE_LOCATION])
    override fun getNetworkOperator(): Network? =
        networkOperatorGetter.getNetwork(this)

    override fun getSimOperator(): Network? =
        simOperatorGetter.getNetwork(this)

    override fun getSignalStrength(): SignalStrength? = 
        signalStrengthsSource.get(telephony, subId)

    @RequiresPermission(allOf = [Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.READ_PHONE_STATE])
    override fun getDisplayInfo(): DisplayInfo =
        DisplayInfo(getNetworkType(), DisplayInfo.NetworkOverrideType.NONE)

}