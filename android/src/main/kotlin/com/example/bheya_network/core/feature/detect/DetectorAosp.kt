package com.example.bheya_network.core.feature.detect

import android.Manifest
import androidx.annotation.RequiresPermission
import com.example.bheya_network.core.INetMonster
import com.example.bheya_network.core.db.model.NetworkType
import com.example.bheya_network.core.telephony.ITelephonyManagerCompat

/**
 * Detection of current network type base of AOSP method.
 */
class DetectorAosp : INetworkDetector {

    @RequiresPermission(Manifest.permission.ACCESS_COARSE_LOCATION)
    override fun detect(netmonster: INetMonster, telephony: ITelephonyManagerCompat): NetworkType? =
        telephony.getNetworkType()


}