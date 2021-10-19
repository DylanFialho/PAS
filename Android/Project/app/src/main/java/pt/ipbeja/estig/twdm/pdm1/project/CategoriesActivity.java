package pt.ipbeja.estig.twdm.pdm1.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CategoriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
    }


    public void goToCategoryArt(View view) {
        Intent intent = new Intent(this, CategoryArt.class);
        startActivity(intent);
    }


    public void goToCategoryDicionary(View view) {
        Intent intent = new Intent(this, CategoryDicionary.class);
        startActivity(intent);
    }


    public void goToCategorySports(View view) {
        Intent intent = new Intent(this, CategorySports.class);
        startActivity(intent);
    }

    public void goToCategoryRomance(View view) {
        Intent intent = new Intent(this, CategoryRomance.class);
        startActivity(intent);
    }

    public void goToCategoryKids(View view) {
        Intent intent = new Intent(this, CategoryKids.class);
        startActivity(intent);
    }

    public void goToCategoryComedy(View view) {
        Intent intent = new Intent(this, CategoryComedy.class);
        startActivity(intent);
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
}