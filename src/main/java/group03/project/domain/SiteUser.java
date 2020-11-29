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

    @Column(name="emailAddress")
    private String emailAddress;
    @Column(name="password")
    private String password;
    @Column(name="name")
    private String name;

//    @ManyToOne
//    @JoinColumn(name = "Role_role")
//    private Role role;

    public SiteUser(String anEmailAddress, String aPassword) {
        this(null,  anEmailAddress , aPassword, null);
    }


}