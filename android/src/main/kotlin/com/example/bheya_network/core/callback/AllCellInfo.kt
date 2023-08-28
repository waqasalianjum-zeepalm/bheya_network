package com.example.bheya_network.core.callback


import com.example.bheya_network.core.model.cell.ICell
import com.example.bheya_network.core.model.model.CellError

typealias CellCallbackSuccess = (cells: List<ICell>) -> Unit
typealias CellCallbackError = (error: CellError) -> Unit
