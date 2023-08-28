package com.example.bheya_network.core.feature.merge

import com.example.bheya_network.core.model.cell.ICell
import com.example.bheya_network.core.telephony.ITelephonyManagerCompat

/**
 * Merges two lists of [ICell] into single one without duplicities.
 */
interface ICellMerger {

    /**
     * Performs merge of two lists. Returned list's size
     * is in range from min([oldApi].size, [newApi].size) to max([oldApi].size, [newApi].size),
     * both boundaries are inclusive.
     *
     * @param oldApi data from [ITelephonyManagerCompat.getNeighbouringCells] and / or [ITelephonyManagerCompat.getCellLocation]
     * @param newApi data from [ITelephonyManagerCompat.getAllCellInfo]
     * @param displayOn true is any display of current device is on
     */
    fun merge(oldApi: List<ICell>, newApi: List<ICell>, displayOn: Boolean) : List<ICell>

}