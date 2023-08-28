package com.example.bheya_network.core.feature.detect

import android.Manifest
import android.os.Build
import androidx.annotation.RequiresPermission
import androidx.annotation.VisibleForTesting
import com.example.bheya_network.core.INetMonster
import com.example.bheya_network.core.db.NetworkTypeTable
import com.example.bheya_network.core.db.model.NetworkType
import com.example.bheya_network.core.feature.merge.CellSource
import com.example.bheya_network.core.model.annotation.Experimental
import com.example.bheya_network.core.model.annotation.SinceSdk
import com.example.bheya_network.core.model.cell.CellLte
import com.example.bheya_network.core.model.cell.ICell
import com.example.bheya_network.core.model.connection.PrimaryConnection
import com.example.bheya_network.core.telephony.ITelephonyManagerCompat


/**
 * Attempts to detect LTE Advanced / LTE Carrier aggregation
 *
 * Based on different EARFCNs & bands in scan result.
 */
@Experimental("Attempts to guess if LTE is installed. Cannot guarantee correctness.")
class DetectorLteAdvancedCellInfo : INetworkDetector {

    @RequiresPermission(
        allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.READ_PHONE_STATE]
    )
    @SinceSdk(Build.VERSION_CODES.N)
    override fun detect(netmonster: INetMonster, telephony: ITelephonyManagerCompat): NetworkType? =
        detect(netmonster.getCells(CellSource.ALL_CELL_INFO))

    @VisibleForTesting
    internal fun detect(cells: List<ICell>) =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            val lteCells = cells.filterIsInstance(CellLte::class.java)

            // Get all serving unique EARFCNs that are valid
            val primary = lteCells
                .filter { it.connectionStatus is PrimaryConnection }
                .mapNotNull { it.band }
                .distinct()

            if (primary.isNotEmpty()) {
                // Get all EARFCNs of all non-serving cells + remove those from serving cells
                val secondary = lteCells
                    .filter { it.connectionStatus !is PrimaryConnection }
                    .map { it.band }
                    .distinct()
                    .toMutableList().apply {
                        // Remove all bands that are already present in primary cells
                        // This in most cases enhances correctness (however some providers might own fragmented spectrum)
                        removeIf { secBand ->
                            primary.firstOrNull { primBand ->
                                primBand.number == secBand?.number
                            } != null
                        }
                    }

                // Android 6.0 did report cells with invalid band but with valid signal whilst on LTE-A and invalid
                // band is mapped to null
                // Android 7.0+ reports only valid EARFCNs when in LTE-A, invalid must not be present
                if ((secondary.contains(null) && secondary.size == 1) || (!secondary.contains(null) && secondary.isNotEmpty())) {
                    NetworkTypeTable.get(NetworkType.LTE_CA)
                } else null
            } else {
                // Primary / serving LTE cell is required
                null
            }

        } else {
            // EARFCN was added in Android N, till that version we were not able to detect LTE-A
            null
        }

}