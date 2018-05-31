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
    }
    public void eliminarLaboratorio(View v){
        String regEliminadas;
        Laboratorio laboratorio=new Laboratorio();
        laboratorio.setCodLaboratorio(editCodLaboratorio.getText().toString());

        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(laboratorio);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas,Toast.LENGTH_SHORT).show();
    }
    public void limpiar(View v){
        editCodLaboratorio.setText("");
        editTipoComputo.setText("");
        editPlantaLaboratorio.setText("");
        editCantidadEquiposLaboratorio.setText("");
    }
}
