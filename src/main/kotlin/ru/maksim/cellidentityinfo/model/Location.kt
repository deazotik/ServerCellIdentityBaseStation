package ru.maksim.cellidentityinfo.model

import kotlinx.serialization.Serializable

@Serializable
data class Location(
    val idlocation: Int,
    var latitude: Double,
    var longtitude: Double,
    var time: String
)
