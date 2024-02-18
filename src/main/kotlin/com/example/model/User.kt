package com.example.plugins.model

import org.jetbrains.exposed.sql.*
import kotlinx.serialization.Serializable


@Serializable
data class User(val nome: String, val morada: String,val idade: Int )

object user: Table (){
    val id = integer("id")
    val nome= varchar("nome",100)
    val morada =varchar("morada",100)
    val idade = integer("idade")

 override   val primaryKey = PrimaryKey(id)

}

