package com.example.javapop.java_pop.data.source

import com.example.javapop.java_pop.data.model.PullRequest
import com.example.javapop.java_pop.data.model.RepositoryResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface GithubAPI {

    @GET("/search/repositories?q=language:Java&sort=stars&page=1")
    fun getRepositories(): Observable<RepositoryResponse>

    @GET("/repos/<criador>/<repositório>/pulls")
    fun getPullRequestByRepository(): Observable<List<PullRequest>>

}