package group03.project.web.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Automatically builds getters/setters
 */
@Data
/**
 * Creates constructor with all field arguments inside
 */
@AllArgsConstructor
/**
 * Creates constructor option where object fields will be null.
 */
@NoArgsConstructor

public class OfficialActivityForm {
    @NotNull
    @NotBlank(message = "Please enter the activity name")
    private String name;

    @NotNull
    @NotBlank(message = "Please enter the activity's description")
    private String description;

    @NotNull
    @NotBlank(message = "Please enter the related custom tags")
    private String customTags;

    private Boolean a1;

    private Boolean a2;

    private Boolean a3;

    private Boolean a4;

    private Boolean a5;

    private Boolean d3_7;

    private Boolean k1;

    private Boolean k2;

    private Boolean k3;

    private Boolean k4;

    private Boolean k5;

    private Boolean k6;

    private Boolean v1;

    private Boolean v2;

    private Boolean v3;

    private Boolean v4;

    public Map<String, Boolean> allOfficialTags() {

        Map<String, Boolean> allOfficialTags = new HashMap<>();

        allOfficialTags.put("A1", getA1());
        allOfficialTags.put("A2", getA2());
        allOfficialTags.put("A3", getA3());
        allOfficialTags.put("A4", getA4());
        allOfficialTags.put("A5", getA5());
        allOfficialTags.put("D3.7", getD3_7());
        allOfficialTags.put("K1", getK1());
        allOfficialTags.put("K2", getK2());
        allOfficialTags.put("K3", getK3());
        allOfficialTags.put("K4", getK4());
        allOfficialTags.put("K5", getK5());
        allOfficialTags.put("K6", getK6());
        allOfficialTags.put("V1", getV1());
        allOfficialTags.put("V2", getV2());
        allOfficialTags.put("V3", getV3());
        allOfficialTags.put("V4", getV4());

        return allOfficialTags;




    }



//    public OfficialActivityForm(String name, String description, List<String> tags) {
//        this(name, description, tags);


}
