package com.alanviana.model

import org.jetbrains.exposed.sql.Table

object UsuarioTags  : Table("usuario_tags") {
    val tag = text("tag").index()
    val idUsuarioContas = uuid("id_usuario_contas").references(UsuarioContas.id)
}