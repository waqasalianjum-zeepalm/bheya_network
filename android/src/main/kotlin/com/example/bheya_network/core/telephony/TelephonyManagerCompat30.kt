package com.example.bheya_network.core.telephony

import android.Manifest
import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresPermission
import com.example.bheya_network.core.feature.config.DisplayInfoSource
import com.example.bheya_network.core.model.DisplayInfo

@TargetApi(Build.VERSION_CODES.R)
internal open class TelephonyManagerCompat30(
    context: Context,
    subId: Int = Integer.MAX_VALUE
) : TelephonyManagerCompat29(context, subId) {

    private val displayInfoSource = DisplayInfoSource()

    @RequiresPermission(allOf = [Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.READ_PHONE_STATE])
    override fun getDisplayInfo(): DisplayInfo =
        displayInfoSource.get(telephony, subId)
    
    
}
