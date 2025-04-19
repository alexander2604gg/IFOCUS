package com.web.ifocus.dto.user;
import java.time.LocalDate;
import lombok.Data;

@Data
public class CreateUserRequestDto {
    private String firstName;
    private String secondName;
    private LocalDate dateBirth;
    private String email;
    private String password;
}