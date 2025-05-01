package org.lab;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExpenseModel {
    private int id;
    private String description;
    private double amount;
    private LocalDate date;

    public static ExpenseModel toObject(String id, String description, String amount, String date){
        int newId = Integer.parseInt(id);
        double newAmount = Double.parseDouble(amount);
        LocalDate newDate = LocalDate.parse(date);

        return new ExpenseModel(newId, description, newAmount, newDate);
    }
}
