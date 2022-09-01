package com.ebinumer.data.model

import kotlinx.serialization.Serializable

@Serializable
data class UserDetails(
//    @PrimaryKey(autoGenerate = true)
    val id: String,
    val firstName: String,
    val lastName: String,
    val email: String
)

@Serializable
data class userResponce(
    val statusCode: Int,
    val success: Boolean,
    val message: String,
    val data: UserDetails
)

@Serializable
data class allUserResponce(
    val statusCode: Int,
    val success: Boolean,
    val message: String,
    val data: MutableList<UserDetails>
)

@Serializable
data class commenResponce(
    val statusCode: Int,
    val success: Boolean,
    val message: String,

    )