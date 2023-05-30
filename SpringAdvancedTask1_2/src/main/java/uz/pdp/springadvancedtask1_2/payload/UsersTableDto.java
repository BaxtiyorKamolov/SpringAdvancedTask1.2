package uz.pdp.springadvancedtask1_2.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersTableDto {

    private String username;

    private String password;

    private String email;

    private LocalDate registrationDate;
}
