package ar.com.kotlin.poc.service

import ar.com.kotlin.poc.controller.dto.UserDTO
import ar.com.kotlin.poc.domain.User
import ar.com.kotlin.poc.repository.UserRepository
import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ar.com.kotlin.poc.security.util.hash

@Service
class UserService {

    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var mapper: ModelMapper

    fun getUsers(): List<UserDTO> {
        return userRepository.findAll().map{user -> mapper.map(user, UserDTO::class.java)}
    }

    fun create(userDTO: UserDTO) : UserDTO{
        userDTO.password = hash(userDTO.password)
        return mapper.map(userRepository.save(mapper.map(userDTO, User::class.java)), UserDTO::class.java)
    }


}