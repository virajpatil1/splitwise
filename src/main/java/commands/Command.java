package commands;

import java.util.Arrays;
import java.util.List;

public interface Command {

    boolean matches(String input);

    void execute(String input);

    default String getCommand(String s){


        return getTokens(s).get(0);
    }

    default List<String> getTokens(String input){

        return Arrays.stream(input.split(" ")).toList();
    }
}
