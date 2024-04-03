package services;


import Exceptions.UserExpenseException;
import dtos.createExpenseRequest;
import dtos.createGroupExpenseDto;
import dtos.createUserExpenseRequest;
import enums.ExpenseStatus;
import lombok.AllArgsConstructor;
import models.*;
import org.springframework.stereotype.Service;
import repositories.expenseRepository;

import java.util.List;


@Service
@AllArgsConstructor
public class expenseService {

    private expenseRepository expenseRepository;

    private userService userService;

    private userExpenseService userExpenseService;

    private GroupService groupService;

    private groupExpenseService groupExpenseService;
    public Expense createExpense(createExpenseRequest createExpenseRequest) {

        List<User> userIds = userService.getUsers(createExpenseRequest.getUsersIds());

        Expense expense = Expense.builder()
                .description(createExpenseRequest.getDescription())
                .amount(createExpenseRequest.getAmount())
                .users(userIds)
                .status(ExpenseStatus.PENDING)
                .build();

        return expenseRepository.save(expense);

    }

    public UserExpense addUserExpense(createUserExpenseRequest request) {

        User user = userService.getUserbyId(request.getUser_id());

        Expense expense = expenseRepository.
                findById(request.getExpense_id())
                .orElseThrow(() -> new UserExpenseException(request.getExpense_id()));


        UserExpense userExpense = UserExpense.builder()
                .user(user)
                .expense(expense)
                .amount(request.getAmount())
                .type(request.getType())
                .build();

        return userExpenseService.addUserExpense(userExpense);
    }

    public GroupExpense createGroupExpense(createGroupExpenseDto groupExpenseDto) {

        Group group = groupService.getGroupById(groupExpenseDto.getGroup_id());

        List<User> userIds = userService.getUsers(groupExpenseDto.getMembers());

        Expense expense = Expense.builder()
                .description(groupExpenseDto.getDescription())
                .amount(groupExpenseDto.getAmount())
                .users(userIds)
                .status(ExpenseStatus.PENDING)
                .build();

        expenseRepository.save(expense);

       GroupExpense groupExpense = GroupExpense.builder()
               .group(group)
               .expense(expense)
               .build();

       return groupExpenseService.addGroupExpense(groupExpense);

    }
}
