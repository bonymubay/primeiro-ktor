
import com.example.plugins.model.User
import com.example.service.UserService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.netty.handler.codec.http.HttpResponseStatus

fun Route.UserRoute(){

   route("/user") {
       val userService = UserService()
       get {

           call.respond(userService.users)
           println(userService.users)
       }

       get("{idade?}"){

           val idade =call.parameters["idade"]?.toIntOrNull()


          val userGet =userService.users.find { it.idade ==  idade }?: return@get call.respond(HttpStatusCode.BadRequest)

           call.respond(userGet)
       }


       post ("/add") {
           val user= call.receive<User>()
           userService.addUser(user)
           call.respondText ("User adicinado com sucesso", status = HttpStatusCode.Created)
           println(user)
       }

       put ("/update/{nome?}"){

           val nome = call.parameters["nome"] ?: return@put call.respond(HttpStatusCode.BadRequest)
        call.respond(nome)

           val user= call.receive<User>()

          val userFound = userService.users.find { it.nome==nome }

           if (userFound == null){
               return@put call.respond(HttpStatusCode.BadRequest,"Parametro nullo")
           }

           userService.updateUser(user,nome)
       }

       delete("delete/{nome?}") {

           val  nome= call.parameters["nome"]?: return@delete call.respond(HttpStatusCode.BadRequest, "parametro nullo")


           if (userService.users.removeIf { it.nome==nome }){
               call.respond(HttpStatusCode.Created,"user $nome foi deletado")
           }
           else{
               call.respond(HttpStatusCode.BadRequest,"User nao encontrado no sistema")
           }


       }

    }

}