package com.example.rickymorty.models

import com.example.rickymorty.models.Location

data class Result(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)