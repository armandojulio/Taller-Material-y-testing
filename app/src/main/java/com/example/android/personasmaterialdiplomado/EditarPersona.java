package com.example.android.personasmaterialdiplomado;

import android.content.Intent;
import android.content.res.Resources;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class EditarPersona extends AppCompatActivity {
    private Persona p;
    private EditText ced, nomb, apell;
    private String cedula, nombre, apellido;
    private Spinner sex;
    private String[] opc;
    private Resources res;
    private Bundle bundle;
    private Intent i;
    private int sexo;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_persona);

        res = this.getResources();
        i = getIntent();
        bundle = i.getBundleExtra("datos");

        ced =(EditText) findViewById(R.id.etxtCedula);
        nomb = (EditText)findViewById(R.id.etxtNombre);
        apell = (EditText)findViewById(R.id.etxtApellido);
        sex = (Spinner)findViewById(R.id.ecmbSexo);


        cedula = bundle.getString("cedula");
        nombre = bundle.getString("nombre");
        apellido = bundle.getString("apellido");
        //sexo = bundle.getInt("sexo");
        opc = res.getStringArray(R.array.sexo);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opc);
        sex.setAdapter(adapter);

        p = new Persona(bundle.getInt("foto"),bundle.getString("cedula"),
                bundle.getString("nombre"), bundle.getString("apellido"),
                bundle.getInt("sexo"));

        ced.setText(cedula);
        nomb.setText(nombre);
        apell.setText(apellido);
        sex.setSelection(sexo);

        reiniciar();

    }

    private void reiniciar(){
        ced.setText(p.getCedula());
        nomb.setText(p.getNombre());
        apell.setText(p.getApellido());
        sex.setSelection(p.getSexo());
        ced.requestFocus();
    }
    public void reiniciar(View v){
        reiniciar();
    }


    public void editar (View v){
        int pos = Metodos.obtenerPosicion(Datos.obtenerPersonas(), p);
        Persona personaEditada = new Persona(p.getFoto(), ced.getText().toString(),
                nomb.getText().toString(), apell.getText().toString(), sex.getSelectedItemPosition());
        if (Metodos.comparar(p, personaEditada) == false){
            if (p.getCedula().equals(personaEditada.getCedula())){
                if (validar2()){
                    Datos.editarPersona(pos, personaEditada);
                    p = personaEditada;
                    onBackPressed();
                }
            }else{
                if(validar()) {
                    Datos.editarPersona(pos, personaEditada);
                    p = personaEditada;
                    onBackPressed();
                }
            }
        }else{
            Snackbar.make(v, res.getString(R.string.mensaje_guardado), Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            onBackPressed();
        }

    }

    public boolean validar(){
        if (validarVacio(ced)) return false;
        else  if (validarVacio(nomb)) return false;
        else  if (validarVacio(apell)) return false;
        else if (Metodos.exitePersona(Datos.obtenerPersonas(),ced.getText().toString())){
            ced.setError(res.getString(R.string.persona_existente_error));
            ced.requestFocus();
            return false;
        }
        return true;
    }

    public boolean validar2(){
        if (validarVacio(ced)) return false;
        else  if (validarVacio(nomb)) return false;
        else  if (validarVacio(apell)) return false;
        return true;
    }

    public boolean validarVacio(TextView t) {
        if (t.getText().toString().isEmpty()) {
            t.requestFocus();
            t.setError(res.getString(R.string.no_vacio_error));
            return true;
        }
        return false;
    }

    public void onBackPressed(){
        finish();
        Intent i = new Intent(EditarPersona.this, DetallePersona.class);
        Bundle b = new Bundle();
        b.putString("cedula",p.getCedula());
        b.putString("nombre",p.getNombre());
        b.putString("apellido",p.getApellido());
        b.putInt("sexo",p.getSexo());
        b.putInt("foto",p.getFoto());

        i.putExtra("datos",b);
        startActivity(i);
    }


}
