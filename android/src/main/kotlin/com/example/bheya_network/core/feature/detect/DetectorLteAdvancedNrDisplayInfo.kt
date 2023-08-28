package com.example.bheya_network.core.feature.detect

import android.Manifest
import android.os.Build
import android.telephony.TelephonyDisplayInfo
import androidx.annotation.RequiresPermission
import com.example.bheya_network.core.INetMonster
import com.example.bheya_network.core.db.NetworkTypeTable
import com.example.bheya_network.core.db.model.NetworkType
import com.example.bheya_network.core.model.DisplayInfo
import com.example.bheya_network.core.model.annotation.SinceSdk
import com.example.bheya_network.core.telephony.ITelephonyManagerCompat


/**
 * Attempts to detect LTE Advanced / LTE Carrier aggregation and NR in NSA mode
 *
 * Based on [TelephonyDisplayInfo]'s contents added in Android R.
 */
class DetectorLteAdvancedNrDisplayInfo : INetworkDetector {

    @SinceSdk(Build.VERSION_CODES.R)
    @RequiresPermission(allOf = [Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.READ_PHONE_STATE])
    override fun detect(netmonster: INetMonster, telephony: ITelephonyManagerCompat): NetworkType? =
        when (telephony.getDisplayInfo().overrideNetworkType) {
            DisplayInfo.NetworkOverrideType.LTE_CA -> {
                NetworkTypeTable.get(NetworkType.LTE_CA)
            }
            DisplayInfo.NetworkOverrideType.NR_ADVANCED, DisplayInfo.NetworkOverrideType.NR_NSA -> {
                NetworkTypeTable.get(NetworkType.LTE_NR)
            }
            else -> null
        }

}