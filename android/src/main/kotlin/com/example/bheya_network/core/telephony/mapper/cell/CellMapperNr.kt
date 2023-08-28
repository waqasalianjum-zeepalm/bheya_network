package com.example.bheya_network.core.telephony.mapper.cell

import android.annotation.TargetApi
import android.os.Build
import android.telephony.CellIdentityNr
import android.telephony.CellSignalStrengthNr
import com.example.bheya_network.core.db.BandTableNr
import com.example.bheya_network.core.model.Network
import com.example.bheya_network.core.model.band.BandNr
import com.example.bheya_network.core.model.cell.CellNr
import com.example.bheya_network.core.model.connection.IConnection
import com.example.bheya_network.core.model.signal.SignalNr
import com.example.bheya_network.core.util.inRangeOrNull

/**
 * [CellIdentityNr] -> [CellNr]
 */
@TargetApi(Build.VERSION_CODES.Q)
internal fun CellIdentityNr.mapCell(subId: Int, connection: IConnection, signal: SignalNr?): CellNr? {
    val network = Network.map(mccString, mncString)
    val nci = nci.inRangeOrNull(CellNr.CID_RANGE)
    val tac = tac.inRangeOrNull(CellNr.TAC_RANGE)
    val pci = pci.inRangeOrNull(CellNr.PCI_RANGE)
    val arfcn = nrarfcn.inRangeOrNull(BandNr.DOWNLINK_EARFCN_RANGE)
    val band = arfcn?.let { BandTableNr.map(it) }

    return CellNr(
        network = network,
        nci = nci,
        tac = tac,
        pci = pci,
        connectionStatus = connection,
        signal = signal ?: SignalNr(),
        band = band,
        subscriptionId = subId
    )
}

@TargetApi(Build.VERSION_CODES.Q)
internal fun CellSignalStrengthNr.mapSignal(): SignalNr {
    val ssRsrp = ssRsrp.inRangeOrNull(SignalNr.RSRP_RANGE)
    val ssRsrq = ssRsrq.inRangeOrNull(SignalNr.RSRQ_RANGE)
    val ssSinr = ssSinr.inRangeOrNull(SignalNr.SINR_RANGE)

    val csiRsrp = csiRsrp.inRangeOrNull(SignalNr.RSRP_RANGE)
    val csiRsrq = csiRsrq.inRangeOrNull(SignalNr.RSRQ_RANGE)
    val csiSinr = csiSinr.inRangeOrNull(SignalNr.SINR_RANGE)

    return SignalNr(
        ssRsrp = ssRsrp,
        ssRsrq = ssRsrq,
        ssSinr = ssSinr,
        csiRsrp = csiRsrp,
        csiRsrq = csiRsrq,
        csiSinr = csiSinr
    )
}