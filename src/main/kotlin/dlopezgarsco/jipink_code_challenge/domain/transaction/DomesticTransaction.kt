package dlopezgarsco.jipink_code_challenge.domain.transaction

data object DomesticTransaction : Transaction {
  override val transactionType: TransactionType
    get() = TransactionType.DOMESTIC
  override val tax: Float
    get() = 1.0F

}
