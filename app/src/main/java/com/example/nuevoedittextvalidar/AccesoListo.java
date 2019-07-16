package com.example.nuevoedittextvalidar;

import android.content.Context;
//import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class AccesoListo extends AppCompatActivity {

    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceso_listo);
        tv1=(TextView)findViewById(R.id.tv1);

        String usuariollega=getIntent().getStringExtra("usuario"); ///optengo los dtos del primer activity

        tv1.setText("Hola Usuario "+usuariollega); //lo muestro en el Text view
    }

    public void  Anterior(View view){

        Toast.makeText(this,"Te estas Saliendo",Toast.LENGTH_LONG).show();
        SharedPreferences preferences = getSharedPreferences("datosdepreferencias", Context.MODE_PRIVATE); ///istanciamos el archivo datospreferencoas
        SharedPreferences.Editor Obj_editor = preferences.edit(); //editar el archivo
        Obj_editor.putString("usuario",tv1.getText().toString());
        Obj_editor.commit();
        finish();

        //Intent anterior = new Intent(this,MainActivity.class); ///camnbia de activity a la anterior

        //startActivity(anterior);

    }
}
