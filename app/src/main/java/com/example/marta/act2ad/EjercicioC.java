package com.example.marta.act2ad;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.marta.act2ad.ConexionesBD.MyDBAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class EjercicioC extends Activity {

    private MyDBAdapter dbAdapter;
    private StringBuilder sb = new StringBuilder();
    private ArrayList<String> estudiantes, profesores;
    private Iterator<String> it;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio_c);

        final Button btnEst = (Button) findViewById(R.id.btnTdsEst);
        final Button btnPrf = (Button) findViewById(R.id.btnTdsProf);
        final Button btnTds = (Button) findViewById(R.id.btnTodos);
        final Button btnCurso = (Button) findViewById(R.id.btnCic);
        final Button btnCic = (Button)  findViewById(R.id.btnCic);

        dbAdapter = new MyDBAdapter(this);
        dbAdapter.open();

        btnEst.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView est = (TextView) findViewById(R.id.resultBDEst);
                est.setText(null);

                estudiantes = dbAdapter.recuperarEst();
                it = estudiantes.iterator();

                while(it.hasNext()){
                    sb.append(it.next() + "\n");
                }

                est.setText(sb);
            }
        });

        btnPrf.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView prof = (TextView) findViewById(R.id.resultBDProf);
                prof.setText(null);

                profesores = dbAdapter.recuperarProf();
                it = profesores.iterator();

                while(it.hasNext()){
                    sb.append(it.next() + "\n");
                }
                prof.setText(sb);

            }
        });

        btnTds.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView est = (TextView) findViewById(R.id.resultBDEst);
                TextView prof = (TextView) findViewById(R.id.resultBDProf);
                est.setText(null);
                prof.setText(null);

                estudiantes = dbAdapter.recuperarEst();
                profesores = dbAdapter.recuperarProf();

                it = estudiantes.iterator();

                while(it.hasNext()){
                    sb.append(it.next() + "\n");
                }
                est.setText(sb);
                //Borramos contenido de stringbuilder:
                sb.setLength(0);
                it = profesores.iterator();

                while(it.hasNext()){
                    sb.append(it.next() + "\n");
                }
                prof.setText(sb);

            }
        });

        btnCurso.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView est = (TextView) findViewById(R.id.resultBDEst);
                est.setText(null);

                ArrayList<String> estCurs = dbAdapter.recuperarCurso();
                Iterator<String> cursos = estCurs.iterator();

                while(cursos.hasNext()){
                    sb.append(cursos.next() + "\n");
                }
                est.setText(sb);

            }
        });

        btnCic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView est = (TextView) findViewById(R.id.resultBDEst);
                est.setText(null);
                
                ArrayList<String> estCurs = dbAdapter.recuperarCurso();
                Iterator<String> cursos = estCurs.iterator();

                while(cursos.hasNext()){
                    sb.append(cursos.next() + "\n");
                }
                est.setText(sb);

            }
        });

    }
}
