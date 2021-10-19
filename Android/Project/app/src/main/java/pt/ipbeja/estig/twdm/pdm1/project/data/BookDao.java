package pt.ipbeja.estig.twdm.pdm1.project.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import pt.ipbeja.estig.twdm.pdm1.project.models.Book;
import pt.ipbeja.estig.twdm.pdm1.project.models.User;

@Dao
public interface BookDao {

    @Query("SELECT * FROM Book")
    List<Book> getAll();

    @Query("SELECT * FROM Book WHERE id = :id")
    Book getById(long id);

    @Query("SELECT * FROM Book ORDER BY reqNumber DESC")
    List<Book> getByPopular();

    @Query("SELECT * FROM Book WHERE category = 'Artes'")
    List<Book> getByArt();

    @Query("SELECT * FROM Book WHERE category = 'Comédia'")
    List<Book> getByComedy();

    @Query("SELECT * FROM Book WHERE category = 'Criança'")
    List<Book> getByKids();

    @Query("SELECT * FROM Book WHERE category = 'Desporto'")
    List<Book> getBySports();

    @Query("SELECT * FROM Book WHERE category = 'Dicionário'")
    List<Book> getByDictionary();

    @Query("SELECT * FROM Book WHERE category = 'Romance'")
    List<Book> getByRomantic();

    @Query("SELECT * FROM Book WHERE isFavourite = 1")
    List<Book> getByFavourite();

    @Query("SELECT * FROM Book WHERE wasReq = 1")
    List<Book> getByReq();

    @Query("SELECT * FROM Book WHERE name LIKE '%' || :search || '%' OR author LIKE '%' || :search || '%'")
    List<Book> getBookBySearch(String search);

    @Query("SELECT * FROM Book WHERE id = :bookID")
    Book checkReq(String bookID);

    @Insert
    void add(Book book);

    @Insert
    void add(List<Book> books);

    @Delete
    void delete(Book book);

    @Update
    void update(Book book);
}
