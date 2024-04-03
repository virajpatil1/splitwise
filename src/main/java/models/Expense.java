package models;

import enums.ExpenseStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Getter
@Setter
public class Expense extends BaseModel {

    private String description;
    private Double amount;

    @ManyToMany
    private List<User> users = new ArrayList<>();

    @OneToMany(mappedBy = "expense")
    private List<UserExpense> paidBy = new ArrayList<>();

    @OneToMany(mappedBy = "expense")
    private List<UserExpense> owedBy = new ArrayList<>();

    @Enumerated
    private ExpenseStatus status;


}
