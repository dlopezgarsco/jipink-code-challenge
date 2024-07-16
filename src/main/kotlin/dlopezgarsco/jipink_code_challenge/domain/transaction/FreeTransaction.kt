package dlopezgarsco.jipink_code_challenge.domain.transaction

data object FreeTransaction : Transaction {
  override val transactionType: TransactionType
    get() = TransactionType.FREE
  override val tax: Float
    get() = 0F

}
