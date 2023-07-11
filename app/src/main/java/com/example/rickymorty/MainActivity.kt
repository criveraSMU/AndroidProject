package com.example.rickymorty
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.converter.gson.GsonConverterFactory
import com.example.rickymorty.databinding.ActivityMainBinding
import com.example.rickymorty.models.Character
import com.example.rickymorty.models.Episode
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit


const val BASE_URL = "https://rickandmortyapi.com/api/"
class MainActivity : AppCompatActivity() {

    lateinit var myAdapter: MyAdapter
    lateinit var  linearLayoutManager: LinearLayoutManager
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var recyclerview = findViewById<RecyclerView>(R.id.recylcerView)
        recyclerview.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerview.layoutManager = linearLayoutManager
        getMyData()
    }

    private fun getMyData() {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(RickAndMortyAPI::class.java)

        // LLAMANDO A LOS PERSONAJES
        val callCharacter = service.getCharacter()
        callCharacter.enqueue(object : Callback<Character> {
            override fun onResponse(call: Call<Character>, response: Response<Character>) {
                if (response.isSuccessful) {
                    val characterResponse = response.body()
                    if (characterResponse != null) {
                        myAdapter = MyAdapter(baseContext,characterResponse.results)
                        myAdapter.notifyDataSetChanged()
                        var recyclerview = findViewById<RecyclerView>(R.id.recylcerView)
                        recyclerview.adapter = myAdapter
                    }
                } else {
                    println("Error: ${response.code()}")
                }
            }
            override fun onFailure(call: Call<Character>, t: Throwable) {

            }
        })

        }
}

