package com.example.javapop.java_pop.data.model

import com.google.gson.annotations.SerializedName

data class PullRequest(
        @field:SerializedName("title") val title: String,
        @field:SerializedName("created_at") val created_at: String,
        @field:SerializedName("body") val body: String,
        @field:SerializedName("user") val owner: Owner
)