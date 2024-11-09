package vn.edu.usth.facebookclient;

public class Post {
    private int avatar,imagePost, icon;
    private String updatedText, time, iconNumber, commentNumber;
    private boolean expanded;


    public Post(int avatar, int imagePost, int icon, String updatedText, String time, String iconNumber, String commentNumber) {
        this.avatar = avatar;
        this.imagePost = imagePost;
        this.icon = icon;
        this.updatedText = updatedText;
        this.time = time;
        this.iconNumber = iconNumber;
        this.commentNumber = commentNumber;
        this.expanded = false;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public int getImagePost() {
        return imagePost;
    }

    public void setImagePost(int imagePost) {
        this.imagePost = imagePost;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getUpdatedText() {
        return updatedText;
    }

    public void setUpdatedText(String updatedText) {
        this.updatedText = updatedText;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getIconNumber() {
        return iconNumber;
    }

    public void setIconNumber(String iconNumber) {
        this.iconNumber = iconNumber;
    }

    public String getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(String commentNumber) {
        this.commentNumber = commentNumber;
    }
    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }
}
