package pt.ipbeja.estig.twdm.pdm1.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

public class IntroActivity extends AppCompatActivity {

    public static double time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        getSupportActionBar().hide();

        Handler handle = new Handler(getMainLooper());
        handle.postDelayed(new Runnable() {
            @Override public void run() {
                showLogin();
            }
        }, 3000);


        ProgressBar bar = (ProgressBar) findViewById(R.id.progressBar);
        bar.setProgress((int) ((time / 30.0) * 100));
    }


    private void showLogin() {

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

}