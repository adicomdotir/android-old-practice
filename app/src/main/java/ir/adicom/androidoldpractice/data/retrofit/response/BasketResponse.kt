package ir.adicom.androidoldpractice.data.retrofit.response

import com.google.gson.annotations.SerializedName
import ir.adicom.androidoldpractice.data.retrofit.response.BasketMealResponse

data class BasketResponse(
    @SerializedName("sepet_yemekler") val meals: List<BasketMealResponse>,
    @SerializedName("success") val success: Int
)