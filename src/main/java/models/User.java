package models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Getter
@Table(name = "users")
@Setter
public class User extends  BaseModel{
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
}
