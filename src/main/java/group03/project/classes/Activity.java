package group03.project.activity;

public class Activity {

    private int activityID;
    private int userID;
    private String file;
    private String desc;

    public Activity() {

    }

    public Activity(int activityID, int userID, String file, String desc) {
        this.activityID = activityID;
        this.userID = userID;
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
