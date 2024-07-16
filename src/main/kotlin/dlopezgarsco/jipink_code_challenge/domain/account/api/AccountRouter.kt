package dlopezgarsco.jipink_code_challenge.domain.account.api

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class AccountRouter(
  @Autowired private val handler: AccountHandler
) {

  @Bean
  fun accountRoutes() = coRouter {
    GET("/api/account/{id}", handler::getAccountById)
  }
}