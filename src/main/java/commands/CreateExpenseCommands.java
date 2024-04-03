package commands;

import controller.expenseController;
import dtos.createExpenseRequest;
import lombok.AllArgsConstructor;
import models.Expense;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Component
@AllArgsConstructor
public class CreateExpenseCommands implements Command{

    private expenseController expenseController;

    @Override
    public boolean matches(String input) {

        if(getCommand(input).equals(commands.CREATE_EXPENSE_COMMAND)){
            return true;
        }
        return false;
    }

    @Override
    public void execute(String input) {
        System.out.println("Executing create expense command");
        List<String> tokens = getTokens(input);

        createExpenseRequest request = createExpenseRequest.builder()
                .description(tokens.get(1))
                .amount(Double.valueOf(tokens.get(2)))
                .usersIds(Arrays.stream(tokens.get(3).split(","))
                        .map(Long :: valueOf).toList())
                .build();

        Expense expense = expenseController.createExpense(request);
        System.out.println("Created expense with id: " + expense.getId());
    }
}
