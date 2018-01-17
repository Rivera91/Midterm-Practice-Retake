package nyc.c4q.midtermretake;

import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private static final String SHARED_PREFS_KEY = "sharedPrefsKey";
    private EditText email;
    private EditText password;
    private CheckBox save;
    private Button submit;
    private SharedPreferences login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = getApplicationContext().getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        save = findViewById(R.id.save);
        submit = findViewById(R.id.Submit);

        submit = findViewById(R.id.Submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = login.edit();
                String checkUser = "user@aol.com";
                String checkPassword = "password1234";

                if (save.isChecked()) {
                    editor.putString("email", email.getText().toString());
                    editor.putString("password", password.getText().toString());
                    editor.putBoolean("isChecked", save.isChecked());
                    editor.commit();
                } else {
                    editor.putBoolean("isChecked", save.isChecked());
                    editor.commit();
                }
                if (email.getText().toString().contains(checkUser) && password.getText().toString().contains(checkPassword)) {
                    Intent intent = new Intent(LoginActivity.this, ListActivity.class);
                    intent.putExtra("currentUser", email.getText().toString());
                    startActivity(intent);
                } else {
                    email.setError("Invalid Email");
                    password.setError("Invalid Password");
                    email.requestFocus();
                    password.requestFocus();
                }
            }
        });

        if (login.getBoolean("isChecked", false)) {
            email.setText(login.getString("username", null));
            password.setText(login.getString("password", null));
            save.setChecked(login.getBoolean("isChecked", false));
        }
    }
}




