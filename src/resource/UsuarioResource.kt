package com.alanviana.resource

import com.alanviana.model.Conta
import com.alanviana.model.Usuario
import io.ktor.application.call
import io.ktor.auth.AuthenticationPipeline
import io.ktor.auth.authenticate
import io.ktor.auth.parseAuthorizationHeader
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.route
import io.ktor.routing.get
import java.time.LocalDateTime
import java.util.*

fun Route.usuarios(){
    authenticate {
        route("/usuarios") {

            var conta = Conta(
                UUID.randomUUID(),
                "Rua 11",
                "27",
                null,
                "Nova Vila",
                "74653140",
                "Goiania",
                "GO",
                "(62) 981000806"
            )
            var listConta = listOf(conta)
            var listTags = listOf<String>("alterar:nome", "exclui:conta")

            var usuario = Usuario(
                UUID.randomUUID(),
                "P6zUR8nW14UNttECWiTLA7cPLbI3",
                "contato@alanviana.com",
                "Alan Viana",
                "(62) 98100-0806",
                true,
                LocalDateTime.now(),
                listConta,
                listTags
            )

            get {
                call.respond(HttpStatusCode.OK, usuario)
            }
        }
    }
}