package sample.app.dao

import kotlinx.coroutines.*
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.*
import org.jetbrains.exposed.sql.transactions.experimental.*

object DatabaseFactory {
    fun init() {
        var driverClassName = "com.mysql.jdbc.Driver"
        val jdbcURL = "jdbc:mysql://localhost:13306/dev_db"
        val database = Database.connect(jdbcURL, driverClassName)
        // transaction(database) {
        //     SchemaUtils.create(Articles)
        // }
    }

    suspend fun <T> dbQuery(block: suspend () -> T): T =
        newSuspendedTransaction(Dispatchers.IO) { block() }
}