package ir.adicom.androidoldpractice.domain.repository

import ir.adicom.androidoldpractice.domain.model.Response
import ir.adicom.androidoldpractice.domain.model.user.User

interface UserRepository {
    suspend fun loginUser(): Response<User>
}