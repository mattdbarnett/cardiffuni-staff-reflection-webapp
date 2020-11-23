package group03.project.user;

public class User {

    private int userID;
    private String name;
    private String address;
    private String position;
    private int tel;
    private int roleID;

    public User() {

    }

    public User(int userID, String name, String address, String position, int tel, int roleID) {
        this.userID = userID;
        this.name = name;
        this.address = address;
        this.position = position;
        this.tel = tel;
        this.roleID = roleID;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }
}
