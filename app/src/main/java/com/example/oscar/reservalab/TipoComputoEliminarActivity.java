package com.example.oscar.reservalab;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class TipoComputoEliminarActivity extends Activity {
    EditText editIdTipoComputo;
    ControlBDReservacionLab controlhelper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_computo_eliminar);
        controlhelper=new ControlBDReservacionLab (this);
        editIdTipoComputo=(EditText)findViewById(R.id.editIdTipoComputo);
    }
    public void eliminarTipoComputo(View v){
        String regEliminadas;
        TipoComputo tipoComputo=new TipoComputo();
        tipoComputo.setIdTipoComputo(Integer.valueOf(editIdTipoComputo.getText().toString()));
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(tipoComputo);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}
