package Algoritmos;

import Datos.DatosGrafos;

import java.util.List;

public class Grafos {
    public static void main(String[] args) {
        new Grafos().doGrafos();
    }

    //Con una matriz de adyacencia, lista de listas, se representa un grafo
    //La primer lista son los vertices, la lista de cada vertice son sun adyacencias
    public void doGrafos(){
        DatosGrafos dg = new DatosGrafos();
        List<List<Integer>> grafo = dg.getGrafo();
        grafo.forEach( x -> {x.forEach( y -> System.out.print(y+",")); System.out.println(""); } );
    }
}
