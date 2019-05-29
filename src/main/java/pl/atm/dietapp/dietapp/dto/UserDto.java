package pl.atm.dietapp.dietapp.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data

public class UserDto {

    private Long id;
    @NotEmpty
    @Size(min = 5)
    private String username;
    @NotNull
    @Size(min = 6)
    private String password;

    private String passwordConfirm;
}
