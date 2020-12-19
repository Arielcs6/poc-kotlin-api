package ar.com.kotlin.poc.controller

import ar.com.kotlin.poc.domain.User
import ar.com.kotlin.poc.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
@RequestMapping("/user")
class UserController {

    @Autowired
    lateinit var userService:UserService

    @GetMapping
    fun getUsers(): List<User> {
        return userService.getUsers()
    }

}