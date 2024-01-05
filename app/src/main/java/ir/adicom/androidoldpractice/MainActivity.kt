package ir.adicom.androidoldpractice

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.PopupMenu
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.gson.GsonBuilder
import dagger.hilt.android.AndroidEntryPoint
import ir.adicom.androidoldpractice.data.repository.UserRepositoryImpl
import ir.adicom.androidoldpractice.data.source.network.AppService
import ir.adicom.androidoldpractice.databinding.ActivityMainBinding
import ir.adicom.androidoldpractice.domain.model.Response
import ir.adicom.mylibrary.CustomUser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val BASE_URL = "https://apitester.ir/api/"

        val apiService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AppService::class.java)

        val userRepository = UserRepositoryImpl(apiService)

        CoroutineScope(Dispatchers.IO).launch {
            val res = userRepository.loginUser()

            if (res is Response.Success) {
                Log.d(
                    "TAG",
                    "onCreate: ${res.data}"
                )
            } else if (res is Response.Error) {
                Log.e(
                    "TAG",
                    "onCreate: $res"
                )
            }
//            val response = retrofit.loginUser("ali", "1234")
//
//            if (response.isSuccessful) {
//                launch(Dispatchers.Main) {
//                    Log.d(
//                        "TAG",
//                        "onCreate: ${
//                            GsonBuilder().setPrettyPrinting().create().toJson(response.body())
//                        }"
//                    )
//                }
//            }
        }
    }
}