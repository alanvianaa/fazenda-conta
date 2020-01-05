package com.alanviana.security

import com.alanviana.model.Usuario
import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import io.ktor.auth.Principal
import java.util.*

object JwtConfig {
    private const val secret = "secret"
    private val algorithm = Algorithm.HMAC256(secret)
    val verifier: JWTVerifier = JWT
        .require(algorithm)
        .build()
}
data class usuarioLogado(
    val uid: String,
    val name: String,
    val iat: String
) : Principal
