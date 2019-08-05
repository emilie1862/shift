import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.gson
import io.ktor.request.receive
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

data class LengthRequest(val str: String)
data class LengthResponse(val length: Int)

fun stringLength(str: String) : Int {
    return str.length
}

fun Application.module() {
    install(DefaultHeaders)
    install(CallLogging)
    install(ContentNegotiation) {
        gson {
            setPrettyPrinting()
        }
    }
    install(CORS) {
        host("localhost:4200")
    }
    install(Routing) {
        get("/") {
            call.respondText("Hello World")
        }
        post("/length") {
            val request = call.receive<LengthRequest>()
            call.respond(LengthResponse(stringLength(request.str)))
        }
    }
}

fun main(args: Array<String>) {
    embeddedServer(Netty, port = 8081, watchPaths = listOf("TestAppKt"), module = Application::module).start()
}

