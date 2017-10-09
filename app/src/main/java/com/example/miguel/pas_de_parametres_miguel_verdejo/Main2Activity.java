package com.example.miguel.pas_de_parametres_miguel_verdejo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity implements View.OnClickListener {

    TextView mostrarDades2;
    private EditText insertaEdat;
    private Button buttonContinuar;

    String textHola = "HOLA ";
    String textEres = " tu eres ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mostrarDades2 = (TextView) findViewById( R.id.mostrarDades2 );
        insertaEdat = (EditText) findViewById(R.id.insertaEdat);
        buttonContinuar = (Button) findViewById(R.id.buttonContinuar);

        Intent intent=getIntent();
        Bundle extras =intent.getExtras();
        if (extras != null) {//ver si contiene datos
            String datoNombre=(String)extras.get("nom");//Obtengo el nombre
            String datoSexo= (String) extras.get("sexe");//Obtengo la edad

            mostrarDades2.setText(textHola +  datoNombre + textEres + datoSexo);

        }

        buttonContinuar.setOnClickListener(this);
    }

    //Clic en botón
    public void onClick(View v) {

        Intent explicit_intent;//Declaro el Intent

        //Creando Intent
        explicit_intent = new Intent(this,MainActivity.class);
        int finalEdat = Integer.parseInt(insertaEdat.getText().toString());

        explicit_intent.putExtra("edad",finalEdat);
        //Guardo el int de la edad

        //lo iniciamos pasandole la intencion, con todos sus parametros guardados
        startActivity(explicit_intent);
    }
}