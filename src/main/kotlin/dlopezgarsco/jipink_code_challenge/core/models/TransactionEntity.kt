package dlopezgarsco.jipink_code_challenge.core.models

data class TransactionEntity (
  val originId: Int,
  val destinationId: Int,
  val amount: Double
)