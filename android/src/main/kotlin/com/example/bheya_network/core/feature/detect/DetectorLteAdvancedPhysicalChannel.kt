package com.example.bheya_network.core.feature.detect

import android.os.Build
import com.example.bheya_network.core.INetMonster
import com.example.bheya_network.core.db.NetworkTypeTable
import com.example.bheya_network.core.db.model.NetworkType
import com.example.bheya_network.core.model.annotation.SinceSdk
import com.example.bheya_network.core.model.connection.SecondaryConnection
import com.example.bheya_network.core.telephony.ITelephonyManagerCompat

/**
 * Attempts to detect LTE Advanced / LTE Carrier aggregation
 *
 * Based on different physical channel configuration (PCC) which was added in [Build.VERSION_CODES.P].
 * PCC tells us whether are there multiple serving LTE cells. Once there's any secondary we known that
 * this is LTE-A for sure.
 */
class DetectorLteAdvancedPhysicalChannel : INetworkDetector {

    @SinceSdk(Build.VERSION_CODES.P)
    override fun detect(netmonster: INetMonster, telephony: ITelephonyManagerCompat): NetworkType? =
        netmonster.getPhysicalChannelConfiguration(telephony.getSubscriberId()).let { pcc ->
            if (pcc.size > 1 && pcc.firstOrNull { it.connectionStatus is SecondaryConnection } != null) {
                NetworkTypeTable.get(NetworkType.LTE_CA)
            } else null
        }

}