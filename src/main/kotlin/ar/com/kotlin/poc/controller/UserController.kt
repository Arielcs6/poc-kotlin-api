package ar.com.kotlin.poc.controller

import ar.com.kotlin.poc.controller.dto.UserDTO
import ar.com.kotlin.poc.domain.User
import ar.com.kotlin.poc.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.concurrent.atomic.AtomicLong

@RestController
@RequestMapping("/user")
class UserController {

    @Autowired
    lateinit var userService:UserService

    @GetMapping
    fun getUsers() = userService.getUsers()

/*
    @PostMapping
    fun createUser() : UserDTO {

    }
*/


}