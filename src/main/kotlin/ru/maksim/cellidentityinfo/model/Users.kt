package ru.maksim.cellidentityinfo.model

import kotlinx.serialization.Serializable

@Serializable
data class Users(
    val id: Int,
    var name: String,
    var lastName: String,
    var email: String,
    val number: String
)
