package org.mobil

import java.math.BigDecimal
import java.time.LocalDate

data class Expense(
    val id: Int,
    val date: LocalDate,
    val tag: String,
    val amount: BigDecimal
)
