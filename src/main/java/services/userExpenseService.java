package services;

import lombok.AllArgsConstructor;
import models.UserExpense;
import org.springframework.stereotype.Service;
import repositories.userExpenseRepository;

@Service
@AllArgsConstructor
public class userExpenseService {

    private userExpenseRepository userExpenseRepository;


    public UserExpense addUserExpense(UserExpense userExpense) {

        return userExpenseRepository.save(userExpense);
    }
}
