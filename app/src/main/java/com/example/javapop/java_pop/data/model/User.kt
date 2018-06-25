package com.example.javapop.java_pop.data.model

import com.google.gson.annotations.SerializedName
import retrofit2.http.Field

data class User {
    @field:SerializedName("login")     val login: String,
    @field:SerializedName("avatar_url") val avatar_url: String,
    @field:SerializedName("title")     val title: String,
    @field:SerializedName("created_at")     val created_at: String,
    @field:SerializedName("body")     val body: String
}