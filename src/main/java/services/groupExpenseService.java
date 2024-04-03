package services;

import lombok.AllArgsConstructor;
import models.GroupExpense;
import org.springframework.stereotype.Service;
import repositories.groupExpenseRepository;

@Service
@AllArgsConstructor
public class groupExpenseService {

    private groupExpenseRepository groupExpenseRepository;

    public GroupExpense addGroupExpense(GroupExpense groupExpense) {

        return groupExpenseRepository.save(groupExpense);
    }
}
