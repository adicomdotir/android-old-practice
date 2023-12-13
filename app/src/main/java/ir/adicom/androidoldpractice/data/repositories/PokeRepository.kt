package ir.adicom.androidoldpractice.data.repositories

import ir.adicom.androidoldpractice.data.datasources.PokeService
import ir.adicom.androidoldpractice.data.models.PokeListResponse
import ir.adicom.androidoldpractice.utils.Constants
import ir.adicom.androidoldpractice.utils.ViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PokeRepository @Inject constructor(private val pokeService: PokeService) {
    suspend fun fetchPokemonData(): Flow<ViewState<PokeListResponse>> {
        return flow {
            val list = pokeService.getPokemons()
            emit(ViewState.success(list))
        }.flowOn(Dispatchers.IO)
    }

    suspend fun fetchPokemonsByOffset(offset: Int): Flow<ViewState<PokeListResponse>> {
        return flow {
            val list =
                pokeService.getPokemonsByOffset(limit = Constants.LIMIT_POKEMONS, offset = offset)
            emit(ViewState.success(list))
        }.flowOn(Dispatchers.IO)
    }
}