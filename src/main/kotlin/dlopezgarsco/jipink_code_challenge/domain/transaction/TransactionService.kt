package dlopezgarsco.jipink_code_challenge.domain.transaction

import dlopezgarsco.jipink_code_challenge.core.models.TransactionEntity
import dlopezgarsco.jipink_code_challenge.domain.account.AccountService
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Service


@Service
class TransactionService(
  @Autowired val accountService: AccountService,
  @Autowired val transactionRepository: TransactionRepository
) {
  suspend fun processTransaction(t: TransactionEntity): Int {
    coroutineScope {
      val origin = async { accountService.getAccountById(t.originId) }.await()
      val destination = async { accountService.getAccountById(t.originId) }.await()
      val finalAmount = t.amount.minus(Transaction.create(origin, destination, t.amount).tax)
      transactionRepository.recordTransaction (
        origin.apply { balance -= finalAmount },
        destination.apply { balance += finalAmount },
        finalAmount
      )
    }
    return 1
  }
}