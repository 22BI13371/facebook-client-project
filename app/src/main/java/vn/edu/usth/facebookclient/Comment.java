package vn.edu.usth.facebookclient;

public class Comment {
    String id;
    String name;
    String profile;
    String published;
    String comment;

    public Comment(String id, String name, String profile, String published, String comment) {
        this.id = id;
        this.name = name;
        this.profile = profile;
        this.published = published;
        this.comment = comment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
