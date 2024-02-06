package com.example.plugins.model

import kotlinx.serialization.Serializable

@Serializable
data class User(val nome: String, val morada: String,val idade: Int )

