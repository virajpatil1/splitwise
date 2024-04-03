package commands;

import java.util.List;

import dtos.createUserDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import controller.userController;

@Component
@AllArgsConstructor
public class CreateCommandUser implements Command{

    private userController userController;

    @Override
    public boolean matches(String input) {


        if (getCommand(input)
                .equals(commands.REGISTER_USER_COMMAND)){
            return true;
        }

        return false;
    }

    @Override
    public void execute(String input) {

        List<String> tokens = getTokens(input);

        createUserDto createUserDto =

                dtos.createUserDto.builder()
                        .name(tokens.get(1))
                        .email(tokens.get(2))
                        .password(tokens.get(3))
                        .phoneNumber(tokens.get(4))
                        .build();

        userController.createUser(createUserDto);
    }
}
