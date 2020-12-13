package group03.project.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Participation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="participationID")
    private Long participationID;
    @Column(name="Activity_activityID")
    private Long activityID;
    @DateTimeFormat
    @Column(name="date")
    private Date date;
    @Column(name="Role_roleID")
    private String roleID;
    @Column(name="siteUser_userID")
    private Long userID;

}
