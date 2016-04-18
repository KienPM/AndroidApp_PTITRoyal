package example.ken.ptitroyaldemo.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Ken on 17/04/2016.
 */
public class Comment implements Serializable {
    private String id;
    private User owner;
    private User replyTo;
    private String time;
    private String content;
    private List<User> mentioned;

    public Comment() {
    }

    public Comment(String id, User owner, User replyTo, String time, String content, List<User> mentioned) {
        this.id = id;
        this.owner = owner;
        this.replyTo = replyTo;
        this.time = time;
        this.content = content;
        this.mentioned = mentioned;
    }

    public Comment(String id, User owner, User replyTo, String time, String content) {

        this.id = id;
        this.owner = owner;
        this.replyTo = replyTo;
        this.time = time;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public User getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(User replyTo) {
        this.replyTo = replyTo;
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

    public List<User> getMentioned() {
        return mentioned;
    }

    public void setMentioned(List<User> mentioned) {
        this.mentioned = mentioned;
    }
}
