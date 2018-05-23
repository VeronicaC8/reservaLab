package com.example.oscar.reservalab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LaboratorioInsertarActivity extends AppCompatActivity {

    ControlBDReservacionLab helper;
    EditText editIdTipoComputo;
    EditText editCodLaboratorio;
    EditText editPlantaLaboratorio;
    EditText editCantidadEquiposLaboratorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laboratorio_insertar);

        helper=new ControlBDReservacionLab(this);
        editIdTipoComputo=(EditText)findViewById(R.id.editTipoComputo);
        editCodLaboratorio=(EditText)findViewById(R.id.editCodLaboratorio);
        editPlantaLaboratorio=(EditText)findViewById(R.id.editPlantaLaboratorio);
        editCantidadEquiposLaboratorio=(EditText)findViewById(R.id.editCantidadEquiposLaboratorio);

        //Integer idDia=Integer.valueOf(editIdDia.getText().toString());

        //laboratorio(codLaboratorio VARCHAR(6) NOT NULL PRIMARY KEY, idTipoComputo INTEGER NOT NULL, plantaLaboratorio INTEGER NOT NULL, cantidadEquiposLaboratorio INTEGER NOT NULL);");
    }
    public void insertarLaboratorio(View v) {
        String regInsertados;
        String codLaboratorio=editCodLaboratorio.getText().toString();
        Integer idTipoComputo=Integer.valueOf(editIdTipoComputo.getText().toString());
        Integer plantaLaboratorio=Integer.valueOf(editPlantaLaboratorio.getText().toString());
        Integer cantidadEquiposLaboratorio=Integer.valueOf(editCantidadEquiposLaboratorio.getText().toString());

        Laboratorio laboratorio= new Laboratorio();
        laboratorio.setCodLaboratorio(codLaboratorio);
        laboratorio.setIdTipoComputo(idTipoComputo);
        laboratorio.setPlantaLaboratorio(plantaLaboratorio);
        laboratorio.setCantidadEquiposLaboratorio(cantidadEquiposLaboratorio);
        helper.abrir();
        regInsertados=helper.insertar(laboratorio);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editCodLaboratorio.setText("");
        editIdTipoComputo.setText("");
        editPlantaLaboratorio.setText("");
        editCantidadEquiposLaboratorio.setText("");
    }
}
