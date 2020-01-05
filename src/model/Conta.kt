package com.alanviana.model

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.`java-time`.datetime
import java.util.*

data class Conta(
    val id: UUID?,
    val logradouro: String,
    val numero: String?,
    val complemento: String?,
    val bairro: String,
    val cep: String,
    val cidade: String,
    val uf: String,
    val telefone: String
    )

object Contas : Table(name = "conta") {
    val id = uuid("id_conta").primaryKey()
    val logradouro = text("logradouro")
    val numero = text("numero").nullable()
    val complemento = text("complemento").nullable()
    val bairro = text("bairro")
    val cep = text("cep")
    val cidade = text("cidade")
    val uf = text("uf")
    val telefone = text("telefone").nullable()
    val tipoInscricao = varchar("tipo_inscricao", 2)
    val inscricao = text("inscricao")
    val email = text("email")
    val dtCadastro = datetime("dt_cadastro")
}

