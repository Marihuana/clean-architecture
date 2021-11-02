package kr.yooreka.practice.domain.repository

import androidx.paging.PagingData
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single
import kr.yooreka.practice.domain.model.ReposVO
import kr.yooreka.practice.domain.model.UserVO


interface GithubRepository {
    fun searchUser(query : String, page : Int) : Flowable<PagingData<UserVO>>
    fun getRepositories(userName : String) : Flowable<PagingData<ReposVO>>
}