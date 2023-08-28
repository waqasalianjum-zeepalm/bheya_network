package com.example.bheya_network.core.feature.detect

import com.example.bheya_network.core.INetMonster
import com.example.bheya_network.core.db.model.NetworkType
import com.example.bheya_network.core.telephony.ITelephonyManagerCompat

/**
 * Class that is able to detect current network type
 */
interface INetworkDetector {

    /**
     * Performs search and detects current network type.
     * Returns null if search was not successful or not possible at this moment.
     */
    fun detect(netmonster: INetMonster, telephony: ITelephonyManagerCompat) : NetworkType?

}