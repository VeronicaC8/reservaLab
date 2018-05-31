package com.example.oscar.reservalab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LaboratorioConsultarActivity extends AppCompatActivity {
    ControlBDReservacionLab helper;
    EditText editCodLaboratorio;
    EditText editIdTipoComputo;
    EditText editPlantaLaboratorio;
    EditText editCantidadEquiposLaboratorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laboratorio_consultar);
        helper=new ControlBDReservacionLab(this);

        editCodLaboratorio=(EditText)findViewById(R.id.editCodLaboratorio);
        editIdTipoComputo=(EditText)findViewById(R.id.editTipoComputo);
        editPlantaLaboratorio=(EditText)findViewById(R.id.editPlantaLaboratorio);
        editCantidadEquiposLaboratorio=(EditText)findViewById(R.id.editCantidadEquiposLaboratorio);
    }
    public void consultarLaboratorio(View v){
        helper.abrir();
        Laboratorio laboratorio=helper.consultarLaboratorio(editCodLaboratorio.getText().toString());
        helper.cerrar();
        if(laboratorio==null){
            Toast.makeText(this,"Laboratorio no registrado",Toast.LENGTH_LONG).show();
        }else{
            editIdTipoComputo.setText(String.valueOf(laboratorio.getIdTipoComputo()));
            editPlantaLaboratorio.setText(String.valueOf(laboratorio.getPlantaLaboratorio()));
            editCantidadEquiposLaboratorio.setText(String.valueOf(laboratorio.getCantidadEquiposLaboratorio()));

        }
    }
    public void limpiarTexto(View v) {
        editCodLaboratorio.setText("");
        editIdTipoComputo.setText("");
        editPlantaLaboratorio.setText("");
        editCantidadEquiposLaboratorio.setText("");
    }
}
