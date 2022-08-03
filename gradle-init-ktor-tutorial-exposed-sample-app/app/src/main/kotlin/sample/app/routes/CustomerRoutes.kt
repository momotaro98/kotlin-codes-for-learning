package sample.app.routes

import sample.app.models.*
import sample.app.dao.dao
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.customerRouting() {
    route("/customer") {
        get {
            call.respond(dao.allCustomers())
        }
        // get("{id?}") {
        //     val id = call.parameters["id"] ?: return@get call.respondText(
        //         "Missing id",
        //         status = HttpStatusCode.BadRequest
        //     )
        //     val customer =
        //         customerStorage.find { it.id == id } ?: return@get call.respondText(
        //             "No customer with id $id",
        //             status = HttpStatusCode.NotFound
        //         )
        //     call.respond(customer)
        // }
        post {
            val receivedCustomer = call.receive<Customer>()
            val customer = dao.addNewCustomer(receivedCustomer)
            call.respondText("Customer stored correctly", status = HttpStatusCode.Created)
        }
        // delete("{id?}") {
        //     val id = call.parameters["id"] ?: return@delete call.respond(HttpStatusCode.BadRequest)
        //     if (customerStorage.removeIf { it.id == id }) {
        //         call.respondText("Customer removed correctly", status = HttpStatusCode.Accepted)
        //     } else {
        //         call.respondText("Not Found", status = HttpStatusCode.NotFound)
        //     }
        // }
    }
}