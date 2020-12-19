package ar.com.kotlin.poc.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
@RequestMapping("/user")
class UserController {

    @GetMapping
    fun greeting(): String {
        return "hello world pete"
    }

}