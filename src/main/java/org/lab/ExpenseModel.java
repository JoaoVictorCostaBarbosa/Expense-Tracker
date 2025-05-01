package org.lab;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExpenseModel {
    private static final long id = 0L;
    private String expenseName;
    private String description;
    private double amount;
    private LocalDateTime date;
}
