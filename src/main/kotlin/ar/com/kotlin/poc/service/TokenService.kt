package ar.com.kotlin.poc.service

import org.jose4j.jwt.JwtClaims
import org.jose4j.jwt.consumer.JwtConsumer
import org.jose4j.jwt.consumer.JwtConsumerBuilder
import org.springframework.stereotype.Service
import org.jose4j.jwk.RsaJwkGenerator
import org.jose4j.jws.AlgorithmIdentifiers
import org.jose4j.jws.JsonWebSignature

@Service
class TokenService {

    val rsaJsonWebKey = RsaJwkGenerator.generateJwk(2048)
    val jwtConsumer: JwtConsumer = JwtConsumerBuilder().setVerificationKey(rsaJsonWebKey.key).setRequireExpirationTime().build()

    fun generateToken(userName: String): String{

        val claims = JwtClaims()
        claims.setIssuedAtToNow()
        claims.setClaim("userName", userName)
        claims.setIssuedAtToNow()
        claims.setExpirationTimeMinutesInTheFuture(10.0f)

        val jws = JsonWebSignature()
        jws.payload = claims.toJson()
        jws.key = rsaJsonWebKey.privateKey
        jws.keyIdHeaderValue = rsaJsonWebKey.keyId
        jws.algorithmHeaderValue = AlgorithmIdentifiers.RSA_USING_SHA256

        return jws.compactSerialization
    }
}