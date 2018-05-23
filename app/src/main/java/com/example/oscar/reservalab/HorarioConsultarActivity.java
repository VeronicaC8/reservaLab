package com.example.oscar.reservalab;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import javax.microedition.khronos.egl.EGLDisplay;

public class HorarioConsultarActivity extends Activity {

    ControlBDReservacionLab helper;
    EditText editIdHorario;
    EditText editHoraInicio;
    EditText editHoraFin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario_consultar);
        helper = new ControlBDReservacionLab(this);

        editIdHorario=(EditText) findViewById(R.id.editIdHorario);
        editHoraInicio=(EditText) findViewById(R.id.editHorarioInicio);
        editHoraFin=(EditText)findViewById(R.id.editHoraFin);

    }
    public void consultarHorario(View v){
        helper.abrir();
        Horario horario=helper.consultarHorario(Integer.valueOf(editIdHorario.getText().toString()));
        helper.cerrar();
        if(horario==null)
            Toast.makeText(this,"Horario con Id "+String.valueOf(editIdHorario.getText().toString())+" no encontrado", Toast.LENGTH_SHORT).show();
        else{
            editHoraInicio.setText(horario.getHoraInicio());
            editHoraFin.setText(horario.getHoraFin());
        }
    }
    public void limpiarTexto(View v){
        editIdHorario.setText("");
        editHoraInicio.setText("");
        editHoraFin.setText("");
    }
}
