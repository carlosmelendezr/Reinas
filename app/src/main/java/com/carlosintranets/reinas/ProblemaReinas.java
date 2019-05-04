package com.carlosintranets.reinas;

import android.util.Log;

import java.util.Random;

public class ProblemaReinas {
    public Tablero tablero;
    public int tamano = 8;
    public int reinas;
    public Random r = new Random();

    ProblemaReinas() {

    }

    public void reiniciarJuego() {
        tablero=new Tablero();

        int x = r.nextInt(tamano);
        int y = r.nextInt( tamano );
        this.reinas=8;
        tablero.setCeldaEstado(Tablero.CELDA_REINA,x,y);
        //Log.i("Reinas ","Reina :"+reinas+" ubicada en x="+x+",y="+y);
        reinas--;

    }

    public Tablero BuscarSolucion() {
        Log.i("Reinas","Iniciando juego");
        int x;
        int y;
        reiniciarJuego();
        int iteracion=0;
        Log.i("Reinas ","Falta por ubicar "+reinas);
        while(reinas > 0  && iteracion<10000){
            x = r.nextInt( tamano);
            y = r.nextInt( tamano );
            Celda celda = tablero.proximaDisponible();
            //x=celda.getX();
            //y=celda.getY();
            //Log.i("Reinas ","Proxima celda disponible ubicada en x="+x+",y="+y);


                if (tablero.setCeldaEstado(Tablero.CELDA_REINA, x, y)) {
                    //Log.i("Reinas ", "Reina :" + reinas + " ubicada en x=" + x + ",y=" + y);
                    reinas--;
                }


                if ( tablero.getCeldasDisponibles()==0) {
                    Log.i("Reinas","Reiniciando tablero,iteracion="+iteracion+", Reinas unicadas:"+reinas);
                    reiniciarJuego();
                }


            iteracion++;
        }
        if (reinas==0) Log.i("Reinas","Solucion encontrada!!");
        return tablero;
    }


}
