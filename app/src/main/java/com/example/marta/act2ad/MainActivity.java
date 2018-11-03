package com.example.marta.act2ad;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.marta.act2ad.ConexionesBD.ConexionSQLiteHelper;

/**
 * ACTIVIDAD 3a
 * @author marta
 */
public class MainActivity extends Activity {

    public static final String PREFS = "My preferences";

    /**
     * OnCreate
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConexionSQLiteHelper con = new ConexionSQLiteHelper(this, "usuarios",null, 1);

        final Button btnGuardar = (Button) findViewById(R.id.guardar);

        //Pulsar para guardar:
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Crea objeto de preferencias compartidas:
                SharedPreferences mySharedPreferences = getSharedPreferences(PREFS, Activity.MODE_PRIVATE);

                // Editor para modificar preferencias:
                SharedPreferences.Editor editor = mySharedPreferences.edit();

                //Coger datos introducidos por usuarios:
                final EditText edNom = (EditText) findViewById(R.id.nom);
                String sNom = edNom.getText().toString();

                final EditText edUsu = (EditText) findViewById(R.id.nomUsu);
                String sUsu = edUsu.getText().toString();

                final EditText edFechaNac = (EditText) findViewById(R.id.fechaNac);
                String fecha = edFechaNac.getText().toString();

                //Radiobuttons
                final RadioButton h = (RadioButton) findViewById(R.id.hombre);
                final RadioButton m = (RadioButton) findViewById(R.id.mujer);

                String gen = null;

                if(h.isChecked()) gen = "Hombre";
                else if(m.isChecked()) gen = "Mujer";

                // Guardamos nuevos valores
                editor.putString("nombre", sNom);
                editor.putString("nomUsu", sUsu);
                editor.putString("fecha", fecha);
                editor.putString("Género", gen);

                // Guardamos los cambios
                editor.commit();

            }
        });

        final Button btnMostrar = (Button) findViewById(R.id.mostrar);

        //Pulsar recuperar:
        btnMostrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Recuperar el objeto de preferencias:
                SharedPreferences mySharedPreferences = getSharedPreferences(PREFS, Activity.MODE_PRIVATE);

                //Recuperación de valores:
                String nom = mySharedPreferences.getString("nombre","");
                String usuario = mySharedPreferences.getString("nomUsu", "");
                String fech = mySharedPreferences.getString("fecha", "");
                String genero = mySharedPreferences.getString("Género", "");

                Log.d("fecha: ", fech);
                Toast.makeText(MainActivity.this, nom + "\n" + fech + "\n" + genero +
                        "\n" + usuario, Toast.LENGTH_SHORT).show();

            }
        });

        final Button btnEjerB = (Button) findViewById(R.id.btnEjerB);

        btnEjerB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), EjercicioB.class);
                startActivity(i);

            }
        });

    }

    /**
     *
     * @param menu
     * @return true;
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     *
     * @param item
     * @return item
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}