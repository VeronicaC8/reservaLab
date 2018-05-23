package com.example.oscar.reservalab;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AsignaturaActualizarActivity extends Activity {

    ControlBDReservacionLab helper;
    EditText editCod;
    EditText editNombre;
    EditText editAnio;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignatura_actualizar);

        helper = new ControlBDReservacionLab(this);
        editCod = (EditText) findViewById(R.id.editCod);
        editNombre = (EditText) findViewById(R.id.editNombre);
        editAnio = (EditText) findViewById(R.id.editAnio);

    }
    public void actualizarAsignatura(View v) {
        Asignatura asignatura = new Asignatura();
        asignatura.setCodigoAsignatura(editCod.getText().toString());
        asignatura.setNombreAsignatura(editNombre.getText().toString());
        asignatura.setIdCiclo(Integer.valueOf(editAnio.getText().toString()));

        helper.abrir();
        String estado = helper.actualizar(asignatura);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editCod.setText("");
        editNombre.setText("");
        editAnio.setText("");

    }
}
