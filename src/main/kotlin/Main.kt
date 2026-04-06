package org.mobil

import java.math.BigDecimal
import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun main() {
    val expenseMenu = ExpenseMenu()

    while (true) {
        listExpenses(expenseMenu)
        expenseMenu.showMenu()
        print("Select Menu: ")
        val selected = readln().toIntOrNull() ?: -1

        when (selected) {
            1 -> addExpense(expenseMenu)
            2 -> listExpenses(expenseMenu)
            3 -> editExpense(expenseMenu)
            4 -> deleteExpense(expenseMenu)
            5 -> showData(expenseMenu)
            6 -> break
            else -> println("Error Input")
        }
    }
}

fun addExpense(menu: ExpenseMenu) {
    print("Enter Amount: ")
    val amount = readln().toBigDecimalOrNull() ?: BigDecimal.ZERO
    print("Enter Tag: ")
    val tag = readln()
    menu.add(Expense(0, LocalDate.now(), tag, amount))
    println("Successfully added.")
}

fun listExpenses(menu: ExpenseMenu) {
    val items = menu.list()
    if (items.isEmpty()) {
        println("No records found.")
    } else {
        println("\nID | Date | Tag | Amount")
        items.forEach { println("${it.id} | ${it.date} | ${it.tag} | ${it.amount}") }
    }
}

fun editExpense(menu: ExpenseMenu) {
    print("Enter ID to edit: ")
    val id = readln().toIntOrNull() ?: -1
    val existing = menu.showData(id)

    if (existing != null) {
        print("Enter New Amount (Leave blank to keep ${existing.second.amount}): ")
        val inputAmount = readln()
        val amount = if (inputAmount.isBlank()) existing.second.amount else inputAmount.toBigDecimalOrNull() ?: existing.second.amount

        print("Enter New Tag: ")
        val tag = readln()

        menu.edit(id, Expense(id, LocalDate.now(), tag, amount))
        println("Successfully updated.")
    } else {
        println("ID not found.")
    }
}

fun deleteExpense(menu: ExpenseMenu) {
    print("Enter ID to delete: ")
    val id = readln().toIntOrNull() ?: -1
    menu.delete(id)
    println("Action completed.")
}

fun showData(menu: ExpenseMenu) {
    print("Enter ID: ")
    val id = readln().toIntOrNull() ?: -1
    val result = menu.showData(id)
    if (result != null) {
        println("Found Data: ${result.second}")
    } else {
        println("Not found.")
    }
}