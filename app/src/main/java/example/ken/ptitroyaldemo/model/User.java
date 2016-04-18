package example.ken.ptitroyaldemo.model;

import java.io.Serializable;

/**
 * Created by Ken on 18/04/2016.
 */
public class User implements Serializable {
    private String id;
    private String username;
    private String avatarURI;
    private String token;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatarURI() {
        return avatarURI;
    }

    public void setAvatarURI(String avatarURI) {
        this.avatarURI = avatarURI;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User(String id, String username, String avatarURI, String token) {

        this.id = id;
        this.username = username;
        this.avatarURI = avatarURI;
        this.token = token;
    }
}
