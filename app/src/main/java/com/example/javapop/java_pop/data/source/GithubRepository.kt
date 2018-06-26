package com.example.javapop.java_pop.data.source

import com.example.javapop.java_pop.data.model.PullRequest
import com.example.javapop.java_pop.data.model.RepositoryResponse
import io.reactivex.Observable

class GithubRepository {

    private val githubRepository = RetrofitClient.getRetrofitClient()

    fun getRepositories(): Observable<RepositoryResponse> {
        return githubRepository.getRepositories()
    }

    fun getPullRequestByRepository(): Observable<List<PullRequest>> {
        return githubRepository.getPullRequestByRepository()
    }

}