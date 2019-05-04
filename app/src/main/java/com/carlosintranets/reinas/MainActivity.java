package com.carlosintranets.reinas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Tablero tab = new Tablero();
        ((Tablero) tab).setCeldaEstado(Tablero.CELDA_REINA,3,3);
        setContentView(new DibujarTablero(this,tab));
    }
}
