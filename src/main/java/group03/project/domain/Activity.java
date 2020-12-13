package group03.project.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "activity")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="activityID")
    private Long activityID;
//    private Integer userID;
    @Column(name = "name")
    private String name;
    @Column(name="file")
    private String file;
    @Column(name="description")
    private String desc;
    @Column(name="isOfficial")
    private Boolean isOfficial;

    public Activity(String name, String desc, Boolean isOfficial) {
        this(null, name, null, desc, false);
    }


}
