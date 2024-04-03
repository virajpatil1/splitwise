package controller;

import dtos.createUserExpenseRequest;
import lombok.AllArgsConstructor;
import models.UserExpense;
import org.springframework.stereotype.Controller;
import services.expenseService;
import services.userExpenseService;

@Controller
@AllArgsConstructor
public class userExpenseController {

    private expenseService expenseService;

    public UserExpense createUserExpense(createUserExpenseRequest request) {

        return expenseService.addUserExpense(request);
    }
}
