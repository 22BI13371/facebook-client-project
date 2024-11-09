package vn.edu.usth.facebookclient.FriendProfile;

public class Friend {
    private String id;
    private String name;
    private String avatar;
    private String background;
    private String education;
    private String location;
    private String homeTown;
    private String relationshipStatus;

    // Constructor
    public Friend(String id, String name, String avatar, String background,
                  String education, String location, String homeTown, String relationshipStatus) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.background = background;
        this.education = education;
        this.location = location;
        this.homeTown = homeTown;
        this.relationshipStatus = relationshipStatus;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getAvatar() { return avatar; }
    public String getBackground() { return background; }
    public String getEducation() { return education; }
    public String getLocation() { return location; }
    public String getHomeTown() { return homeTown; }
    public String getRelationshipStatus() { return relationshipStatus; }

    // Setters
    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setAvatar(String avatar) { this.avatar = avatar; }
    public void setBackground(String background) { this.background = background; }
    public void setEducation(String education) { this.education = education; }
    public void setLocation(String location) { this.location = location; }
    public void setHomeTown(String homeTown) { this.homeTown = homeTown; }
    public void setRelationshipStatus(String relationshipStatus) { this.relationshipStatus = relationshipStatus; }
}
