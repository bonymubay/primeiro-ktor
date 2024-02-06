package com.example.service

import com.example.plugins.model.User
import kotlinx.serialization.Serializable


class UserService() {

    fun falarNome(nome: String) = "Ola eu sou $nome"


    val users = mutableListOf(User("bony","1 de maio",1),User("Mubay","Khongolote",7))


    //val lista  = mutableListOf(1,2,3,4,5,6,7,8,9)



    fun addUser(user: User) {
        users.add(user)
    }

    fun listUser() = users

    fun updateUser(user: User,nome: String){
        for ( i in 0 until  users.size){
            if (users[i].nome.equals(nome)){
                users[i]=user
                break
            }
        }
    }

}