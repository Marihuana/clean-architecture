package kr.yooreka.practice.data.mapper

import io.reactivex.rxjava3.core.Single
import kr.yooreka.practice.data.entity.ReposRes
import kr.yooreka.practice.data.entity.UserRes
import kr.yooreka.practice.domain.model.ReposVO
import kr.yooreka.practice.domain.model.UserVO

object UserMapper{
    fun transform(res : UserRes) : List<UserVO>{
        return res.items.filter {
            it.type == "User"
        }.map {
            UserVO(it._id, it.name, it.thumb)
        }
    }
}

object ReposMapper {
    fun transform(res : List<ReposRes>) : List<ReposVO>{
        return res.map { ReposVO(it.id, it.name, it.user.name, it.description) }
    }
}