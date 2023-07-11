package com.example.rickymorty

import com.example.rickymorty.models.Character
import com.example.rickymorty.models.Episode
import retrofit2.Call
import retrofit2.http.GET

interface RickAndMortyAPI {

    @GET("character")
    fun getCharacter(): Call<Character>

}