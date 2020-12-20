package ar.com.kotlin.poc.service

import ar.com.kotlin.poc.controller.dto.LoginDTO
import ar.com.kotlin.poc.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import ar.com.kotlin.poc.security.util.hash

@Service
class AuthService {

    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var tokenService: TokenService

    fun login(request: LoginDTO): ResponseEntity<String> {
        var user = userRepository.findByName(request.userName).orElseThrow { Exception("user not exists") }
        if (user.password == hash(request.password)) {
            val token = tokenService.generateToken(request.userName)
            var responseHeaders = HttpHeaders();
            responseHeaders.set("tokenKey", token);
            return ResponseEntity("Login successful", responseHeaders, HttpStatus.CREATED)
        } else {
            throw Exception("User or password incorrect")
        }
    }
}