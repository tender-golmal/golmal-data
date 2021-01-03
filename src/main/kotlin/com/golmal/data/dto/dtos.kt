package com.golmal.data.dto

import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

data class RegisterRequest(
    val email:String,
    val password:String,
    val firstName:String?,
    val secondName:String?
)
data class LoginRequest(
    val email:String,
    val password: String
)
data class LoginResponse(
    val token:String
)
data class ApiResponse(val status:Int, val message:JvmType.Object, val result:JvmType.Object)