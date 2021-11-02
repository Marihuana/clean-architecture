package kr.yooreka.practice.domain.model

import java.io.Serializable

data class UserVO (
    val _id : Long,
    val name : String,
    val thumbUrl : String) : Serializable