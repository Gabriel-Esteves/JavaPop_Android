package com.example.javapop.java_pop.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Repository(
        @field:SerializedName("name") val name: String,
        @field:SerializedName("description") val description: String,
        @field:SerializedName("stargazers_count") val stargazersCount: Int,
        @field:SerializedName("forks_count") val forksCount: Int,
        @field:SerializedName("owner") val owner: Owner
): Serializable

data class RepositoryResponse(
        @field:SerializedName("items") val items: ArrayList<Repository>
)