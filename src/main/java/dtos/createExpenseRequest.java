package dtos;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
@Builder
public class createExpenseRequest {

    private String description;
    private Double amount;
    private List<Long> usersIds = new ArrayList<>();

}
