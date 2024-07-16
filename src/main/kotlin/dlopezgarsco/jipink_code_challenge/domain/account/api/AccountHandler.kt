package dlopezgarsco.jipink_code_challenge.domain.account.api

import dlopezgarsco.jipink_code_challenge.domain.account.AccountService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import org.springframework.web.reactive.function.server.json

@Component
class AccountHandler(
  @Autowired private val accountService: AccountService
) {

  suspend fun getAccountById(request: ServerRequest): ServerResponse {
    val id = request.pathVariable("id").toInt()
    return accountService.getAccountById(id).let {
      ServerResponse.ok().json().bodyValueAndAwait(it)
    }
  }

}
