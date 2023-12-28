package ir.adicom.androidoldpractice.data.source.remote

import ir.adicom.androidoldpractice.data.retrofit.response.BasketResponse
import ir.adicom.androidoldpractice.data.retrofit.response.MealListResponse
import ir.adicom.androidoldpractice.data.retrofit.response.MealOperationResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("yemekler/tumYemekleriGetir.php")
    suspend fun getMeals(): MealListResponse

    @POST("yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    suspend fun addMeals(
        @Field("yemek_adi") mealsName: String,
        @Field("yemek_resim_adi") mealsImageName: String,
        @Field("yemek_fiyat") mealsPrice: Int,
        @Field("yemek_siparis_adet") mealsOrderPiece: Int,
        @Field("kullanici_adi") userName: String
    ): MealOperationResponse

    @POST("yemekler/sepettekiYemekleriGetir.php")
    @FormUrlEncoded
    suspend fun getMeals(@Field("kullanici_adi") userName: String): BasketResponse

    @POST("yemekler/sepettenYemekSil.php")
    @FormUrlEncoded
    suspend fun delete(
        @Field("kullanici_adi") userName: String,
        @Field("sepet_yemek_id") basketMealId: Int
    ): MealOperationResponse

}