package pt.ipbeja.estig.twdm.pdm1.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import pt.ipbeja.estig.twdm.pdm1.project.adapters.FavouriteAdapter;
import pt.ipbeja.estig.twdm.pdm1.project.data.AppDataBase;
import pt.ipbeja.estig.twdm.pdm1.project.data.BookDao;
import pt.ipbeja.estig.twdm.pdm1.project.data.DataSource;
import pt.ipbeja.estig.twdm.pdm1.project.models.Book;

public class FavouriteActivity extends AppCompatActivity {

    private Button button2;
    private CheckBox checkBox;
    private Book book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);
        RecyclerView recyclerView = findViewById(R.id.recyclerView110);
        FavouriteAdapter adapter = new FavouriteAdapter(this, DataSource.getBookFavourite(this));
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(layoutManager);



    }


    public void goToSearchActivity(View view) {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }

    public void goToCategoryActivity(View view) {
        Intent intent = new Intent(this, CategoriesActivity.class);
        startActivity(intent);
    }

    public void goToMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void goToScheduleActivity(View view) {
        Intent intent = new Intent(this, ScheduleActivity.class);
        startActivity(intent);
    }

    public void goToHistoryActivity(View view) {
        Intent intent = new Intent(this, HistoricalActivity.class);
        startActivity(intent);
    }
}