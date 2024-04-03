package repositories;

import models.Group;
import models.GroupExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface groupExpenseRepository extends JpaRepository<GroupExpense ,Long> {

}
