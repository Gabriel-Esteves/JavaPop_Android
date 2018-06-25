package com.example.javapop.java_pop.data.source

import com.example.javapop.java_pop.data.model.User
import com.example.javapop.java_pop.data.model.Repository
import io.reactivex.Observable
import retrofit2.http.GET

interface GithubAPI {

    @GET("https://api.github.com/search/repositories?q=language:Java&sort=stars&page=1")
    fun getRepositories(): Observable<Repository>

    @GET("https://api.github.com/repos/<criador>/<repositório>/pulls")
    fun getPullRequestByRepository(): Observable<User>

}