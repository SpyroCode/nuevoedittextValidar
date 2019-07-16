package com.example.nuevoedittextvalidar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etn,etp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etn =(EditText)findViewById(R.id.txt_nombre);

        ///guardar las preferencias

        SharedPreferences preferences = getSharedPreferences("datosdepreferencias", Context.MODE_PRIVATE);
        etn.setText(preferences.getString("usuario",""));

        ///aqui terminan

        etp=(EditText)findViewById(R.id.txt_pws);
    }

    public void validar(View view){

        String nombre = etn.getText().toString();
        String pws = etp.getText().toString();

        if(nombre.length() == 0){
            Toast.makeText(this,"Debes de ingredsar usuario",Toast.LENGTH_LONG).show();;

        }
        if (pws.length()==0){
            Toast.makeText(this,"Debes Ingresar un Password ",Toast.LENGTH_SHORT).show();
        }
        if (nombre.length()!=0 && pws.length()!=0){
            Toast.makeText(this,"Te estas Accediendo",Toast.LENGTH_LONG).show();
            Intent acceder = new Intent(this,AccesoListo.class); ///envia de uno a otro activite
            acceder.putExtra("usuario",etn.getText().toString()); //se lleva la informacion del usuario al segundo activity
            startActivity(acceder); //envia o accede al segundo activty

        }

    }
}
