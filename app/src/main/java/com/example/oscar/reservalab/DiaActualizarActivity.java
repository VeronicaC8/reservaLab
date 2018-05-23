package com.example.oscar.reservalab;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DiaActualizarActivity extends Activity {

    ControlBDReservacionLab helper;
    EditText editIdDia;
    EditText editNomDia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dia_actualizar);
        helper = new ControlBDReservacionLab(this);

        editIdDia=(EditText) findViewById(R.id.editIdDia);
        editNomDia=(EditText) findViewById(R.id.editNomDia);
    }
    public void actualizarDia(View v){
        Dia dia=new Dia();
        dia.setIdDia(Integer.valueOf(editIdDia.getText().toString()));
        dia.setNomDia(editNomDia.getText().toString());

        helper.abrir();
        String estado=helper.actualizar(dia);
        helper.cerrar();
        Toast.makeText(this,estado,Toast.LENGTH_SHORT).show();

    }
    public void limpiarTexto(View v){
        editIdDia.setText("");
        editNomDia.setText("");
    }
}
