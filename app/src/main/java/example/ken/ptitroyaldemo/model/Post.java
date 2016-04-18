package example.ken.ptitroyaldemo.model;

import java.io.Serializable;

/**
 * Created by Ken on 16/04/2016.
 */
public class Post implements Serializable {
    private int id;
    private String username;
    private String time;
    private String content;
    private String imageURI;
    private int numberOfLikes;
    private int numberOfComments;

    public Post() {
    }

    public Post(int id, String username, String time, String content, String imageURI, int numberOfLikes, int numberOfComments) {
        this.id = id;
        this.username = username;
        this.time = time;
        this.content = content;
        this.imageURI = imageURI;
        this.numberOfLikes = numberOfLikes;
        this.numberOfComments = numberOfComments;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageURI() {
        return imageURI;
    }

    public void setImageURI(String imageURI) {
        this.imageURI = imageURI;
    }

    public int getNumberOfLikes() {
        return numberOfLikes;
    }

    public void setNumberOfLikes(int numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

    public int getNumberOfComments() {
        return numberOfComments;
    }

    public void setNumberOfComments(int numberOfComments) {
        this.numberOfComments = numberOfComments;
    }

    public void incLike() {
        ++this.numberOfLikes;
    }
}
