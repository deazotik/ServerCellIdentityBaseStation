package ru.maksim.cellidentityinfo.model

import kotlinx.serialization.Serializable

@Serializable
data class BaseStation(
    val mcc_mnc: String,
    val lac: Int,
    val cid: Int,
    val bsic_psc_pci: Int,
    val asuLevel: Int,
    val signalLevel: Int,
    val dbm: Int,
    val type: String
)

