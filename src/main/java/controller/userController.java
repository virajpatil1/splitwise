package controller;


import dtos.createUserDto;
import lombok.AllArgsConstructor;
import models.User;
import services.userService;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class userController {

    private userService userService;
    public User createUser(createUserDto createUserDto){


       return userService.createUser(createUserDto.toUser(createUserDto));

    }
}
