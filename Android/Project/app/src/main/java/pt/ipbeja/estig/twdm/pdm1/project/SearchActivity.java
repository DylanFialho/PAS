package pt.ipbeja.estig.twdm.pdm1.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pt.ipbeja.estig.twdm.pdm1.project.adapters.BookAdapter;
import pt.ipbeja.estig.twdm.pdm1.project.adapters.CategoryAdapter;
import pt.ipbeja.estig.twdm.pdm1.project.data.AppDataBase;
import pt.ipbeja.estig.twdm.pdm1.project.data.DataSource;
import pt.ipbeja.estig.twdm.pdm1.project.models.Book;

public class SearchActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        RecyclerView recyclerView = findViewById(R.id.recyclerView3);
        CategoryAdapter adapter = new CategoryAdapter(this, DataSource.getBookList(this));
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(layoutManager);

        TextView editTextSearchBook = findViewById(R.id.searchView);

        editTextSearchBook.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                List<Book> book = AppDataBase.getInstance(SearchActivity.this).getBookDao().getBookBySearch(editTextSearchBook.getText().toString());
                RecyclerView recyclerView = findViewById(R.id.recyclerView3);
                CategoryAdapter adapter = new CategoryAdapter(SearchActivity.this, book);
                recyclerView.setAdapter(adapter);
                LinearLayoutManager layoutManager = new LinearLayoutManager(SearchActivity.this, LinearLayoutManager.VERTICAL, false);
                recyclerView.setLayoutManager(new LinearLayoutManager(SearchActivity.this));
                recyclerView.setLayoutManager(layoutManager);
            }
        });


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

    public void goToFavouriteActivity(View view) {
        Intent intent = new Intent(this, FavouriteActivity.class);
        startActivity(intent);
    }

    public void goToHistoryActivity(View view) {
        Intent intent = new Intent(this, HistoricalActivity.class);
        startActivity(intent);
    }

    public void goToCategoryArt(View view) {
        Intent intent = new Intent(this, CategoryArt.class);
        startActivity(intent);
    }

    public void goToCategoryRomance(View view) {
        Intent intent = new Intent(this, CategoryRomance.class);
        startActivity(intent);
    }

    public void goToActivityComedy(View view) {
        Intent intent = new Intent(this, CategoryComedy.class);
        startActivity(intent);
    }
}
