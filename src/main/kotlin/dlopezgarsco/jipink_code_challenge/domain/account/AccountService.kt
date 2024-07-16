package dlopezgarsco.jipink_code_challenge.domain.account

import dlopezgarsco.jipink_code_challenge.core.models.AccountEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Service

@Service
class AccountService(
  @Autowired private val accountRepository: AccountRepository
) {
  suspend fun getAccountById(id: Int): AccountEntity = accountRepository.getAccountById(id) ?: throw NotFoundException()
}