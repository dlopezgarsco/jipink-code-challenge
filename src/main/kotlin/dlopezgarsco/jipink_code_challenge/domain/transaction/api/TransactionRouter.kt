package dlopezgarsco.jipink_code_challenge.domain.transaction.api

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class TransactionRouter(private val handler: TransactionHandler) {

  @Bean
  fun transactionRoute() = coRouter {
    accept(MediaType.APPLICATION_JSON).nest {
      POST("/api/transaction", handler::createTransaction)
    }
  }
}