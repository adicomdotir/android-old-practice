package ir.adicom.androidoldpractice.data.source.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ir.adicom.androidoldpractice.data.entity.Favorite

@Dao
interface FavoriteDao {
    @Query("SELECT * FROM fav")
    suspend fun getFavorites(): List<Favorite>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(favorite: Favorite)

    @Delete
    suspend fun deleteFavorite(favorite: Favorite)


    @Query("SELECT * FROM fav WHERE meals_adi like '%' || :searchKeyword || '%' ")
    suspend fun searchFavorite(searchKeyword: String): List<Favorite>

}