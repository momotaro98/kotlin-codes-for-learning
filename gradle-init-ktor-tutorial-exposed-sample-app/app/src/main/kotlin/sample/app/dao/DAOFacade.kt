package sample.app.dao

import sample.app.models.*

interface DAOFacade {
    suspend fun allCustomers(): List<Customer>
    suspend fun addNewCustomer(customer: Customer): Customer?
}