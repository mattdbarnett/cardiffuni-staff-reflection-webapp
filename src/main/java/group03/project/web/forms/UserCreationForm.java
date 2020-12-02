package group03.project.web.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UserCreationForm {

    @NotNull
    @NotBlank(message = "Please enter an email address")
    @Email
    private String emailAddress;

    @NotNull
    @NotBlank(message = "Please enter a password")
    private String password;

    @NotNull
    @NotBlank(message = "Please re-type the above password")
    private String matchingPassword;

    @NotNull
    @NotBlank(message = "Please enter your preferred name")
    private String name;

}
