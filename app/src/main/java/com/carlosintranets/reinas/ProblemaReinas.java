package com.carlosintranets.reinas;

import android.util.Log;

import java.util.Random;

public class ProblemaReinas {
    public Tablero tablero;
    public int tamano = 8;
    public int reinas;
    public int fila;
    public int col;
    public boolean solucion;
    public Random r = new Random();

    ProblemaReinas() {

    }

    public void reiniciarJuego() {
        tablero=new Tablero();
        solucion=false;

        int fila = r.nextInt(tamano);
        col = 0;
        //int y = r.nextInt( tamano );
        this.reinas=8;
        tablero.setCeldaEstado(Tablero.CELDA_REINA,fila,col);
        //Log.i("Reinas ","Reina :"+reinas+" ubicada en x="+x+",y="+y);
        reinas--;
        col++;

    }

    public Tablero BuscarSolucion() {
        Log.i("Reinas","Iniciando juego");

        reiniciarJuego();
        int iteracion=0;
        Log.i("Reinas ","Falta por ubicar "+reinas);
        while(reinas > 0  && iteracion<10000){
            fila = r.nextInt( tamano);

                if (tablero.setCeldaEstado(Tablero.CELDA_REINA, fila, col)) {
                    //Log.i("Reinas ", "Reina :" + reinas + " ubicada en x=" + x + ",y=" + y);
                    col++;
                    reinas--;
                    Log.i("Reinas ","col="+col+",reinas="+reinas);
                }


                if ( col>tamano) {
                    Log.i("Reinas","Reiniciando tablero,iteracion="+iteracion+", Reinas unicadas:"+reinas);
                    reiniciarJuego();
                }


            iteracion++;
        }
        if (reinas==0){
            Log.i("Reinas","Solucion encontrada!!");
            solucion=true;
        }
            else {Log.i("Reinas","Juego terminado sin solucion="+iteracion+"," +
                " Reinas faltantes:"+reinas+"Celdas disponibles:"+tablero.getCeldasDisponibles());}
        return tablero;
    }


}
