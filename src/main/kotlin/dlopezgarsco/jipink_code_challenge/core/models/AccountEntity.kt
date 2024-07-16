package dlopezgarsco.jipink_code_challenge.core.models

data class AccountEntity(
  var id: Int,
  var bankId: Int,
  var countryCode: String,
  var balance: Double
)
