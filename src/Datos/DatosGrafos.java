package Datos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DatosGrafos extends BuscaDatos{

    /*
     *  Usando el siguiente grafo
     *
     *       02 21 23 13 24
     *   0 | 1  0  0  0  0 |
     *   1 | 0  1  0  1  0 |
     *   2 | 1  1  1  0  1 |
     *   3 | 0  0  1  1  0 |
     *   4 | 0  0  0  0  1 |
     *
     * */
    public List<List<Integer>> getGrafo(){
        int n = 5; // vertices
        int m; // aristas
        List<List<Integer>> grafo = new ArrayList<>(n);

        grafo.add(0, Arrays.asList(new Integer[]{2}) );
        grafo.add(1,Arrays.asList(new Integer[]{2,3}));
        grafo.add(2,Arrays.asList(new Integer[]{0,1,3,4}));
        grafo.add(3,Arrays.asList(new Integer[]{1,2}));
        grafo.add(4,Arrays.asList(new Integer[]{2}));

        return grafo;
    }

    public List<List<Integer>> getGrafo2(){
        int n = 5; // vertices
        int m; // aristas
        List<List<Integer>> grafo = new ArrayList<>(n);

        grafo.add(0, Arrays.asList(new Integer[]{5,4}) );
        grafo.add(1,Arrays.asList(new Integer[]{3}));
        grafo.add(2,Arrays.asList(new Integer[]{5}));
        grafo.add(3,Arrays.asList(new Integer[]{1,5}));
        grafo.add(4,Arrays.asList(new Integer[]{1,6}));
        grafo.add(5,Arrays.asList(new Integer[]{3,2,0}));
        grafo.add(6,Arrays.asList(new Integer[]{4}));

        return grafo;
    }

    public List<List<String>> getGrafoMapa1(){
        Stream<String> lineas = getLines("./resources/archivos/Mapa1.txt");
        List<List<String>>mapa = lineas.map(s -> {
            System.out.println(s);
            return Arrays.asList(s.split(""));
        }).collect(Collectors.toList());

        return mapa;
    }

    public List<List<String>> getGrafoMapa2(){
        Stream<String> lineas = getLines("./resources/archivos/Mapa2.txt");
        List<List<String>>mapa = lineas.map(s -> {
            System.out.println(s);
            return Arrays.asList(s.split(""));
        }).collect(Collectors.toList());

        return mapa;
    }
}
