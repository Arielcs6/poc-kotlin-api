package ar.com.kotlin.poc.service

import ar.com.kotlin.poc.controller.dto.UserDTO
import ar.com.kotlin.poc.domain.User
import ar.com.kotlin.poc.repository.UserRepository
import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class UserService {

    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var mapper: ModelMapper

    fun getUsers(): List<UserDTO> {
        return userRepository.findAll()
            .stream()
            .map { user -> mapper.map(user, UserDTO::class.java) }
            .collect(Collectors.toList())
    }

}