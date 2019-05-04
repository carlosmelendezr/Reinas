package com.carlosintranets.reinas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.view.View;

public class DibujarTablero extends View {
    private ShapeDrawable mDrawable;
    private ShapeDrawable mMarco;
    private Tablero tablero;

    public DibujarTablero(Context context, Tablero tab) {
        super(context);
        this.tablero=tab;
        setFocusable(true);
        this.mDrawable = new ShapeDrawable(new RectShape());
        this.mDrawable.getPaint().setColor(Color.BLACK);
        this.mMarco = new ShapeDrawable(new RectShape());
        this.mMarco.getPaint().setColor(Color.BLACK);
        this.mMarco.getPaint().setStrokeWidth(5);
    }
    @Override
    protected void onDraw(Canvas canvas){

        int y = 15;
        int with = 160;
        int height = 160;
        this.mDrawable.setBounds(5, 5, with*8 + 8*8, height*8 + 8*8);
        this.mDrawable.draw(canvas);


        int inicia ;
        for(int j=0;j<8;j++) {
            int x = 15;

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

                this.mDrawable.setBounds(x, y, x + with, y + height);
                this.mDrawable.draw(canvas);
                x += with + 5;

            }
            y+= height+5;

        }

    }
}
