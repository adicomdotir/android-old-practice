package ir.adicom.androidoldpractice.data.source.network

import ir.adicom.androidoldpractice.data.dto.UserDtoX
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Query

interface AppService {
    @POST("Users/authenticate")
    suspend fun loginUser(@Query("userName") user: String, @Query("password") password: String): Response<UserDtoX>
}