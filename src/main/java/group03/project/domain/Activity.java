package group03.project.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Activity {

    @Id
    private Integer activityID;
    private Integer userID;
    private String name;
    private String file;
    private String desc;

    public Activity() {

    }

    public Activity(int activityID, int userID, String name, String file, String desc) {
        this.activityID = activityID;
        this.userID = userID;
        this.name = name;
        this.file = file;
        this.desc = desc;
    }

    public int getActivityID() {
        return activityID;
    }

    public void setActivityID(int activityID) {
        this.activityID = activityID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
