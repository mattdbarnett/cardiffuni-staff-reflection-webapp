package group03.project.web.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Automatically builds getters/setters
 */
@Data
/**
 * Creates constructor with all field arguments inside
 */
@AllArgsConstructor
/**
 * Creates constructor option where object fields will be null.
 */
@NoArgsConstructor
public class TagCreationForm {

    @NotNull
    @NotBlank(message = "Please enter the tag's name")
    private String tagName;

    @NotNull
    @NotBlank(message = "Please enter the tag's description")
    private String description;

    private String isOfficial;


    public TagCreationForm(String name, String description) {
        this(name, description, "false");

    }
}
