package commands;

import Exceptions.ExpenseTypeException;
import controller.userExpenseController;
import dtos.createUserExpenseRequest;
import enums.ExpenseType;
import lombok.AllArgsConstructor;
import models.UserExpense;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class createUserExpenseCommand implements Command{

    private userExpenseController userExpenseController;
    @Override
    public boolean matches(String input) {

        if(getCommand(input).equals(commands.CREATE_USER_EXPENSE_COMMAND)){
            return true;
        }
        return false;
    }

    @Override
    public void execute(String input) {
        System.out.println("Executing User-Expense command");
        List<String> tokens = getTokens(input);

        String expenseType = String.valueOf(Optional.ofNullable(tokens.get(4))
                .orElseThrow(ExpenseTypeException::new));

        createUserExpenseRequest request = createUserExpenseRequest.builder()
                .user_id(Long.valueOf(tokens.get(1)))
                .expense_id(Long.valueOf(tokens.get(2)))
                .amount(Double.valueOf(tokens.get(3)))
                .type(ExpenseType.valueOf(expenseType))
                .build();

        UserExpense userExpense = userExpenseController.createUserExpense(request);
        System.out.println("Created User-Expense with id: " +userExpense.getId());
    }
}
