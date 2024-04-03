package repositories;

import models.UserExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userExpenseRepository extends JpaRepository<UserExpense , Long> {
}
