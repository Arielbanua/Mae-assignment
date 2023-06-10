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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun BudgetScreen(navController: NavController, viewModel: FinanceViewModel) {
    val allBudgets by viewModel.allBudgets.collectAsState(emptyList())

    // UI code for displaying budgets
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Budgets",
            style = MaterialTheme.typography.h4,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        BudgetList(allBudgets)


        Button(
            onClick = { navController.navigate("expense") },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "Go to Expenses")
        }


        // Other UI components
    }
}

@Composable
fun BudgetList(budgets: List<Budget>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(budgets) { budget ->
            BudgetItem(budget)
        }
    }
}

@Composable
fun BudgetItem(budget: Budget) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Amount: $${budget.amount}")
            Text(text = "Category: ${budget.category}")
            // Other budget details
        }
    }
}

@Preview(showBackground = true)
@Composable
fun preview(){

}
