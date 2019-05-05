package com.carlosintranets.reinas;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    private Context mContext;
    private Resources mResources;
    private RelativeLayout mRelativeLayout;
    private Bitmap bit;
    Tablero tab;
    ImageView mImageView;
    ProblemaReinas p;
    int x;
    int y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        // Get the application context
        mContext = getApplicationContext();

        // Get the Resources
        mResources = getResources();

        mImageView = (ImageView) findViewById(R.id.tablero);
        Button mIniciar = (Button) findViewById(R.id.iniciar);
        Button mReIniciar = (Button) findViewById(R.id.reiniciar);



       // setContentView(new DibujarTablero(this,tab));
        x=0;
        y=0;
        p = new ProblemaReinas();

        tab = new Tablero();
        MostrarTablero();
        mIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tab = p.BuscarSolucion();
                /*Celda celda = tab.proximaDisponible();
                x=celda.getX();
                y=celda.getY();
                //Log.i("Reinas ","col="+x+",reinas="+y);

                tab.setCeldaEstado(Tablero.CELDA_REINA,x,y);*/
                MostrarTablero();
                /*DibujarTablero dib = new DibujarTablero(tab);
                bit = dib.Dibujar();

                mImageView.setImageBitmap(bit);*/

            }
        });

        mReIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tab = new Tablero();
                MostrarTablero();
            }
        });



    }

    public void MostrarTablero() {
        DibujarTablero dib = new DibujarTablero(tab);
        bit = dib.Dibujar();

        mImageView.setImageBitmap(bit);

    }
}
