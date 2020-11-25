package group03.project.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="siteUser")
public class SiteUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userID")
    private Long userID;

    private String name;
    @Column(name="homeAddress")
    private String homeAddress;
    @Column(name="emailAddress")
    private String emailAddress;
    private String position;
    @Column(name="phoneNo")
    private Integer phoneNo;

    @ManyToOne
    @JoinColumn(name = "Role_role")
    private Role role;

    public SiteUser(String aName, String aHomeAddress, String anEmailAddress, String aPosition, Integer aPhoneNo, Role aRole) {
        this(null, aName, aHomeAddress,anEmailAddress , aPosition, aPhoneNo, aRole);
    }


}