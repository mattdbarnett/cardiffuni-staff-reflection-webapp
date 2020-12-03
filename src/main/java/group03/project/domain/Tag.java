package group03.project.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tag")
public class Tag {

    @Id
    @Column(name = "tagID")
    private String tagID;

    @Column(name = "description")
    private String description;

    @Column(name = "isOfficial")
    private Boolean isOfficial;

    public Tag(String aTagID, String theDescription) {
        tagID = aTagID;
        description = theDescription;
        isOfficial = false;
    }
}
