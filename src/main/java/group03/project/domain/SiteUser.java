package group03.project.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;

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

    @Column(name="emailAddress")
    @Email
    private String emailAddress;
    @Column(name="password")
    private String password;
    @Column(name="name")
    private String userName;
    @Column
    private Boolean isActive;
    @Column
    private String permissions;


    public SiteUser(String anEmailAddress, String aPassword, String aUsername) {
        this(null,  anEmailAddress , aPassword, aUsername, null, null);
    }


}