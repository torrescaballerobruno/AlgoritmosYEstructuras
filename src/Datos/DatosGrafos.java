package Datos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DatosGrafos {

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
}
