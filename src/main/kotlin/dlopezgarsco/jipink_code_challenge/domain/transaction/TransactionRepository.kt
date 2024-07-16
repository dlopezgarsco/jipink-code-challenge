package dlopezgarsco.jipink_code_challenge.domain.transaction

import dlopezgarsco.jipink_code_challenge.core.models.AccountEntity
import kotlinx.coroutines.reactive.awaitFirstOrNull
import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional


@Repository
class TransactionRepository(private val client: DatabaseClient) {

  @Transactional
  suspend fun recordTransaction(a1: AccountEntity, a2: AccountEntity, amount: Double) =
    client.sql(
      """"
      |BEGIN TRANSACTION;
      |UPDATE balance SET balance=:originBalance WHERE account_id=:originId;
      |UPDATE balance SET balance=:destinationBalance WHERE account_id=:destinationId;
      |INSERT INTO transactions (origin_id, destination_id, :amount) VALUES(:originId, :destinationId);
      |COMMIT;
      """.trimMargin()
    )
      .bind("originBalance", a1.balance)
      .bind("originId", a1.id)
      .bind("destinationBalance", a2.balance)
      .bind("destinationId", a2.id)
      .bind("amount", amount)
      .then()
}