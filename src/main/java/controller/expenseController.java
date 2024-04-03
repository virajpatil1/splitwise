package controller;


import dtos.createExpenseRequest;
import dtos.createUserExpenseRequest;
import lombok.AllArgsConstructor;
import models.Expense;
import models.UserExpense;
import org.springframework.stereotype.Controller;
import services.expenseService;

@Controller
@AllArgsConstructor
public class expenseController {

    private expenseService expenseService;

    public Expense createExpense(createExpenseRequest createExpenseRequest){

        return expenseService.createExpense(createExpenseRequest);
    }

}
