package ar.com.kotlin.poc.controller.dto

import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.Id

class UserDTO {
    var name: String = ""
    var password: String = ""
    var email: String = ""
}