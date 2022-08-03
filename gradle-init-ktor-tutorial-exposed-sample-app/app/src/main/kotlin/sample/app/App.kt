package sample.app

import io.ktor.server.application.*
import sample.app.plugins.*
import sample.app.dao.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    DatabaseFactory.init()
    configureRouting()
    configureSerialization()
}