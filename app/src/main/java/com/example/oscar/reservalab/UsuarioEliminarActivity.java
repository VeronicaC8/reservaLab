package com.example.oscar.reservalab;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UsuarioEliminarActivity extends Activity {

    EditText editId;
    ControlBDReservacionLab controlhelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_eliminar);
        controlhelper=new ControlBDReservacionLab (this);
        editId=(EditText)findViewById(R.id.editUsuario3);
    }

    public void eliminarUsuario(View v){
        String regEliminadas;
        Usuario usuario=new Usuario();
        usuario.setIdUsuario(Integer.parseInt(editId.getText().toString()));

        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(usuario);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }

}
