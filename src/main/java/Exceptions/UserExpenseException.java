package Exceptions;

public class UserExpenseException extends RuntimeException{
    public UserExpenseException(Long expense_id) {
        super("Given expense id is not found : "+expense_id);
    }
}
