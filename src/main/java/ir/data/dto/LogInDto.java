package ir.data.dto;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
@Data
public class LogInDto {
    @NotBlank(message = "should not be empty")
    @Email
    private String username;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8}$"
            , message = "the password must be at least 8 character, with a lower case, an upper case and no whitespace")
    private String password;
}
