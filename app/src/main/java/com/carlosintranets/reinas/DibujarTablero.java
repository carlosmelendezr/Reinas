package com.carlosintranets.reinas;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;


public class DibujarTablero  {
    private ShapeDrawable mDrawable;
    private ShapeDrawable mMarco;
    private Tablero tablero;
    private Context contexto;
    private int with;
    private int height;


    public DibujarTablero( Context context,Tablero tab) {
        contexto=context;

        this.tablero=tab;
        //setFocusable(true);
        this.mDrawable = new ShapeDrawable(new RectShape());
        this.mDrawable.getPaint().setColor(Color.BLACK);
        this.mMarco = new ShapeDrawable(new RectShape());
        this.mMarco.getPaint().setColor(Color.BLACK);
        this.mMarco.getPaint().setStrokeWidth(5);
    }



    public Bitmap Dibujar(){
        DisplayMetrics d = new DisplayMetrics();
        ((Activity)contexto).getWindowManager().getDefaultDisplay().getMetrics(d);
        with=  (d.widthPixels/4);
        height=  with; //d.heightPixels/2;

        if(with<1 || height<1) return null;

        int boxW = with/9;
        int boxH = with/9;

        Bitmap bitmap = Bitmap.createBitmap(
                boxW*8+9 , // Width
                boxW*8+9 , // Height
                Bitmap.Config.ARGB_8888 // Config
        );

        Canvas canvas = new Canvas(bitmap);
        int y = 1;

        this.mDrawable.setBounds(0, 0, boxW*8+9 , boxW*8+9 );
        this.mDrawable.draw(canvas);


        int inicia ;
        for(int j=0;j<8;j++) {
            int x = 1;

            if (j%2==0) {
                inicia = 0;
            } else {
                inicia = 1;
            }

            for (int i = 0; i < 8; i++) {
                if (inicia==0) {
                    this.mDrawable.getPaint().setColor(Color.BLACK);
                    inicia=1;
                } else {
                    this.mDrawable.getPaint().setColor(Color.WHITE);
                    inicia=0;
                }
                if (tablero.getCeldaEstado(j,i)==Tablero.CELDA_OCUPADA)
                    this.mDrawable.getPaint().setColor(Color.DKGRAY);

                if (tablero.getCeldaEstado(j,i)==Tablero.CELDA_REINA)
                    this.mDrawable.getPaint().setColor(Color.RED);

                this.mDrawable.setBounds(x, y, x + boxW, y + boxH);
                this.mDrawable.draw(canvas);
                x += boxW + 1;

            }
            y+= boxH+1;

        }
     return bitmap;
    }
}
