package ar.com.kotlin.poc.domain

import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
@Table(name="USER", schema="kotlinpoc", uniqueConstraints=[UniqueConstraint(columnNames=["NAME", "EMAIL"])])
class User {

        @Id
        @GeneratedValue(generator = "uuid")
        @GenericGenerator(name = "uuid", strategy = "uuid")
        @Column(name = "USER_ID")
        val id: String = ""

        @Column(name = "NAME", nullable = false)
        lateinit var name: String

        @Column(name = "PASSWORD")
        lateinit var password: String

        @Column(name = "EMAIL")
        lateinit var email: String
}