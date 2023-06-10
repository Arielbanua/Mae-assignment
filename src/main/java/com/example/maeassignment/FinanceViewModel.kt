package com.example.maeassignment

import android.content.Context
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow



class FinanceViewModel(private val context: Context) : ViewModel() {
    private val expenseDao: ExpenseDao
    private val budgetDao: BudgetDao

    init {
        val appDatabase = AppDatabase.getInstance(context)
        expenseDao = appDatabase.expenseDao()
        budgetDao = appDatabase.budgetDao()
    }

    val allExpenses: Flow<List<Expense>> = expenseDao.getAllExpenses()
    val allBudgets: Flow<List<Budget>> = budgetDao.getAllBudgets()

    suspend fun addExpense(expense: Expense) {
        expenseDao.insertExpense(expense)
    }

    suspend fun addBudget(budget: Budget) {
        budgetDao.insertBudget(budget)
    }

    // Other methods as needed
}

