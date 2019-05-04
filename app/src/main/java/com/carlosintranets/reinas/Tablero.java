package com.carlosintranets.reinas;

import java.util.ArrayList;

public class Tablero {
    public static final int CELDA_LIBRE = 0;
    public static final int CELDA_OCUPADA = 1;
    public static final int CELDA_REINA = 2;
    private final String[] letras = {"a","b","c","d","e","f","g","h"};
    private ArrayList<Celda> Celdas;
    private int celdasDisponibles;

    private int[][] Espacio;
    private int tamano;

    public int getCeldasDisponibles() {
        return celdasDisponibles;
    }

    public Tablero() {
        tamano = 8;
        Celdas = new ArrayList();
        Espacio = new int[tamano*tamano-1][tamano*tamano-1];
        celdasDisponibles =tamano*tamano;
        crearCeldas();
        Clear();
    }
    public int getCeldaEstado(int x, int y){
        if (x<0 || x>tamano-1) return 0;
        if (y<0 || y>tamano-1) return 0;
        return Espacio[x][y];
    }
    public boolean setCeldaEstado(int estado,int x, int y){
        if (estado<0 || estado>2) return false;
        if (x<0 || x>tamano-1) return false;
        if (y<0 || y>tamano-1) return false;

        if (Espacio[x][y]==CELDA_LIBRE){
            Espacio[x][y]=estado;
            celdasDisponibles--;
        } else {
            return false;
        }

        apartaVerHor(x,y);
        apartaDiagonal(x,y);
        return true;
    }

    public Celda proximaDisponible(){
        Celda celda = new Celda();
        for(int i=0;i<tamano-1;i++){

            for(int j=0;j<tamano-1;j++){
                if (Espacio[i][j]==CELDA_LIBRE) {
                    celda.setX(i);
                    celda.setY(j);
                }
            }
        }
        return celda;
    }

    public void apartaVerHor(int posx, int posy) {
        for(int y=0;y<tamano;y++){
            if (Espacio[posx][y]==CELDA_LIBRE) {
                Espacio[posx][y] = CELDA_OCUPADA;
                celdasDisponibles--;
            }
        }
        for(int x=0;x<tamano;x++){
            if (Espacio[x][posy]==CELDA_LIBRE) {
                Espacio[x][posy] = CELDA_OCUPADA;
                celdasDisponibles--;
            }
        }

    }

    public void apartaDiagonal(int posx, int posy){
        // Diagonal Superior Izq
        int x=posx-1;
        int y=posy-1;

        while (x>=0 && y>=0) {
            if (Espacio[x][y]==CELDA_LIBRE) {
                Espacio[x][y] = CELDA_OCUPADA;
                celdasDisponibles--;
            }
            x--;
            y--;

        }
        x=posx-1;
        y=posy+1;
        while (x>=0 && y<tamano) {
            if (Espacio[x][y]==CELDA_LIBRE) {
                Espacio[x][y] = CELDA_OCUPADA;
                celdasDisponibles--;
            }
            x--;
            y++;
        }

        x=posx+1;
        y=posy-1;
        while (x<tamano && y>=0) {
            if (Espacio[x][y]==CELDA_LIBRE) {
                Espacio[x][y] = CELDA_OCUPADA;
                celdasDisponibles--;
            }
            x++;
            y--;
        }
        x=posx+1;
        y=posy+1;
        while (x<tamano && y<tamano) {
            if (Espacio[x][y]==CELDA_LIBRE) {
                Espacio[x][y] = CELDA_OCUPADA;
                celdasDisponibles--;
            }
            x++;
            y++;
        }


    }

    public boolean agregarCelda(String Nombre, int x, int y) {

        if (Nombre.isEmpty()) return false;
        if (x<0 || x>tamano-1) return false;
        if (y<0 || y>tamano-1) return false;
        Celda celda = new Celda(Nombre,x,y);
        Celdas.add(celda);
        return true;
    }
    public void crearCeldas() {
        for(int i=0;i<tamano;i++){
            String nom=letras[i];
            for(int j=0;j<tamano;j++){
               agregarCelda("nom"+j,i,j);
            }
        }

    }
    public void Clear() {
        for(int i=0;i<tamano;i++){
            for(int j=0;j<tamano;j++) Espacio[i][j]=CELDA_LIBRE;
        }
    }


}
