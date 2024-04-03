package commands;

import dtos.CreateGroupRequest;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import models.Group;
import org.springframework.stereotype.Component;
import controller.groupController;
import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class CreateGroupCommand implements Command{

    private groupController groupController;
    @Override
    public boolean matches(String input) {

        if(getCommand(input)
                .equals(commands.CREATE_GROUP_COMMAND)){
            return true;
        }
        return false;
    }

    @Override
    public void execute(String input) {

        System.out.println("Executing create group command");
        List<String> tokens = getTokens(input);

        List<Long> memberIds = Arrays.stream(tokens.get(3).split(","))
                .map(Long :: valueOf)
                .toList();

        CreateGroupRequest createGroupRequest = CreateGroupRequest.builder()
                .name(tokens.get(1))
                .createdBy(Long.valueOf(tokens.get(2)))
                .memberIds(memberIds)
                .build();

        Group group = groupController.createGroup(createGroupRequest);
        System.out.println("Created group with id: " + group.getId());
    }
}
