package com.example.oscar.reservalab;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DiaConsultarActivity extends Activity {

    ControlBDReservacionLab helper;
    EditText editIdDia;
    EditText editNomDia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dia_consultar);
        helper = new ControlBDReservacionLab(this);

        editIdDia=(EditText) findViewById(R.id.editIdDia);
        editNomDia=(EditText)findViewById(R.id.editNomDia);

    }
    public void consultarDia(View v){
        helper.abrir();
        Dia dia=helper.consultarDia(Integer.valueOf(editIdDia.getText().toString()));
        helper.cerrar();
        if(dia==null)
            Toast.makeText(this,"Dia con Id "+editIdDia.getText().toString()+" no encontrado", Toast.LENGTH_SHORT).show();
        else{
            editNomDia.setText(dia.getNomDia());
        }
    }
    public void limpiarTexto(View v){
        editIdDia.setText("");
        editNomDia.setText("");
    }
}
