package kr.yooreka.practice.data.datastore

import io.reactivex.rxjava3.core.Single
import kr.yooreka.practice.data.entity.ReposRes
import kr.yooreka.practice.data.entity.UserRes
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubService {
    @GET("search/users")
    fun searchUser(@Query("q") query : String,
                   @Query("page") page : Int) : Single<UserRes>

    @GET("users/{user}/repos")
    fun getRepositories(@Path("user") user : String) : Single<List<ReposRes>>
}
