package ir.adicom.androidoldpractice.data.source.remote

import androidx.room.Database
import androidx.room.RoomDatabase
import ir.adicom.androidoldpractice.data.entity.Favorite
import ir.adicom.androidoldpractice.data.source.local.FavoriteDao

@Database(entities = [Favorite::class], version = 1)
abstract class MyDatabase : RoomDatabase() {
    abstract fun getFavoritesDao() : FavoriteDao
}