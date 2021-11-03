package kr.yooreka.practice.data.entity

import com.google.gson.annotations.SerializedName

data class ReposRes(
    @SerializedName("id") var id : Long,
    @SerializedName("name") var name : String,
    @SerializedName("owner") var user : ItemData,
    @SerializedName("description") var description : String?,
    @SerializedName("language") var language : String
)
