package org.example.apiflutter.dto.request;

import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDto {
    @Size(min = 4, message = "Username must be at least 3 character")
    String username;
    @Size(min = 4, message = "Password must be at least 3 character")
    String password;
    String firstName;
    String lastName;
    LocalDate dob;
}
