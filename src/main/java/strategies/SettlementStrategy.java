package strategies;

import dtos.SettleUpTransaction;
import models.Expense;

import java.util.List;

public interface SettlementStrategy {
    List<SettleUpTransaction> settleExpenses(List<Expense> expenses);

}
