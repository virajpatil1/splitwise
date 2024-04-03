package controller;


import dtos.CreateGroupRequest;
import lombok.AllArgsConstructor;
import models.Group;
import org.springframework.stereotype.Controller;
import services.GroupService;

@Controller
@AllArgsConstructor
public class groupController {

    private GroupService groupService;
    public Group createGroup(CreateGroupRequest groupRequest){

        return groupService.createGroup(groupRequest);
    }
}
