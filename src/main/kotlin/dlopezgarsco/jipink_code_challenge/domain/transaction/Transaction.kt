package dlopezgarsco.jipink_code_challenge.domain.transaction

import dlopezgarsco.jipink_code_challenge.core.models.AccountEntity

enum class TransactionType { FREE, DOMESTIC, INTERNATIONAL }

sealed interface Transaction {

  val transactionType: TransactionType
  val tax: Float

  companion object {
    fun create(a1: AccountEntity, a2: AccountEntity, amount: Double): Transaction =
      when (getTransactionType(a1, a2)) {
        TransactionType.FREE -> FreeTransaction
        TransactionType.DOMESTIC -> DomesticTransaction
        TransactionType.INTERNATIONAL -> InternationalTransaction
      }

    private fun getTransactionType(a1: AccountEntity, a2: AccountEntity): TransactionType {
      return if (a1.bankId == a2.bankId)
        TransactionType.FREE
      else if (a1.countryCode != a2.countryCode)
        TransactionType.INTERNATIONAL
      else
        TransactionType.DOMESTIC
    }
  }
}