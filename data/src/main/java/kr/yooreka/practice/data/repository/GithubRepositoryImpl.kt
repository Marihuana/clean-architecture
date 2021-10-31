package kr.yooreka.practice.data.repository

import io.reactivex.rxjava3.core.Single
import kr.yooreka.practice.data.mapper.ReposMapper
import kr.yooreka.practice.data.mapper.UserMapper
import kr.yooreka.practice.data.datastore.GithubService
import kr.yooreka.practice.domain.model.ReposVO
import kr.yooreka.practice.domain.model.UserVO
import kr.yooreka.practice.domain.repository.GithubRepository
import javax.inject.Inject

class GithubRepositoryImpl @Inject constructor(private val service : GithubService) : GithubRepository {
    override fun searchUser(query: String, page: Int): Single<List<UserVO>> {
        return service.searchUser(query, page)
            .map(UserMapper::transform)
    }

    override fun getRepositories(userName: String): Single<List<ReposVO>> {
        return service.getRepositories(userName)
            .map(ReposMapper::transform)
    }
}