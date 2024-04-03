package commands;

public class SettleUpCommand implements Command{
    @Override
    public boolean matches(String input) {
        if (getCommand(input)
                .equals(commands.SETTLE_UP_COMMAND)){
            return true;
        }

        return false;
    }

    @Override
    public void execute(String input) {

    }
}
