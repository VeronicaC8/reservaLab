package com.example.oscar.reservalab;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UsuarioConsultarActivity extends Activity {

    ControlBDReservacionLab helper;
    EditText editIdUsuario;
    EditText editUsuario;
    EditText editcontrasena;
    EditText editTipoUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_consultar);
        helper = new ControlBDReservacionLab(this);

        editIdUsuario = (EditText) findViewById(R.id.editIdUsuario);
        editUsuario = (EditText) findViewById(R.id.editUsuario);
        editcontrasena = (EditText) findViewById(R.id.editcontrasena);
        editTipoUsuario = (EditText) findViewById(R.id.editTipoUsu);
    }

    public void consultarUsuario(View v) {
        helper.abrir();
        Usuario usuario = helper.consultarUsuario(editIdUsuario.getText().toString());
        helper.cerrar();
        if(usuario == null)
            Toast.makeText(this, "Usuario con id " + editIdUsuario.getText().toString() + " no encontrado", Toast.LENGTH_LONG).show();
        else{
            editUsuario.setText(usuario.getUsuario());
            editcontrasena.setText(usuario.getContrasenia());
            editTipoUsuario.setText(String.valueOf(usuario.getIdaccesoUsuario()));

        }
    }
    public void limpiarTexto(View v){
        editIdUsuario.setText("");
        editUsuario.setText("");
        editcontrasena.setText("");
        editTipoUsuario.setText("");
    }
}

