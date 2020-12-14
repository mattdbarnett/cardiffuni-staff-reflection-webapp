package group03.project.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "objective")
public class Objective {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "objectiveID")
    private Long objectiveID;

    @ManyToOne
    @JoinColumn(name = "Activity_activityID")
    private Activity activity;

    @ManyToOne
    @JoinColumn(name = "Tag_tagID")
    private Tag tag;

    public Objective(Activity theActivity, Tag theTag) {
        this(null, theActivity, theTag);
    }

//
//    public Tag(String tagName, String theDescription, Boolean isOfficial) {
//        this(null, tagName, theDescription, isOfficial);
    }

//    public Tag(Long id, String tagName) {
//        this(id, tagName, null, null);
//    }

