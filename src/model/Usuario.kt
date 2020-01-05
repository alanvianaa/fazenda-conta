package com.alanviana.model

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.`java-time`.datetime
import java.time.LocalDateTime
import java.util.*

data class Usuario (
    val id: UUID?,
    val idAuth: String?, //uid from firebase
    val email: String,
    val nome: String,
    val telefone: String,
    val ativo: Boolean,
    val dtCadastro: LocalDateTime,
    val contas: List<Conta>,
    val tags: List<String>
)

object Usuarios : Table("usuario") {
    val id = uuid("id").primaryKey()
    val idAuth = text("id_auth")
    val email = text("email")
    val nome = text("nome")
    val telefone = text("telefone").nullable()
    val ativo = bool("ativo")
    val dtCadastro = datetime("dt_cadastro")
}

