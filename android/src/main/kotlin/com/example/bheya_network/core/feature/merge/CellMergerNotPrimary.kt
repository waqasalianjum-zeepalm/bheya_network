package com.example.bheya_network.core.feature.merge

import com.example.bheya_network.core.model.cell.CellGsm
import com.example.bheya_network.core.model.cell.CellWcdma
import com.example.bheya_network.core.model.cell.ICell
import com.example.bheya_network.core.model.connection.NoneConnection
import com.example.bheya_network.core.model.connection.SecondaryConnection
import com.example.bheya_network.core.model.signal.SignalGsm
import com.example.bheya_network.core.model.signal.SignalWcdma
import com.example.bheya_network.core.telephony.ITelephonyManagerCompat
import com.example.bheya_network.core.util.maxOrNotnull
import com.example.bheya_network.core.util.minOrNotnull
import com.example.bheya_network.core.util.removeFirstOrNull

/**
 * Merges not primary cells (with [NoneConnection], [SecondaryConnection] as connection) from two sources:
 *  - [ITelephonyManagerCompat.getNeighbouringCells]
 *  - [ITelephonyManagerCompat.getAllCellInfo]
 * into one list without duplicities.
 */
class CellMergerNotPrimary : ICellMerger {

    override fun merge(oldApi: List<ICell>, newApi: List<ICell>, displayOn: Boolean): List<ICell> =
        if (oldApi.isEmpty()) {
            newApi
        } else if (newApi.isEmpty()) {
            oldApi
        } else {
            val oldCopy = oldApi.toMutableList()
            val merged = newApi.map { new ->
                // Cells from old API might be only GSM or WCDMA
                when (new) {
                    is CellGsm -> oldCopy
                        .removeFirstOrNull { old -> old is CellGsm && old.cid == new.cid }
                        ?.let { old ->
                            mergeGsm(new, old as CellGsm)
                        } ?: new
                    is CellWcdma -> oldCopy
                        .removeFirstOrNull { old -> old is CellWcdma && old.psc == new.psc }
                        ?.let { old ->
                            mergeWcdma(new, old as CellWcdma)
                        } ?: new
                    else -> new
                }
            }.toMutableList()

            // Append the rest of old API if there are no siblings left in new api
            if (oldCopy.isNotEmpty()) {
                merged.addAll(oldCopy)
            }

            merged
        }

    /**
     * WCDMA merging for neighbours:
     *  - [old] contains only PSC and RSSI
     *  - [new] same as old + band
     *
     * What can be improved:
     *  - RSSI
     */
    private fun mergeWcdma(new: CellWcdma, old: CellWcdma) : CellWcdma {
        val rssi = pickBetterRssi(new.signal.rssi, old.signal.rssi, SignalWcdma.RSSI_MIN.toInt())
        return if (rssi != new.signal.rssi) {
            new.copy(signal = new.signal.copy(rssi = rssi))
        } else {
            new
        }
    }

    /**
     * GSM merging for neighbours:
     * - [old] contains CID, LAC and RSSI
     * - [new] same as old + BSIC, band
     *
     * What can be improved:
     *  - RSSI
     */
    private fun mergeGsm(new: CellGsm, old: CellGsm) : CellGsm {
        val rssi = pickBetterRssi(new.signal.rssi, old.signal.rssi, SignalGsm.RSSI_MIN.toInt())

        return if (rssi != new.signal.rssi) {
            new.copy(
                lac = old.lac ?: new.lac,
                signal = new.signal.copy(rssi = rssi))
        } else {
            new
        }
    }

    /**
     * Picks better signal favouring smaller values and ignoring marginal
     * values.
     */
    private fun pickBetterRssi(new: Int?, old: Int?, minPossible: Int) : Int? =
        if (new != old) {
            // Marginal situation - some devices constantly report -51 or -113
            // we'll try pick something else if possible
            val min = minOrNotnull(new, old)
            if (min == minPossible) {
                maxOrNotnull(new, old)
            } else min
        } else {
            new
        }



}