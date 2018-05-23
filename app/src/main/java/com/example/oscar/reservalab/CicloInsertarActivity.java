package com.example.oscar.reservalab;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CicloInsertarActivity extends Activity {

    ControlBDReservacionLab helper;
    EditText editIdCiclo;
    EditText editNumCiclo;
    EditText editAnio;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciclo_insertar);

        helper= new ControlBDReservacionLab(this);
        editIdCiclo=(EditText)findViewById(R.id.editIdCiclo);
        editNumCiclo=(EditText)findViewById(R.id.editNumCiclo);
        editAnio=(EditText)findViewById(R.id.editAnio);

    }

    public void insertarCiclo(View v){

        String regInsertados;
        Integer idciclo=Integer.valueOf(editIdCiclo.getText().toString());
        Integer numciclo=Integer.valueOf(editNumCiclo.getText().toString());
        Integer anio=Integer.valueOf(editAnio.getText().toString());

        Ciclo ciclo= new Ciclo();
        ciclo.setIdCiclo(idciclo);
        ciclo.setNumCiclo(numciclo);
        ciclo.setAnio(anio);

        helper.abrir();
        regInsertados=helper.insertar(ciclo);
        helper.cerrar();

        Toast.makeText(this,regInsertados,Toast.LENGTH_SHORT).show();


    }

    public void limpiarTexto(View v){

        editNumCiclo.setText("");
        editNumCiclo.setText("");
        editAnio.setText("");

    }
}
