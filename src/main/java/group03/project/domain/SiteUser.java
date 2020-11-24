package group03.project.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SiteUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;

    private String name;
    private String homeAddress;
    private String emailAddress;
    private String position;
    private Integer phoneNo;

    @ManyToOne
    @JoinColumn(name = "type")
    private Role role;

    public SiteUser(String aName, String aHomeAddress, String anEmailAddress, String aPosition, Integer aPhoneNo, Role aRole) {
        this(null, aName, aHomeAddress,anEmailAddress , aPosition, aPhoneNo, aRole);
    }


}