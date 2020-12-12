package group03.project.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Reflection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="reflectionID")
    private Integer reflectionID;
    @Column(name="Participation_participationID")
    private Integer participationID;
    @Column(name="Tag_tagID")
    private Integer tagID;
    @Column(name="Reflect_what")
    private String reflect_what;
    @Column(name="Reflect_prompt")
    private String reflect_prompt;
    @Column(name="Reflect_happen")
    private String reflect_happen;
    @Column(name="Reflect_eval")
    private String reflect_eval;
    @Column(name="Reflect_diff")
    private String reflect_diff;
    @Column(name="Reflect_lp")
    private String reflect_lp;
    @Column(name="isPublic")
    private Boolean isPublic;

}
