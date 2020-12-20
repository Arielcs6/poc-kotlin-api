package ar.com.kotlin.poc.controller

import ar.com.kotlin.poc.controller.dto.LoginDTO
import ar.com.kotlin.poc.repository.UserRepository
import ar.com.kotlin.poc.service.AuthService
import ar.com.kotlin.poc.service.TokenService
import org.jose4j.http.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class AuthController {

    @Autowired
    lateinit var authService: AuthService

    @PostMapping("/login")
    fun login( @RequestBody request: LoginDTO): ResponseEntity<String> = authService.login(request)

}