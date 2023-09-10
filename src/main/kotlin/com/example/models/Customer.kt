package com.example.models

import kotlinx.serialization.EncodeDefault
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
@OptIn(ExperimentalSerializationApi::class)
data class Customer(

    @EncodeDefault
    @SerialName("id_cliente")
    val id: String = UUID.randomUUID().toString(),

    @SerialName("nome")
    val firstName: String,

    @SerialName("sobrenome")
    val lastName: String,

    val email: String? = null
)

val customerStorage = mutableListOf<Customer>()