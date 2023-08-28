package com.example.bheya_network.core.telephony.mapper.cell


import android.annotation.TargetApi
import android.os.Build
import android.telephony.CellInfo
import com.example.bheya_network.core.model.connection.IConnection
import com.example.bheya_network.core.model.connection.NoneConnection
import com.example.bheya_network.core.model.connection.PrimaryConnection
import com.example.bheya_network.core.model.connection.SecondaryConnection

/**
 * [CellInfo] -> [IConnection]
 */
@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
internal fun CellInfo.mapConnection(): IConnection =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
        when(cellConnectionStatus) {
            CellInfo.CONNECTION_PRIMARY_SERVING ->
                PrimaryConnection()
            CellInfo.CONNECTION_SECONDARY_SERVING ->
                SecondaryConnection(isGuess = false)
            else ->
                // Xiaomi Mi A1 returns CellInfo.CONNECTION_NONE & isRegistered = true
                if (isRegistered) {
                    PrimaryConnection()
                } else {
                    NoneConnection()
                }
        }
    } else {
        if (isRegistered) {
            PrimaryConnection()
        } else {
            NoneConnection()
        }
    }