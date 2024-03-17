package ru.maksim.cellidentityinfo.routes

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ru.maksim.cellidentityinfo.model.Users

fun Route.userRouting() {
    route("user"){
        get {
            call.respondText { "user" }
        }
        post {
            call.respond(HttpStatusCode.OK)
            val user = call.receive<List<Users>>()
            println(user)
            for (u in user) {
                var mainlist = arrayListOf<Any>()

                var id = u.id
                mainlist.add(id)

                var name = u.name
                mainlist.add(name)

                var lastName = u.lastName
                mainlist.add(lastName)

                var email = u.email
                mainlist.add(email)

                var number = u.number
                mainlist.add(number)

                println(mainlist)

            }
        }
    }
}


fun Application.registersuserRouts() {
    routing {
        userRouting()
    }
}