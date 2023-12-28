package ir.adicom.androidoldpractice.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ir.adicom.androidoldpractice.data.repositories.MealsRepository
import ir.adicom.androidoldpractice.data.source.local.FavoriteDao
import ir.adicom.androidoldpractice.data.source.remote.ApiService
import ir.adicom.androidoldpractice.data.source.remote.MyDatabase
import ir.adicom.androidoldpractice.utils.AppConstants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn (SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideMealsDataSource(mealsDatasource: ApiService, favoriteDao: FavoriteDao): MealsRepository {
        return MealsRepository(mealsDatasource,favoriteDao)
    }

    @Provides
    @Singleton
    fun provideMealsDao(): ApiService {
        return Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideFavoriteDao(@ApplicationContext context: Context): FavoriteDao {
        val vt = Room.databaseBuilder(context, MyDatabase::class.java,"fav.sqlite").createFromAsset("fav.sqlite").build()
        return vt.getFavoritesDao()
    }
}