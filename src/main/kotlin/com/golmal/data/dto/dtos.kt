package com.golmal.data.dto

data class RegisterRequest(
    val email:String,
    val password:String,
    val firstName:String?,
    val secondName:String?
){}