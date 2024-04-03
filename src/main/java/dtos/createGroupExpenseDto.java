package dtos;


import lombok.Builder;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class createGroupExpenseDto {

    private String description;
    private Double amount;
    private Long group_id;
    private List<Long> members = new ArrayList<>();

}
