package com.alanviana.service

import com.alanviana.model.*
import org.jetbrains.exposed.sql.`java-time`.datetime
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import java.time.LocalDateTime
import java.util.*

fun addUsuario(newUsuario: NewUsuario) {
    transaction {

        Usuarios.insert {
            it[id] = UUID.randomUUID()
            it[idAuth] = newUsuario.idAuth
            it[email] = newUsuario.email
            it[nome] = newUsuario.nome
            it[telefone] = newUsuario.telefone
            it[ativo] = newUsuario.ativo

        }

    }
}

