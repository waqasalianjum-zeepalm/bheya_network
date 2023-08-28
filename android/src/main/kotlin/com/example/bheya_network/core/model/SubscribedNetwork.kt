package com.example.bheya_network.core.model
/**
 * Composite model for SubscriptionManager
 */
data class SubscribedNetwork(
    val simSlotIndex: Int,
    val subscriptionId: Int,
    val network: Network?
)