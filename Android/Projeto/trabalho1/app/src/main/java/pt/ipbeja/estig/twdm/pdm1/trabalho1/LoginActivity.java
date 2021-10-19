package pt.ipbeja.estig.twdm.pdm1.trabalho1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText userId, password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userId = findViewById(R.id.userId);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userIdText = userId.getText().toString();
                String passwordText = password.getText().toString();
                if (userIdText.isEmpty() || passwordText.isEmpty()){

                    Toast.makeText(getApplicationContext(),"Preencha todos os campos!", Toast.LENGTH_SHORT).show();

                }else{

                    UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                    UserDao userDao = userDatabase.userDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            UserEntity userEntity = userDao.login(userIdText, passwordText);
                            if (userEntity == null){
                               runOnUiThread(new Runnable() {
                                   @Override
                                   public void run() {
                                       Toast.makeText(getApplicationContext(),"Dados Inválidos!", Toast.LENGTH_SHORT).show();
                                   }
                               });
                            }else {

                               startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            }
                        }
                    }).start();
                }
            }
        });
    }

    public void goToRegister(View view) {

        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);

    }
}