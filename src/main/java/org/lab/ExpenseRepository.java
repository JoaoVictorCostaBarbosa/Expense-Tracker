package org.lab;

import java.io.*;
import java.util.ArrayList;

public class ExpenseRepository {
    private static final String filePath = "data.csv";

    private static void createFile() {
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                FileWriter writer = new FileWriter(filePath);
                writer.close();
            } catch (IOException e) {
                System.out.println("Error: " + e);
            }
        }
    }

    public static ArrayList<ExpenseModel> readFile() {
        createFile();
        ArrayList<ExpenseModel> expenses = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                expenses.add(ExpenseModel.toObject(data[0], data[1], data[2], data[3]));
            }
        }
        catch (IOException e) {
            System.out.println("Error: " + e);
        }

        return expenses;
    }

    public static void saveFile(ArrayList<ExpenseModel> expenses) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
            int id = 0;
            for (ExpenseModel expense : expenses) {
                writer.append(id + ","
                        + expense.getDescription() + ","
                        + expense.getAmount() + ","
                        + expense.getDate() + "\n");
                id += 1;
            }
        }
        catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    public static void help() {
        System.out.println("test");
    }
}
