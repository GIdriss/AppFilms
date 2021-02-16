package com.example.appfilms;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import static android.view.View.OnClickListener;

public class Login extends AppCompatActivity {

    EditText edtName;
    EditText edtPassword;
    Button btnValider;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Boolean savelogin;
    CheckBox savelogincheckbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newlogin);

        edtName = (EditText) findViewById(R.id.edtName);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        btnValider = (Button) findViewById(R.id.btnValider);

        sharedPreferences = getSharedPreferences("loginref", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        btnValider.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                valider();

            }
        });
        savelogin = sharedPreferences.getBoolean("savelogin", true);
        if (savelogin == true) {
            edtName.setText(sharedPreferences.getString("username", null));
            edtPassword.setText(sharedPreferences.getString("password", null));
        }
    }
        public void valider () {

            String username = edtName.getText().toString();
            String password = edtPassword.getText().toString();

            if ((username.equals("")) || (password.equals("")))
                Toast.makeText(Login.this, "veuillez entrer une valeur cohérente!!", Toast.LENGTH_SHORT).show();
            else {
                // Si l'utilisateur a indiqué ces bons codes
                if ((username.equals("admin")) && (password.equals("admin"))) {
//                        editor.putBoolean("savelogin", true);
                        editor.putString("username", username);
                        editor.putString("password", password);
                        editor.commit();
                    //}
                    Intent x = new Intent(Login.this, MainMovie.class);
                    Log.d("Affich", "login " + username);
                    Log.d("Affich", "mdp " + password);

                    raz();
                    startActivity(x);
                } else {
                    Toast.makeText(Login.this, "Nom ou mot de pass erroné!!", Toast.LENGTH_SHORT).show();
                    raz();
                }
            }
        }

        // Listener du bouton de remise à zéro
        public void raz ()
        {
            edtName.getText().clear();
            edtPassword.getText().clear();
        }
}

