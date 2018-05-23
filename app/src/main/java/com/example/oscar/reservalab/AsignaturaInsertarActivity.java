package com.example.oscar.reservalab;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;



public class AsignaturaInsertarActivity extends Activity {

    ControlBDReservacionLab helper;
    EditText editCodAsignatura;
    EditText editNombreAsignatura;
    EditText editIdCiclo;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignatura_insertar);

        helper= new ControlBDReservacionLab(this);
        editCodAsignatura=(EditText)findViewById(R.id.editCodAsignatura);
        editNombreAsignatura=(EditText)findViewById(R.id.editNombreAsignatura);
        editIdCiclo=(EditText)findViewById(R.id.editIdCiclo);

    }

    public void insertar(View v){

        String regInsertados;
        String codigoAsignatura=editCodAsignatura.getText().toString();
        String nombreAsignatura=editNombreAsignatura.getText().toString();
        Integer numCiclo=Integer.valueOf(editIdCiclo.getText().toString());

        Asignatura asignatura= new Asignatura();
        asignatura.setCodigoAsignatura(codigoAsignatura);
        asignatura.setNombreAsignatura(nombreAsignatura);
        asignatura.setIdCiclo(numCiclo);

        helper.abrir();
        regInsertados=helper.insertar(asignatura);
        helper.cerrar();

        Toast.makeText(this,regInsertados,Toast.LENGTH_SHORT).show();


    }

    public void limpiarTexto(View v){

        editCodAsignatura.setText("");
        editNombreAsignatura.setText("");
        editIdCiclo.setText("");

    }
}
