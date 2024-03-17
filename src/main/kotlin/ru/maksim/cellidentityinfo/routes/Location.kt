package ru.maksim.cellidentityinfo.routes

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ru.maksim.cellidentityinfo.model.Location

fun Route.locationRouting() {
    route("/location") {
        get {
            call.respondText { "pobeda" }
        }
        post {
            var location = call.receive<List<Location>>()
            for (l in location) {
                var mainlist = arrayListOf<Any>()

                var idlocation = l.idlocation
                mainlist.add(idlocation)

                var latitude = l.latitude
                mainlist.add(latitude)

                var longtitude = l.longtitude
                mainlist.add(longtitude)

                var time = l.time
                mainlist.add(time)

            }
        }
    }
}

fun Application.registerlocationrouts() {
    routing {
        locationRouting()
    }
}