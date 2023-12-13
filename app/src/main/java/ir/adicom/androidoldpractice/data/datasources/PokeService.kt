package ir.adicom.androidoldpractice.data.datasources

import ir.adicom.androidoldpractice.data.models.PokeListResponse
import ir.adicom.androidoldpractice.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface PokeService {
    @GET("${Constants.BASE_URL}${Constants.END_POINT_POKEMONS}")
    suspend fun getPokemons(): PokeListResponse

    @GET("pokemon/")
    suspend fun getPokemonsByOffset(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): PokeListResponse
}
