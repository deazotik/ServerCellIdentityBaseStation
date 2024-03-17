package ru.maksim.cellidentityinfo.routes

import com.sun.tools.javac.Main
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ru.maksim.cellidentityinfo.model.BaseStation

fun Route.stationRouting() {
    route("stations"){
        get {
            call.respondText { "stations" }
        }
        post {
            var stations = call.receive<List<BaseStation>>()
            println(stations)
            call.respond(HttpStatusCode.OK)
            /*var mcc_mnc = stations[0].mcc_mnc
            println(mcc_mnc)*/
            for (m in stations) {
                /*var mainlist = mutableListOf("",1)
                mainlist.remove(1)*/
                var mainlist = arrayListOf<Any>()

                var mcc_mnc = m.mcc_mnc
                println(mcc_mnc)
                mainlist.add(mcc_mnc)

                var lac = m.lac
                println(lac)
                mainlist.add(lac)

                var cid = m.cid
                println(cid)
                mainlist.add(cid)

                var bsic_psc_pci = m.bsic_psc_pci
                println(bsic_psc_pci)
                mainlist.add(bsic_psc_pci)

                var asuLevel = m.asuLevel
                println(asuLevel)
                mainlist.add(asuLevel)

                var signalLevel = m.signalLevel
                println(signalLevel)
                mainlist.add(signalLevel)

                var dbm = m.dbm
                println(dbm)
                mainlist.add(dbm)

                var type = m.type
                println(type)
                mainlist.add(type)

                println(mainlist)
            }
        }
    }
}

fun Application.registersstationRouts() {
    routing{
        stationRouting()
    }
}