package com.nazlicanterliksiz.movieapp.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

data class MovieModel(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int,
)