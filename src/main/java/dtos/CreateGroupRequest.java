package dtos;

import lombok.Builder;
import lombok.Data;
import models.Group;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class CreateGroupRequest {

    private String name;

    private Long createdBy;

    private List<Long> memberIds = new ArrayList<>();
}
