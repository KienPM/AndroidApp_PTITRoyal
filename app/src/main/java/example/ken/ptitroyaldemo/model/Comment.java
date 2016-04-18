package example.ken.ptitroyaldemo.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Ken on 17/04/2016.
 */
public class Comment implements Serializable {
    private int id;
    private String username;
    private String replyTo;
    private String time;
    private String content;
    private List<String> mentioned;

    public Comment() {
    }

    public Comment(int id, String username, String replyTo, String time, String content) {
        this.id = id;
        this.username = username;
        this.replyTo = replyTo;
        this.time = time;
        this.content = content;
    }

    public Comment(int id, String username, String replyTo, String time, String content, List<String> mentioned) {
        this.id = id;
        this.username = username;
        this.replyTo = replyTo;
        this.time = time;
        this.content = content;
        this.mentioned = mentioned;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<String> getMentioned() {
        return mentioned;
    }

    public void setMentioned(List<String> mentioned) {
        this.mentioned = mentioned;
    }

    public String getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(String replyTo) {
        this.replyTo = replyTo;
    }
}
