package org.lab;

import java.util.ArrayList;

public class ExpenseController {
    static ArrayList<ExpenseModel> expenses = ExpenseRepository.readFile();

    public static void add(String description, String amount) {
        ExpenseService.addExpense(description, amount, expenses);
    }

    public static void delete(String id) {
        ExpenseService.removeExpense(id, expenses);
    }

    public static void list() {
        ExpenseService.viewAllExpenses(expenses);
    }

    public static void listSummary() {
        ExpenseService.viewSumary(expenses);
    }

    public static void listSummaryMouth(String mouth) {
        ExpenseService.viewSummarymonth(mouth, expenses);
    }
}
