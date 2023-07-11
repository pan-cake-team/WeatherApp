package data.dto

import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse(
    val code: String
)