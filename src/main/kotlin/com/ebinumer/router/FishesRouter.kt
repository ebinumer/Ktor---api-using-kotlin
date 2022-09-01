package com.ebinumer.router


import com.ebinumer.data.model.UserDetails
import com.ebinumer.data.model.fishesData
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

private const val BASE_URL = "http://202.164.145.245:8010"

private val myFishes = listOf(
    fishesData(1,"Gold fish","it is a beautiful fish","/fishes/gold.jpg"),
    fishesData(2,"Angle","it is a beautiful fish","/fishes/Jordanella_floridae.jpg")
)



fun Route.MyFishes() {
    get("/my_fishes") {
        call.respond(HttpStatusCode.OK,
            myFishes)
    }
}