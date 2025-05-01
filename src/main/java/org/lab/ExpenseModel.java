package org.lab;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExpenseModel {
    private long id = 0L;
    private String expenseName;
    private String description;
    private double amount;
    private LocalDate date;

    public static ExpenseModel toObject(String id, String expenseName, String description, String amount, String date){
        long newId = Long.parseLong(id);
        double newAmount = Double.parseDouble(amount);
        LocalDate newDate = LocalDate.parse(date);

        return new ExpenseModel(newId, expenseName, description, newAmount, newDate);
    }
}
