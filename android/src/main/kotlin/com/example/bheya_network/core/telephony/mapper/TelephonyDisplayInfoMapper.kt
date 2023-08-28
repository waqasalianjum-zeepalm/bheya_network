package com.example.bheya_network.core.telephony.mapper

import android.annotation.TargetApi
import android.os.Build
import android.telephony.TelephonyDisplayInfo
import com.example.bheya_network.core.db.NetworkTypeTable
import com.example.bheya_network.core.model.DisplayInfo

@TargetApi(Build.VERSION_CODES.R)
internal fun TelephonyDisplayInfo.toDisplayInfo() = DisplayInfo(
    networkType = NetworkTypeTable.get(networkType),
    overrideNetworkType = when (overrideNetworkType) {
        TelephonyDisplayInfo.OVERRIDE_NETWORK_TYPE_LTE_ADVANCED_PRO -> DisplayInfo.NetworkOverrideType.LTE_ADVANCED
        TelephonyDisplayInfo.OVERRIDE_NETWORK_TYPE_NR_NSA -> DisplayInfo.NetworkOverrideType.NR_NSA
        TelephonyDisplayInfo.OVERRIDE_NETWORK_TYPE_NR_NSA_MMWAVE -> DisplayInfo.NetworkOverrideType.NR_ADVANCED
        TelephonyDisplayInfo.OVERRIDE_NETWORK_TYPE_LTE_CA -> DisplayInfo.NetworkOverrideType.LTE_CA
        else -> DisplayInfo.NetworkOverrideType.NONE
    }
)