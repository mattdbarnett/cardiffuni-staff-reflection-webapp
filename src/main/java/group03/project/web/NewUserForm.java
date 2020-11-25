package group03.project.web;

import com.fasterxml.jackson.annotation.OptBoolean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewUserForm {

    @NotBlank(message = "Please include your name for record purposes")
    private String name;
    private Optional<String> homeAddress;
    @NotBlank(message = "Please include your email address for contact purposes")
    private String emailAddress;
    @NotBlank(message = "Please include your job position for record purposes")
    private String position;
    private Optional<Integer> phoneNo;
    @NotNull
    private String role;

}
