package group03.project.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "objective")
public class Objective {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Length(min = 1)
    @Column(name = "objectiveID", nullable = false)
    private Long objectiveID;

    @ManyToOne
    @NotNull
    @Length(min = 1)
    @JoinColumn(name = "Activity_activityID", nullable = false)
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

