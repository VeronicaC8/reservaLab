package com.example.oscar.reservalab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DiaEliminarActivity extends AppCompatActivity {

    EditText editIdDia;
    ControlBDReservacionLab controlhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dia_eliminar);
        controlhelper=new ControlBDReservacionLab(this);
        editIdDia=(EditText)findViewById(R.id.editIdDia);
    }

    public void eliminarDia(View v){
        String regEliminadas;
        Dia dia=new Dia();
        dia.setIdDia(Integer.valueOf(editIdDia.getText().toString()));
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(dia);
        controlhelper.cerrar();
        Toast.makeText(this,regEliminadas,Toast.LENGTH_SHORT).show();
    }
}
