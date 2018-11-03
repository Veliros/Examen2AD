package com.example.marta.act2ad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.marta.act2ad.ConexionesBD.MyDBAdapter;

/**
 * Ejercicio B de la actividad.
 */
public class EjercicioB extends AppCompatActivity {

    private MyDBAdapter dbAdap;
    private EditText id, curso, cursoP, edad, nom, ciclo, media, despacho;


    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio_b);

        id = (EditText) findViewById(R.id.id);
        curso = (EditText) findViewById(R.id.cursoEst);
        cursoP = (EditText) findViewById(R.id.cursTutor);
        edad = (EditText) findViewById(R.id.edad);
        nom = (EditText) findViewById(R.id.nombre);
        ciclo = (EditText) findViewById(R.id.ciclo);
        media = (EditText) findViewById(R.id.mediaEst);
        despacho = (EditText) findViewById(R.id.despachoProf);

        final Button genEst = (Button) findViewById(R.id.genEst);

        genEst.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String estNom = nom.getText().toString();
                String estEdad = edad.getText().toString();
                String estCiclo = ciclo.getText().toString();
                String estCurso = curso.getText().toString();
                String estMedia = media.getText().toString();

                dbAdap = new MyDBAdapter(v.getContext());
                dbAdap.open();

                dbAdap.insertarEstudiante(estNom, estEdad, estCiclo, estCurso, estMedia);
            }
        });

        final Button genProf = (Button) findViewById(R.id.genProf);

        genProf.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String profNom = nom.getText().toString();
                String profEdad = edad.getText().toString();
                String profCiclo = ciclo.getText().toString();
                String profCurso = cursoP.getText().toString();
                String profDesp = despacho.getText().toString();

                dbAdap = new MyDBAdapter(v.getContext());
                dbAdap.open();

                dbAdap.insertarProfesor(profNom, profEdad, profCiclo, profCurso, profDesp);
            }
        });

    }
}
