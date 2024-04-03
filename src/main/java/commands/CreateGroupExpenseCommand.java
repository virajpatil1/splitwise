package commands;

import controller.groupExpenseController;
import dtos.createGroupExpenseDto;
import lombok.AllArgsConstructor;
import models.Group;
import models.GroupExpense;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class CreateGroupExpenseCommand implements Command{

    private groupExpenseController groupExpenseController;
    @Override
    public boolean matches(String input) {

        if(getCommand(input).equals(commands.CREATE_GROUP_EXPENSE_COMMAND)){
            return true;
        }
        return false;
    }

    @Override
    public void execute(String input) {
        System.out.println("Executing create group-expense command");
        List<String> tokens = getTokens(input);

        List<Long> memberIds = Arrays.stream(tokens.get(3).split(","))
                .map(Long :: valueOf)
                .toList();

        createGroupExpenseDto groupExpenseDto = createGroupExpenseDto.builder()
                .description(tokens.get(1))
                .amount(Double.valueOf(tokens.get(2)))
                .group_id(Long.valueOf(tokens.get(3)))
                .members(memberIds)
                .build();

       GroupExpense groupExpense= groupExpenseController.createGroupExpense(groupExpenseDto);

        System.out.println("Created group-expense with id: " + groupExpense.getId());


    }
}
