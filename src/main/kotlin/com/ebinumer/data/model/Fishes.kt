package com.ebinumer.data.model
import kotlinx.serialization.Serializable

@Serializable
data class fishesData(
    val fish_id:Int,
    val fish_name:String,
    val description:String,
    val image_url:String
)
