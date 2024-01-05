package ir.adicom.androidoldpractice.data.dto

import com.google.gson.annotations.SerializedName

data class UserDtoX(
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("password")
    val password: Any,
    @SerializedName("role")
    val role: String,
    @SerializedName("token")
    val token: String,
    @SerializedName("username")
    val username: String
)