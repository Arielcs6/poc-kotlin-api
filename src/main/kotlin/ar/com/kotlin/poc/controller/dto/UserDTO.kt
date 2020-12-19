package ar.com.kotlin.poc.controller.dto

import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.Id

class UserDTO {
    lateinit var name: String
    lateinit var email: String
}