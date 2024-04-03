package services;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import models.User;
import org.springframework.stereotype.Service;
import repositories.userRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class userService {

    private userRepository userRepository;
    private BcryptEncoder bcryptEncoder;
    public User createUser(User user){
        String password = bcryptEncoder.encode(user.getPassword());
        User user1 = user.toBuilder().password(password).build();
        return userRepository.save(user1);
    }

    public User getUserbyId(Long createdBy) {

       return userRepository.findById(createdBy).orElse(null);
    }

    public List<User> getUsers(List<Long> memberIds) {

        return userRepository.findAllById(memberIds);
    }
}
