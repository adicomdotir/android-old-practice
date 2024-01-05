package ir.adicom.androidoldpractice.data.repository

import ir.adicom.androidoldpractice.data.source.network.AppService
import ir.adicom.androidoldpractice.domain.model.Response
import ir.adicom.androidoldpractice.domain.model.user.User
import ir.adicom.androidoldpractice.domain.repository.UserRepository

class UserRepositoryImpl(private val appService: AppService) :
    UserRepository {
    override suspend fun loginUser(): Response<User> {
        val response = appService.loginUser("ali", "1234")
        return if (response.isSuccessful) {
            val userDto = response.body()
            Response.Success(
                data = User(
                    userDto?.id?.toLong() ?: 0L,
                    userDto?.firstName ?: ""
                )
            )
        } else {
            Response.Error(Throwable("Unknown Error"))
        }
    }
}