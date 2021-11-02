package kr.yooreka.practice.data.datastore

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiModule {
    const val BASE_URL : String = "https://api.github.com/"
    const val TIMEOUT_CONNECT = 10L
    const val TIMEOUT_READ = 10L
    const val TIMEOUT_WRITE = 10L

    fun provideOkHttpClient() = OkHttpClient.Builder()
        .addNetworkInterceptor(
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.NONE
            }
        )
        .addInterceptor {
            it.proceed(
                it.request().run {
                    newBuilder().apply {
                        addHeader("Accept", "application/vnd.github.v3+json")
                    }.build()
                }
            )
        }
        .connectTimeout(TIMEOUT_CONNECT, TimeUnit.SECONDS)
        .readTimeout(TIMEOUT_READ, TimeUnit.SECONDS)
        .build()

    fun provideRetrofit(okHttpClient: OkHttpClient, BASE_URL:String): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(okHttpClient)
            .build()

    fun provideApiService(retrofit: Retrofit) : GithubService = retrofit.create(GithubService::class.java)
}