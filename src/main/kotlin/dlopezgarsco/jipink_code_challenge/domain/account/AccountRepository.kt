package dlopezgarsco.jipink_code_challenge.domain.account

import dlopezgarsco.jipink_code_challenge.core.models.AccountEntity
import kotlinx.coroutines.reactor.awaitSingleOrNull
import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.stereotype.Repository


@Repository
class AccountRepository(private val client: DatabaseClient) {

  suspend fun getAccountById(id: Int): AccountEntity? =
    client
      .sql("SELECT * FROM accounts WHERE id=:id")
      .bind("id", id)
      .mapProperties(AccountEntity::class.java)
      .first()
      .awaitSingleOrNull()
}