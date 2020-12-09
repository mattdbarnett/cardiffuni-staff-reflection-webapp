package group03.project.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="activityID")
    private Integer activityID;
//    private Integer userID;
    @Column(name = "name")
    private String name;
    @Column(name="file")
    private String file;
    @Column(name="description")
    private String desc;
    @Column(name="isOfficial")
    private Boolean isOfficial;


}
