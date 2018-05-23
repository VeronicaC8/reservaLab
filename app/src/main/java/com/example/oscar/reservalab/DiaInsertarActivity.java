package com.example.oscar.reservalab;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DiaInsertarActivity extends Activity {

    ControlBDReservacionLab helper;
    EditText editIdDia;
    EditText editNomDia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dia_insertar);
        helper = new ControlBDReservacionLab(this);

        editIdDia=(EditText) findViewById(R.id.editIdDia);
        editNomDia=(EditText) findViewById(R.id.editNomDia);

    }
    public void insertarDia(View v){
        Integer idDia=Integer.valueOf(editIdDia.getText().toString());
        String nomDia=editNomDia.getText().toString();
        String regInsertados;
        Dia dia=new Dia();
        dia.setIdDia(idDia);
        dia.setNomDia(nomDia);
        helper.abrir();
        regInsertados=helper.insertar(dia);
        helper.cerrar();
        Toast.makeText(this,regInsertados,Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v){
        editIdDia.setText("");
        editNomDia.setText("");
    }
}
