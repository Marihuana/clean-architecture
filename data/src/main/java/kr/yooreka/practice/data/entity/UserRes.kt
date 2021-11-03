package kr.yooreka.practice.data.entity

import com.google.gson.annotations.SerializedName

data class UserRes (
    @SerializedName("total_count") var total : Long,
    @SerializedName("items") var items : List<ItemData>
)

data class ItemData(
    @SerializedName("id") var _id : Long,
    @SerializedName("type") var type : String,
    @SerializedName("login") var name : String,
    @SerializedName("avatar_url") var thumb : String,

)