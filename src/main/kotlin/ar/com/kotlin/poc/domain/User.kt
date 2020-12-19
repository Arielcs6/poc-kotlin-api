package ar.com.kotlin.poc.domain

import javax.persistence.*

@Entity
@Table(name="USERS")
class User {

        @Id
        @GeneratedValue
        @Column(name = "USER_ID")
        val id: Int = 0

        @Column(name = "NAME", nullable = false)
        lateinit var name: String

        @Column(name = "PASSWORD")
        lateinit var password: String

        @Column(name = "EMAIL")
        lateinit var email: String
}