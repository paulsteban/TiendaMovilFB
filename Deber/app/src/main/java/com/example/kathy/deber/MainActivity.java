package com.example.kathy.deber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    EditText name;
    EditText pass;
    Button user;
    Button invitado;
    String verificarUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText)  findViewById(R.id.textUsuaio);
        pass = (EditText)  findViewById(R.id.txtPass);
        user = (Button)  findViewById(R.id.buttonLoging);
        invitado = (Button)  findViewById(R.id.buttonInvitado);

    }

    public void loging(View view) {
        if (name.getText().toString().equals("Kate") && (pass.getText().toString().equals("kate"))) {
            Intent intents = new Intent(getApplicationContext(), listaPoductos.class);
            intents.putExtra("loging", verificarUser="User".toString());

            startActivity(intents);
        } else {
            Toast.makeText(getApplicationContext(), "Credenciales Incorrecta", Toast.LENGTH_SHORT).show();
        }
    }

    public void invitado(View view) {
        if ((name.getText().toString().isEmpty()) && (pass.getText().toString().isEmpty())) {
            Intent intents = new Intent(getApplicationContext(), listaPoductos.class);

            intents.putExtra("loging", verificarUser="Invitado".toString());
            startActivity(intents);
        }else {
            Toast.makeText(getApplicationContext(), "Validar", Toast.LENGTH_SHORT).show();
        }


    }
}