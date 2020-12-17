package group03.project.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "activity")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="activityID", nullable = false, unique = true)
    private Long activityID;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name="file")
    private String file;

    @Column(name="description")
    private String description;

    @NotNull
    @Column(name="isOfficial", nullable = false)
    private Boolean isOfficial;

    public Activity(String name, String desc) {
        this(null, name, null, desc, false);
    }

}
