package group03.project.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tag")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tagID")
    private Integer tagID;

    @Column(name = "tagName")
    private String tagName;

    @Column(name = "description")
    private String description;

    @Column(name = "isOfficial")
    private Boolean isOfficial;

    public Tag(String name, String theDescription, Boolean isOfficial) {
        this(null, name, theDescription, isOfficial);
    }
}
