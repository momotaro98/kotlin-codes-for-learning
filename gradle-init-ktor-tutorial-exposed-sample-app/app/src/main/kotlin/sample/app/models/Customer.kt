package sample.app.models

import kotlinx.serialization.Serializable

@Serializable
data class Customer(val id: String, val firstName: String, val lastName: String, val email: String)

// using in-memory because this is tutorial app
val customerStorage = mutableListOf<Customer>()