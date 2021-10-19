package pt.ipbeja.estig.twdm.pdm1.project.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
//falta o ano do livro
//falta tambem o numero de requisiçoes
@Entity
public class Book {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String name;
    private String description;
    private String cover;
    private String category;
    private String author;
    private String year;
    private int reqNumber;
    private boolean isFavourite;
    private boolean wasReq;
    //private long date;


    public Book(long id, String name, String description, String cover, String category, String author, String year, int reqNumber, boolean isFavourite, boolean wasReq) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cover = cover;
        this.category = category;
        this.author = author;
        this.year = year;
        this.reqNumber = reqNumber;
        this.isFavourite = isFavourite;
        this.wasReq = wasReq;

    }

    public boolean isWasReq() {
        return wasReq;
    }

    public void setWasReq(boolean wasReq) {
        this.wasReq = wasReq;
    }

    public boolean isIsFavourite() {
        return isFavourite;
    }

    public void setIsFavourite(boolean isFavourite) {
        this.isFavourite = isFavourite;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return description;
    }

    public String getCover() {
        return cover;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getAuthor() {
        return author;
    }

    public String getYear() {
        return year;
    }

    public int getReqNumber() {
        return reqNumber;
    }
}
