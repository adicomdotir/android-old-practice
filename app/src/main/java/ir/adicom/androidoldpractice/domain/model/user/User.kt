package ir.adicom.androidoldpractice.domain.model.user

import ir.adicom.androidoldpractice.data.dto.UserDto

data class User(
    var id: Long, var name: String
) {
    fun toEntity(): UserDto {
        return UserDto(id, name)
    }
}