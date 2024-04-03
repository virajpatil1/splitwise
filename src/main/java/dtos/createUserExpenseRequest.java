package dtos;


import enums.ExpenseType;
import lombok.Builder;
import lombok.Data;
import models.Expense;


@Data
@Builder
public class createUserExpenseRequest {
    private Long user_id;
    private Long expense_id;
    private Double amount;
    private ExpenseType type;
}
