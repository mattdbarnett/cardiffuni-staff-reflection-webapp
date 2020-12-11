package group03.project.web.lists;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ReflectList {

    private String activityName;
    @DateTimeFormat
    private Date date;
    private Boolean isOfficial;
    private String reflect_what;
    private String reflect_prompt;
    private String reflect_happen;
    private String reflect_eval;
    private String reflect_diff;
    private String reflect_lp;
}
