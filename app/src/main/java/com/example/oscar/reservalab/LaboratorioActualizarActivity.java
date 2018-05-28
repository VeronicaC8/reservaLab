package com.example.oscar.reservalab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LaboratorioActualizarActivity extends AppCompatActivity {

    ControlBDReservacionLab helper;
    EditText editCodLaboratorio;
    EditText editIdTipoComputo;
    EditText editPlantaLaboratorio;
    EditText editCantidadEquiposLaboratorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laboratorio_actualizar);
        helper=new ControlBDReservacionLab(this);
        editCodLaboratorio=(EditText)findViewById(R.id.editCodLaboratorio);
        editIdTipoComputo=(EditText)findViewById(R.id.editTipoComputo);
        editPlantaLaboratorio=(EditText)findViewById(R.id.editPlantaLaboratorio);
        editCantidadEquiposLaboratorio=(EditText)findViewById(R.id.editCantidadEquiposLaboratorio);
    }
    public void actualizarLaboratorio(View v){
        Laboratorio laboratorio=new Laboratorio();
        laboratorio.setCodLaboratorio(editCodLaboratorio.getText().toString());
        laboratorio.setIdTipoComputo(Integer.valueOf(editIdTipoComputo.getText().toString()));
        laboratorio.setPlantaLaboratorio(Integer.valueOf(editPlantaLaboratorio.getText().toString()));
        laboratorio.setCantidadEquiposLaboratorio(Integer.valueOf(editCantidadEquiposLaboratorio.getText().toString()));

        helper.abrir();
        String estado=helper.actualizar(laboratorio);
        helper.cerrar();

        Toast.makeText(this, estado,Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editCodLaboratorio.setText("");
        editIdTipoComputo.setText("");
        editPlantaLaboratorio.setText("");
        editCantidadEquiposLaboratorio.setText("");
    }
}
