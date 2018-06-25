package com.example.javapop.java_pop.model

import com.google.gson.annotations.SerializedName

data class Repository(
        @field:SerializedName("name") val name: String,
        @field:SerializedName("description") val description: String,
        @field:SerializedName("stargazers_count") val stargazersCount: Int,
        @field:SerializedName("forks_count") val forksCount: Int,
        @field:SerializedName("owner") val owner: Owner
)