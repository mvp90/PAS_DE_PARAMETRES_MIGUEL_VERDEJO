package com.example.miguel.pas_de_parametres_miguel_verdejo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import static android.view.View.*;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    private Button buttonEnviar;
    private EditText insertarNom;
    private RadioButton radioButton1, radioButton2;

    private TextView mostrarEdat;
    private TextView mostrarDades2;
    String textoJoven = "Ja ets un mig home, noi!!";
    String textoMedio = "Estas en la millor part de la vida...";
    String textoMayor = "Estas calvo, tens panxa, estas per a l´arrastre ja...";
    String textoIncorrecto = "Los datos introducidos deben ser de 18 para arriba.";
    String textoNoDatos = "ERROR, NO SE HAN INTRODUCIDO DATOS";
    String textoMascle = " un home.";
    String textoFemella = " una dona.";
    String textoOtro = " no has marcado sexo";
    int dadaEdat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Asociamos elementos a la vista
        buttonEnviar = (Button) findViewById(R.id.buttonEnviar);
        insertarNom = (EditText) findViewById(R.id.insertarNom);
        radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);

        mostrarEdat = (TextView) findViewById(R.id.mostrarEdat);
        mostrarDades2 = (TextView) findViewById(R.id.mostrarDades2);


        //obtenemos valores de la segunda activity

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        //compruebo si alberga datos el bundle.
        String mensajeFinal;
        if (extras != null) {
            int dadaEdat = (int) extras.get("edat"); // Cojo la edad.

            mensajeFinal = "";
            if (dadaEdat >= 18 && dadaEdat < 25) {
                mensajeFinal = textoJoven;
            } else if (dadaEdat >= 25 && dadaEdat < 35) {
                mensajeFinal = textoMedio;
            } else if (dadaEdat >= 35) {
                mensajeFinal = textoMayor;
            } else
                mensajeFinal = textoIncorrecto;
        } else
            mensajeFinal = textoNoDatos;

    }
    buttonEnviar.setOnClickListener(this);
}


    public void onRadioButtonClicked(View v) {

        //Comprobar si hay algun boton marcado
        boolean checked = ((RadioButton) v).isChecked();

        //Comprobando que boton esta marcado
        switch(v.getId()) {
            case R.id.radioButton1:
                if (checked)
                    break;
            case R.id.radioButton2:
                if (checked)
                    break;
        }
    }

    //Clic en botón
    public void onClick(View v) {

        Intent explicit_intent;

        //Creando Intent
        explicit_intent = new Intent(this, Main2Activity.class);
        String finalNom = insertarNom.getText().toString();
        String finalSexe = "";

        if (radioButton1.isChecked()) {
            finalSexe = textoMascle;
        } else if (radioButton2.isChecked()) {
            finalSexe = textoFemella;
        } else {
            finalSexe = textoOtro;
        }

        explicit_intent.putExtra("nom", finalNom);//Guardamos una cadena
        explicit_intent.putExtra("sexe", finalSexe);//Guardamos un entero

        //lo iniciamos pasandole la intencion, con todos sus parametros guardados
        startActivity(explicit_intent);
    }}















