package com.alanviana.model

import org.jetbrains.exposed.sql.Table

object UsuarioContas : Table("usuario_contas") {
    val id = uuid("id")
    val idConta = uuid("id_conta").references(Contas.id)
    val idUsuario = uuid("id_usuario").references(Usuarios.id)
}
