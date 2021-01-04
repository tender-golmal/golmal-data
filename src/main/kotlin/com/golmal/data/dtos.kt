package com.golmal.data.dto

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

data class RegisterRequest(
    @Email
    var email:String,
    @NotBlank
    var password:String,
    var firstName:String?,
    var secondName:String?,
    var provider:String?,
    var providerId:String?
)
data class LoginRequest(
    @Email
    val email:String,
    @NotBlank
    val password: String
)
data class LoginResponse(
    val token:String
)
data class ApiResponse(val status:Int, val message:Any, val result:Any)