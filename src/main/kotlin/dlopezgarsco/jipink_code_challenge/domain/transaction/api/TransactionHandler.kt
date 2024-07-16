package dlopezgarsco.jipink_code_challenge.domain.transaction.api

import dlopezgarsco.jipink_code_challenge.core.models.TransactionEntity
import dlopezgarsco.jipink_code_challenge.domain.transaction.TransactionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.awaitBody
import org.springframework.web.reactive.function.server.buildAndAwait
import java.net.URI

@Component
class TransactionHandler(
  @Autowired private val transactionService: TransactionService
) {

  suspend fun createTransaction(request: ServerRequest): ServerResponse {
    val body = request.awaitBody<TransactionEntity>()
    return transactionService.processTransaction(body).let {
      ServerResponse.created(URI.create("/api/transaction/$it")).buildAndAwait()
    }
  }

}
