package sample.app.dao

import sample.app.dao.DatabaseFactory.dbQuery
import sample.app.models.*
import kotlinx.coroutines.runBlocking
import org.jetbrains.exposed.sql.*

class DAOFacadeImpl : DAOFacade {
    private fun resultRowToCustomer(row: ResultRow) = Customer(
        id = row[Customers.id],
        name = row[Customers.name],
        email = row[Customers.email],
    )

    override suspend fun allCustomers(): List<Customer> = dbQuery {
        Customers.selectAll().map(::resultRowToCustomer)
    }

    // override suspend fun Customer(id: Int): Customer? = dbQuery {
    //     Customers
    //         .select { Customers.id eq id }
    //         .map(::resultRowToCustomer)
    //         .singleOrNull()
    // }

    override suspend fun addNewCustomer(customer: Customer): Customer? = dbQuery {
        val insertStatement = Customers.insert {
            it[Customers.name] = customer.name
            it[Customers.email] = customer.email
        }
        insertStatement.resultedValues?.singleOrNull()?.let(::resultRowToCustomer)
    }

    // override suspend fun editCustomer(id: Int, title: String, body: String): Boolean = dbQuery {
    //     Customers.update({ Customers.id eq id }) {
    //         it[Customers.title] = title
    //         it[Customers.body] = body
    //     } > 0
    // }

    // override suspend fun deleteCustomer(id: Int): Boolean = dbQuery {
    //     Customers.deleteWhere { Customers.id eq id } > 0
    // }
}

val dao: DAOFacade = DAOFacadeImpl().apply {
    runBlocking {
        // if(allCustomers().isEmpty()) {
        //     addNewCustomer("taro", "taro@example.com")
        // }
    }
}