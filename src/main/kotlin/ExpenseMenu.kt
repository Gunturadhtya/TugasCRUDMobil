package org.mobil

class ExpenseMenu: MenuInterface<Expense, Int> {
    private val expenses = mutableListOf<Pair<Int, Expense>>()
    private var nextId = 1

    override fun add(data: Expense) {
        val newData = data.copy(id = nextId++)
        expenses.add(Pair(newData.id, newData))
    }

    override fun list(): List<Expense> {
        return expenses.map {it.second}
    }

    override fun edit(key: Int, newData: Expense) {
        val idx = expenses.indexOfFirst { it.first == key }
        if (idx != -1){
            expenses[idx] = Pair(key, newData)
        }
    }

    override fun delete(key: Int) {
        expenses.removeIf { it.first == key }
    }

    override fun showData(key: Int): Pair<Int, Expense>? {
        return expenses.find { it.first == key }
    }

    override fun showMenu() {
        println("==================================")
        println("Expense Menu")
        println("1. Add Expense")
        println("2. List Expense")
        println("3. Edit Expense")
        println("4. Delete Expense")
        println("5. Show Data")
        println("6. Exit")
        println("==================================")
    }
}