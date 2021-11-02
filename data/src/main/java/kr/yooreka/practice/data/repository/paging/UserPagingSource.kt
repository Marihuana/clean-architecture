package kr.yooreka.practice.data.repository.paging

import androidx.paging.PagingState
import androidx.paging.rxjava3.RxPagingSource
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import kr.yooreka.practice.data.mapper.UserMapper
import kr.yooreka.practice.data.service.GithubService
import kr.yooreka.practice.domain.model.UserVO
import javax.inject.Inject


class UserPagingSource @Inject constructor(private val service: GithubService) : RxPagingSource<Int, UserVO>(){
    private val pageSize = 30
    var query : String = ""

    override fun getRefreshKey(state: PagingState<Int, UserVO>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
            ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, UserVO>> {
        val page = params.key ?: 1

        return service.searchUser(query, page)
            .subscribeOn(Schedulers.io())
            .map ( UserMapper::transform )
            .map { toLoadResult(page, it) }
            .onErrorReturn { LoadResult.Error(it) }
    }

    private fun toLoadResult(page : Int, list : List<UserVO>) : LoadResult<Int, UserVO>{
        return LoadResult.Page(
            data = list,
            prevKey = null,
            nextKey = page + (list.size / pageSize)
        )
    }
}