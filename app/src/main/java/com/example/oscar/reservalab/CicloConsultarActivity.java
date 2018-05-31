package com.example.oscar.reservalab;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CicloConsultarActivity extends Activity {


    ControlBDReservacionLab helper;

    EditText editIdCiclo;
    EditText editNumCiclo;
    EditText editAnio;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciclo_consultar);
        helper = new ControlBDReservacionLab(this);

        editIdCiclo = (EditText) findViewById(R.id.editIdCiclo);
        editNumCiclo = (EditText) findViewById(R.id.editNumCiclo);
        editAnio = (EditText) findViewById(R.id.editAnio);

    }

        public void consultarCiclo(View v) {
            helper.abrir();
            Ciclo ciclo = helper.consultarCiclo(Integer.parseInt(editIdCiclo.getText().toString()));
            helper.cerrar();
            if(ciclo == null)
                Toast.makeText(this,"Ciclo con id" + editIdCiclo.getText().toString()+ "No encontrado", Toast.LENGTH_SHORT).show();
            else
            {
                editNumCiclo.setText(String.valueOf(ciclo.getNumCiclo()));
                editAnio.setText(String.valueOf(ciclo.getAnio()));

            }


        }
        public void limpiarTexto(View v){
            editIdCiclo.setText("");
            editNumCiclo.setText("");
            editAnio.setText("");

        }

}
