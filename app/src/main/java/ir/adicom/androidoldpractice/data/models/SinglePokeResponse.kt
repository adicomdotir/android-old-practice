package ir.adicom.androidoldpractice.data.models

import com.google.gson.annotations.SerializedName

data class SinglePokeResponse(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String,
)
