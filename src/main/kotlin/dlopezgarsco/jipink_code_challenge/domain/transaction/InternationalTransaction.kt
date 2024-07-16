package dlopezgarsco.jipink_code_challenge.domain.transaction

data object InternationalTransaction : Transaction {
  override val transactionType: TransactionType
    get() = TransactionType.INTERNATIONAL
  override val tax: Float
    get() = 5.0F
}
