package ar.com.kotlin.poc.repository

import ar.com.kotlin.poc.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : JpaRepository<User, String> {
    fun findByName(userName: String) : Optional<User>
}

