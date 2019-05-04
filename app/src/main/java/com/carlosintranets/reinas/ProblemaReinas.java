package com.carlosintranets.reinas;

import java.util.Random;

public class ProblemaReinas {
    public Tablero tablero;
    public int tamano = 8;

    ProblemaReinas() {
        tablero=new Tablero();
    }

    public Tablero BuscarSolucion() {
        Random r = new Random();
        int x = r.nextInt(tamano-1);
        int y = r.nextInt( tamano -1);
        return tablero;
    }


}
