package dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import models.User;

@Data
@Builder
public class createUserDto {

    private String name;
    private String email;
    private String password;
    private String phoneNumber;

    public User toUser(createUserDto createUserDto) {

        User user = User.builder()
                .name(createUserDto.name)
                .email(createUserDto.email)
                .password(createUserDto.password)
                .phoneNumber(createUserDto.phoneNumber)
                .build();

        return user;
    }
}
