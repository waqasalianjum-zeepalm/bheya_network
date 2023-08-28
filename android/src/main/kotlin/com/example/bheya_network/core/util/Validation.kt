package com.example.bheya_network.core.util

/**
 * Returns null if [requirement] returns true
 */
fun <T> T.nullIf(requirement: (T) -> Boolean) =
    if (requirement.invoke(this)) {
        null
    } else {
        this
    }