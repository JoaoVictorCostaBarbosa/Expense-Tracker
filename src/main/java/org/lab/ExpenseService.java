package org.lab;

import java.time.LocalDate;
import java.util.ArrayList;

public class ExpenseService {

    public static void addExpense(String description, String amount, ArrayList<ExpenseModel> expenses) {
        int id = expenses.size();
        double newAmount = Double.parseDouble(amount);
        LocalDate date = LocalDate.now();

        expenses.add(new ExpenseModel(id, description, newAmount, date));
        ExpenseRepository.saveFile(expenses);
    }

    public static void removeExpense(String id, ArrayList<ExpenseModel> expenses) {
        int newId = Integer.parseInt(id);
        expenses.removeIf(expense -> expense.getId() == newId);

        ExpenseRepository.saveFile(expenses);
    }

    public static void viewAllExpenses(ArrayList<ExpenseModel> expenses) {
        for (ExpenseModel expense : expenses) {
            System.out.println(expense);
        }
    }

    public static void viewSumary(ArrayList<ExpenseModel> expenses) {
        double amount = 0;

        for (ExpenseModel expense : expenses) {
            amount += expense.getAmount();
        }

        System.out.println(amount);
    }

    public static void viewSummarymonth(String mouth, ArrayList<ExpenseModel> expenses) {
        int newMouth = Integer.parseInt(mouth);
        double amount = 0;

        for (ExpenseModel expense : expenses) {
            if ((expense.getDate()).getMonthValue() == newMouth) {
                amount += expense.getAmount();
            }
        }

        System.out.println(amount);
    }

    public static void help() {
        System.out.println("test");
    }

}
