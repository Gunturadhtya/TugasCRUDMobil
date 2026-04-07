package org.mobil

import java.math.BigDecimal
import java.time.LocalDate
import java.time.temporal.ChronoUnit

class AnalyticsExpense(startingBudget: BigDecimal, days: Long) {
    val startingBudget = startingBudget
    var currentMoney: BigDecimal = startingBudget
        set(value) {
            require(value >= BigDecimal.ZERO) { "Current budget must be positive" }
            field = value
        }
    var daysLeft: Long = days
        set(value) {
            require(value >= 0) { "Days must be greater than 0" }
            field = value
        }get() = field - ChronoUnit.DAYS.between(dateStarted, LocalDate.now())
    val dateStarted: LocalDate = LocalDate.now()
    val dailyBudget: BigDecimal
        get() = if (daysLeft > 0){
            currentMoney / daysLeft.toBigDecimal()
        }
        else{
            BigDecimal.ZERO
        }
}