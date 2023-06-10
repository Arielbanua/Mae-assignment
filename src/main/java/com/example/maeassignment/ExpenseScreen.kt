package com.example.maeassignment

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ExpenseScreen(navController: NavController, viewModel: FinanceViewModel) {
    val allExpenses by viewModel.allExpenses.collectAsState(emptyList())

    // UI code for displaying expenses
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Expenses",
            style = MaterialTheme.typography.h4,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        ExpenseList(allExpenses)

        Button(
            onClick = { navController.navigate("budget") },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "Go to Budgets")
        }

        // Other UI components
    }
}

@Composable
fun ExpenseList(expenses: List<Expense>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(expenses) { expense ->
            ExpenseItem(expense)
        }
    }
}

@Composable
fun ExpenseItem(expense: Expense) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Amount: $${expense.amount}")
            Text(text = "Category: ${expense.category}")
            // Other expense details
        }
    }
}