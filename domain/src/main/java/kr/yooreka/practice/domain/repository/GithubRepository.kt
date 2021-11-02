package kr.yooreka.practice.domain.repository

import io.reactivex.rxjava3.core.Single
import kr.yooreka.practice.domain.model.ReposVO
import kr.yooreka.practice.domain.model.UserVO

interface GithubRepository {
    fun searchUser(query : String, page : Int) : Single<List<UserVO>>
    fun getRepositories(userName : String) : Single<List<ReposVO>>
}