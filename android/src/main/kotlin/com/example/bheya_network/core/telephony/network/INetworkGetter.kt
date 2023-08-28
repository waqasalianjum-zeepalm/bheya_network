package com.example.bheya_network.core.telephony.network

import com.example.bheya_network.core.model.Network
import com.example.bheya_network.core.telephony.ITelephonyManagerCompat

/**
 * Interface that allows us obtain [Network].
 */
interface INetworkGetter {

    /**
     * Fetches network from using [telephony]
     * @return network or null
     */
    fun getNetwork(telephony: ITelephonyManagerCompat): Network?
}