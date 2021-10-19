package pt.ipbeja.estig.twdm.pdm1.project.models;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey (autoGenerate = true)
    private long id;
    private String name;
    private String email;
    private String password;
    //private boolean favourite;


    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        //this.favourite = favourite;
    }

    //public boolean isFavourite() { return favourite; }

   // public void setFavourite(boolean favourite) { this.favourite = favourite; }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
