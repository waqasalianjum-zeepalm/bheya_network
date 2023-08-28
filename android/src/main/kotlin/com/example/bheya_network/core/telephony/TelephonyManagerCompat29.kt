package com.example.bheya_network.core.telephony

import android.Manifest
import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.telephony.TelephonyManager
import androidx.annotation.RequiresPermission
import androidx.annotation.WorkerThread
import com.example.bheya_network.core.callback.CellCallbackError
import com.example.bheya_network.core.callback.CellCallbackSuccess
import com.example.bheya_network.core.model.cell.ICell
import com.example.bheya_network.core.telephony.mapper.CellInfoCallbackMapper
import com.example.bheya_network.core.util.DirectExecutor

/**
 * Modifies some functionalities of [TelephonyManager] and unifies access to
 * methods across all platform versions.
 */
@TargetApi(Build.VERSION_CODES.Q)
internal open class TelephonyManagerCompat29(
    context: Context,
    subId: Int = Integer.MAX_VALUE
) : TelephonyManagerCompat17(context, subId) {


    @WorkerThread
    @RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    override fun getAllCellInfo(
        onSuccess: CellCallbackSuccess,
        onError: CellCallbackError?
    ) {
        telephony.requestCellInfoUpdate(DirectExecutor(), CellInfoCallbackMapper(
            success = { cells -> onSuccess.invoke(cellInfoMapper.map(cells)) },
            error = { errorCode ->
                if (onError != null) {
                    onError.invoke(errorCode)
                } else {
                    onSuccess.invoke(cellInfoMapper.map(telephony.allCellInfo))
                }
            }
        ))
    }

    @RequiresPermission(Manifest.permission.ACCESS_COARSE_LOCATION)
    override fun getNeighboringCellInfo(): List<ICell> = emptyList()


}