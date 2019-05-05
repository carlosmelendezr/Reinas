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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_main);
        // Get the application context
        mContext = getApplicationContext();

        // Get the Resources
        mResources = getResources();

        mImageView = (ImageView) findViewById(R.id.tablero);
        Button mButton = (Button) findViewById(R.id.iniciar);

        ProblemaReinas p = new ProblemaReinas();
        tab = p.BuscarSolucion();

        DibujarTablero dib = new DibujarTablero(tab);
        bit = dib.Dibujar();


       // setContentView(new DibujarTablero(this,tab));


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mImageView.setImageBitmap(bit);
            }
        });
    }
}
