package group03.project.web.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

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

public class OfficialActivityForm {
    @NotNull
    @NotBlank(message = "Please enter the activity name")
    private String name;

    @NotNull
    @NotBlank(message = "Please enter the activity's description")
    private String description;

    @NotNull
    @NotBlank(message = "Please enter the related UKPSF tags")
    private String allTags;

//    public OfficialActivityForm(String name, String description, List<String> tags) {
//        this(name, description, tags);


}
