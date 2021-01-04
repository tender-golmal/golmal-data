package com.golmal.data.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

@Document("users")
data class UserProfile(
    @Id
    val id:String?,
    @Email
    val email:String,
    var firstName:String?,
    var lastName:String?,
    @NotEmpty
    val roles:List<Role>,
    @NotBlank
    var password:String,
    var provider:String?,
    var providerId:String?
)
enum class RoleType{
    ROLE_USER,
    ROLE_MODERATOR,
    ROLE_ADMIN
}
@Document("roles")
data class Role(
    @Id val id:Int?,
    var role:RoleType
)