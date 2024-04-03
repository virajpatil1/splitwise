package controller;


import dtos.createGroupExpenseDto;
import lombok.AllArgsConstructor;
import models.Group;
import models.GroupExpense;
import org.springframework.stereotype.Controller;
import services.expenseService;

@Controller
@AllArgsConstructor
public class groupExpenseController {

    private expenseService expenseService;

    public GroupExpense createGroupExpense(createGroupExpenseDto groupExpenseDto) {

        return expenseService.createGroupExpense(groupExpenseDto);
    }
}
