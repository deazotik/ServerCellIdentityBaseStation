package ru.maksim.cellidentityinfo

import io.ktor.client.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ru.maksim.cellidentityinfo.model.BaseStation
import ru.maksim.cellidentityinfo.routes.registerlocationrouts
import ru.maksim.cellidentityinfo.routes.registersstationRouts
import ru.maksim.cellidentityinfo.routes.registersuserRouts


fun main() {
    embeddedServer(Netty, port = 8080) {
        install(ContentNegotiation) {
            json()
        }
        routing {
            get  {
                call.respondText("Pobeda")
            }
            /*post("/station") {
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
            }*/
            /*val baseStation = stations.elementAt(0)
                println(baseStation)
                val mcc_mnc = baseStation.substring(0 until 10)*/
        }
        registersstationRouts()
        registersuserRouts()
        registerlocationrouts()
    }
.start(true)
}

