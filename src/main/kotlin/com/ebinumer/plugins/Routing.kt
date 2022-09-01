package com.ebinumer.plugins

import com.ebinumer.router.MyFishes
import com.ebinumer.router.users
import io.ktor.server.routing.*
import io.ktor.server.http.content.*
import io.ktor.server.application.*

fun Application.configureRouting() {
    

    routing {
        MyFishes()
        users()
        // Static plugin. Try to access `/static/index.html`
        static {
            resources("static")
        }
    }
}
