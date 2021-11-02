package kr.yooreka.practice.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.rxjava3.flowable
import io.reactivex.rxjava3.core.Flowable
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kr.yooreka.practice.data.repository.paging.ReposPagingSource
import kr.yooreka.practice.data.repository.paging.UserPagingSource
import kr.yooreka.practice.data.service.GithubService
import kr.yooreka.practice.domain.model.ReposVO
import kr.yooreka.practice.domain.model.UserVO
import kr.yooreka.practice.domain.repository.GithubRepository
import javax.inject.Inject

@ExperimentalCoroutinesApi
class GithubRepositoryImpl @Inject constructor(private val service : GithubService) : GithubRepository {
    private val pageSize = 20

    override fun searchUser(query: String, page: Int): Flowable<PagingData<UserVO>> {
        return Pager(PagingConfig(pageSize)){
            UserPagingSource(service).apply { this.query = query }
        }.flowable
    }

    override fun getRepositories(userName: String): Flowable<PagingData<ReposVO>> {
        return Pager(PagingConfig(pageSize)){
            ReposPagingSource(service).apply { this.query = userName }
        }.flowable
    }
}