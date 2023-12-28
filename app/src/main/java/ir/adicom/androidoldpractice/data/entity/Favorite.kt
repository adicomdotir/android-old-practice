package ir.adicom.androidoldpractice.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "fav")
data class Favorite(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "meals_id") var mealsId: Int,
    @ColumnInfo(name = "meals_adi") val mealsName: String,
    @ColumnInfo(name = "meals_image_adi") val mealsImageName: String
) : Serializable

