package com.project.splitwise.ExpenseTest;

import models.Expense;
import models.User;
import models.UserExpense;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestExpenseOwnedBy {


    @Test
    public void testExpenseOwnedBy() {

        Expense expense = new Expense();

        for (UserExpense userExpense : expense.getOwedBy()) {

            User user = userExpense.getUser();
            System.out.println(user.getId());
        }



    }

}
