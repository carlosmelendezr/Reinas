package com.carlosintranets.reinas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Tablero tab;
        ProblemaReinas p = new ProblemaReinas();

        tab = p.BuscarSolucion();

        setContentView(new DibujarTablero(this,tab));
    }
}
