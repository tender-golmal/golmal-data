package com.golmal.data.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document("users")
data class UserProfile(
    @Id
    val id:String,
    val email:String,
    var firstName:String?,
    var lastName:String?,
    @DBRef val roles:List<Role>,
    var password:String
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