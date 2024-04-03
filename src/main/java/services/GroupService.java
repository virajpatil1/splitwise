package services;


import Exceptions.GroupByIdNotFoundException;
import dtos.CreateGroupRequest;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import models.Group;
import models.User;
import org.springframework.stereotype.Service;
import repositories.groupRepository;

import java.util.List;


@Service
@AllArgsConstructor
public class GroupService {


    private groupRepository groupRepository;

    private userService userService;

    public Group createGroup(CreateGroupRequest groupRequest) {

        User createdBy = userService.getUserbyId(groupRequest.getCreatedBy());

        List<User> members = userService.getUsers(groupRequest.getMemberIds());

        Group group = Group.builder().name(groupRequest.getName())
                .createdBy(createdBy)
                .members(members)
                .admins(List.of(createdBy))
                .build();

        return groupRepository.save(group);
    }


    public Group getGroupById(Long groupId) {

        return groupRepository.findById(groupId)
                .orElseThrow(
                        () -> new GroupByIdNotFoundException(groupId)
                );
    }
}
