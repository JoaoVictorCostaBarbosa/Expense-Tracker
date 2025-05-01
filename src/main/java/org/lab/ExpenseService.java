package org.lab;

import java.time.LocalDate;
import java.util.ArrayList;

public class ExpenseService {

    public ArrayList<ExpenseModel> addExpense(String name, String description, String amount, ArrayList<ExpenseModel> expenses) {
        int id = expenses.size();
        double newAmount = Double.parseDouble(amount);
        LocalDate date = LocalDate.now();

        expenses.add(new ExpenseModel(id, name, description, newAmount, date));
        return expenses;
    }

    public ArrayList<ExpenseModel> updateExpense(String id, String name, String description, String amount, ArrayList<ExpenseModel> expenses) {
        int newId = Integer.parseInt(id);
        double newAmount = Double.parseDouble(amount);

        for (ExpenseModel expense : expenses) {
            if (expense.getId() == newId) {
                expense.setExpenseName(name);
                expense.setDescription(description);
                expense.setAmount(newAmount);
            }
        }

        return expenses;
    }

    public ArrayList<ExpenseModel> removeExpense(String id, ArrayList<ExpenseModel> expenses) {
        int newId = Integer.parseInt(id);
        expenses.removeIf(expense -> expense.getId() == newId);
        return expenses;
    }

    public void viewAllExpenses(ArrayList<ExpenseModel> expenses) {
        for (ExpenseModel expense : expenses) {
            System.out.println(expense);
        }
    }

    public void viewSumary(ArrayList<ExpenseModel> expenses) {
        double amount = 0;

        for (ExpenseModel expense : expenses) {
            amount += expense.getAmount();
        }

        System.out.println(amount);
    }

    public void viewSummarySeemonth(int mouth, ArrayList<ExpenseModel> expenses) {
        double amount = 0;

        for (ExpenseModel expense : expenses) {
            if ((expense.getDate()).getMonthValue() == mouth) {
                amount += expense.getAmount();
            }
        }

        System.out.println(amount);
    }

}
