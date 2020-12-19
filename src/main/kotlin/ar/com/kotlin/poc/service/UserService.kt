package ar.com.kotlin.poc.service

import ar.com.kotlin.poc.domain.User
import ar.com.kotlin.poc.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    lateinit var userRepository: UserRepository

    fun getUsers(): List<User> {
        return userRepository.findAll()
    }
}