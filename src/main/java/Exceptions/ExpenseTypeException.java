package Exceptions;

public class ExpenseTypeException extends RuntimeException{

    public ExpenseTypeException() {
        super("Getting null value in ExpenseType Enum.");
    }
}
