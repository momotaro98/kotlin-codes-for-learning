package sample.app.models

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.*

@Serializable
data class Customer(val id: Int, val name: String, val email: String)

// // using in-memory because this is tutorial app
// val customerStorage = mutableListOf<Customer>()

object Customers : Table() {
    val id = integer("id").autoIncrement()
    val name = varchar("name", 128)
    val email = varchar("email", 1024)

    override val primaryKey = PrimaryKey(id)
}