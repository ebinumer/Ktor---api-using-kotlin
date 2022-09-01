package com.ebinumer.router

import com.ebinumer.data.model.UserDetails
import com.ebinumer.data.model.allUserResponce
import com.ebinumer.data.model.commenResponce
import com.ebinumer.data.model.userResponce
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

val customerStorage = mutableListOf<UserDetails>()

fun Route.users() {
    route("/users") {
        get {
            if (customerStorage.isNotEmpty()) {
                call.respond(allUserResponce(200, true, "Created successfully",customerStorage))
            } else {
                call.respond(commenResponce(200, false, "No User found"))
            }
        }
        get("{id?}") {
            val id = call.parameters["id"] ?: return@get call.respond(
                commenResponce(
                    201,
                    false,
                    "Id is missing"
                )
            )
            val customer =
                customerStorage.find { it.id == id } ?: return@get call.respond(
                    commenResponce(
                        404,
                        false,
                        "No customer with id $id"
                    )
                )

            call.respond(customer)
        }
        post {
            val customer = call.receive<UserDetails>()
            customerStorage.add(customer)

             if(customer.firstName.isEmpty())
                call.respond(commenResponce(201, false, "FirstName is missing"))
            else if(customer.lastName.isEmpty())
                call.respond(commenResponce(201, false, "LastName is missing"))
            else if(customer.email.isEmpty())
                call.respond(commenResponce(201, false, "Email is missing"))
            else
            call.respond(userResponce(200, true, "Created successfully",customer))

        }
        delete("{id?}") {
            val id = call.parameters["id"] ?: return@delete call.respond(
                commenResponce(
                    400, false, "Bad Request"
                )
            )
            if (customerStorage.removeIf { it.id == id }) {
                call.respond(commenResponce(202, true, "user deleted successfully"))
            } else {
                call.respond(commenResponce(404, false, "user not found"))

            }
        }
    }
}
