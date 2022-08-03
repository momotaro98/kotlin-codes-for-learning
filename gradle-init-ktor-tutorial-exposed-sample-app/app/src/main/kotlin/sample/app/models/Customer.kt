package sample.app.models

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.*

@Serializable
data class Customer(val id: String, val firstName: String, val lastName: String, val email: String)

// using in-memory because this is tutorial app
val customerStorage = mutableListOf<Customer>()

object Customers : Table() {
    val id = integer("id").autoIncrement()
    val firstName = varchar("first_name", 128)
    val lastName = varchar("first_name", 128)
    val email = varchar("email", 1024)

    override val primaryKey = PrimaryKey(id)
}