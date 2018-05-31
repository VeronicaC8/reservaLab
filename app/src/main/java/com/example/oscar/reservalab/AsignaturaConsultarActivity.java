package com.example.oscar.reservalab;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class AsignaturaConsultarActivity extends Activity {

    ControlBDReservacionLab helper;

    EditText editCod;
    EditText editNombre;
    EditText editAnio;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignatura_consultar);
        helper = new ControlBDReservacionLab(this);

        editCod = (EditText) findViewById(R.id.editCod);
        editNombre = (EditText) findViewById(R.id.editNombre);
        editAnio = (EditText) findViewById(R.id.editAnio);

    }

    public void consultar(View v) {
        helper.abrir();
        Asignatura asignatura = helper.consultarAsignatura(editCod.getText().toString());
       // Asignatura asignatura = helper.consultarAsignatura(editCod.getText().toString());
        helper.cerrar();
        if(asignatura == null)
            Toast.makeText(this,"Asignatura con codigo" + editCod.getText().toString()+ "No encontrado", Toast.LENGTH_SHORT).show();
        else
        {
            editNombre.setText(asignatura.getNombreAsignatura());
            editAnio.setText(String.valueOf(asignatura.getIdCiclo()));

        }


    }
    public void limpiarTexto(View v){
        editAnio.setText("");
        editNombre.setText("");
        editAnio.setText("");

    }

}
