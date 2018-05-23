package com.example.oscar.reservalab;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LaboratorioEliminarActivity extends AppCompatActivity {

    EditText editCodLaboratorio, editTipoComputo, editPlantaLaboratorio,editCantidadEquiposLaboratorio;
    ControlBDReservacionLab controlhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laboratorio_eliminar);
        controlhelper=new ControlBDReservacionLab(this);
        editCodLaboratorio=(EditText)findViewById(R.id.editCodLaboratorio);
        editTipoComputo=(EditText)findViewById(R.id.editTipoComputo);
        editPlantaLaboratorio=(EditText)findViewById(R.id.editPlantaLaboratorio);
        editCantidadEquiposLaboratorio=(EditText)findViewById(R.id.editCantidadEquiposLaboratorio);
    }
    public void eliminarLaboratorio(View v){
        String regEliminadas;
        Laboratorio laboratorio=new Laboratorio();
        laboratorio.setCodLaboratorio(editCodLaboratorio.getText().toString());
        laboratorio.setIdTipoComputo(Integer.valueOf(editTipoComputo.getText().toString()));
        laboratorio.setPlantaLaboratorio(Integer.valueOf(editPlantaLaboratorio.getText().toString()));
        laboratorio.setCantidadEquiposLaboratorio(Integer.valueOf(editCantidadEquiposLaboratorio.getText().toString()));
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(laboratorio);
        Toast.makeText(this, regEliminadas,Toast.LENGTH_SHORT).show();
    }
    public void limpiar(View v){
        editCodLaboratorio.setText("");
        editTipoComputo.setText("");
        editPlantaLaboratorio.setText("");
        editCantidadEquiposLaboratorio.setText("");
    }
}
