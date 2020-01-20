package com.alanviana

import com.alanviana.resource.usuarios
import com.alanviana.security.JwtConfig
import com.alanviana.security.usuarioLogado
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.websocket.*
import io.ktor.http.cio.websocket.*
import java.time.*
import io.ktor.auth.*
import com.fasterxml.jackson.databind.*
import io.ktor.auth.jwt.jwt
import io.ktor.jackson.*
import io.ktor.features.*
import org.jetbrains.exposed.sql.Database

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)



@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {

    Database.connect("jdbc:postgresql://localhost/conta",driver = "org.postgresql.Driver",
        user = "postgres",
        password = "admin")


    install(io.ktor.websocket.WebSockets) {
        pingPeriod = Duration.ofSeconds(15)
        timeout = Duration.ofSeconds(15)
        maxFrameSize = Long.MAX_VALUE
        masking = false
    }

    install(Authentication) {
        jwt {
            verifier(JwtConfig.verifier)
            validate {
                val usuarioLogado = usuarioLogado(
                    uid = it.payload.getClaim("uid").asString(),
                    name = it.payload.getClaim("uid").asString(),
                    iat = it.payload.getClaim("uid").asString()
                )
                usuarioLogado
            }
        }
    }

    install(ContentNegotiation) {
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
        }
    }

    routing {

        usuarios()


        get("/") {
            call.respondText("HELLOU WORLD!", contentType = ContentType.Text.Plain)
        }

        webSocket("/myws/echo") {
            send(Frame.Text("Hi from server"))
            while (true) {
                val frame = incoming.receive()
                if (frame is Frame.Text) {
                    send(Frame.Text("Client said: " + frame.readText()))
                }
            }
        }

        get("/json/jackson") {
            call.respond(mapOf("hello" to "world"))
        }
    }
}

