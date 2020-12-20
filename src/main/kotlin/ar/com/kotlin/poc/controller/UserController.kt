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
    fun find() = userService.find()

    @GetMapping("/{userId}")
    fun find(@PathVariable userId: String) = userService.find(userId)

    @PostMapping
    fun createUser(@RequestBody userDTO: UserDTO) = userService.create(userDTO)

    @DeleteMapping("/{userId}")
    fun deleteUser(@PathVariable userId: String) = userService.delete(userId)

    @PutMapping
    fun updateUser(@RequestBody userDTO: UserDTO) = userService.update(userDTO)

}