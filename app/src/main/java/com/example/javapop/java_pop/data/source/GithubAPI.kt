package com.example.javapop.java_pop.data.source

import com.example.javapop.java_pop.data.model.PullRequest
import com.example.javapop.java_pop.data.model.RepositoryResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubAPI {

    @GET("/search/repositories?q=language:Java&sort=stars&page=1")
    fun getRepositories(): Observable<RepositoryResponse>

    @GET("/repos/{owner}/{repository}/pulls")
    fun getPullRequestByRepository(@Path("owner") owner: String, @Path("repository") repository: String): Observable<List<PullRequest>>

}