package Algoritmos;

import Datos.DatosGrafos;
import jdk.internal.util.xml.impl.Pair;

import java.util.*;

public class DFS {


    /*
                       1 A
                      /     \
                   2 B       D 8
                   /   \       \
                3 E     F 6     G 9
                 /       \       \
              4 I         C 7     H 10
               /
            5 J

            output: A B E I J F C D G H
     */

    public static void main(String[] args) {
        DFS dfs = new DFS();
        DatosGrafos grafos = new DatosGrafos();
        /*List<Integer> output = dfs.dfsRecursivo(grafos.getGrafo2());

        for (Integer i : output)
            System.out.print(i+" ");*/

        //System.out.println(dfs.resolucionMapaTesoro(grafos.getGrafoMapa1(),4,2));
        //System.out.println(dfs.resolucionMapaTesoro(grafos.getGrafoMapa2(),3,0));

        dfs.twoColors();
    }


    public boolean limitado(List<List<String>> grafo, Integer i, Integer j){
        return i > 0 && j > 0  && grafo.size()>i && grafo.get(0).size()>j ;
    }


    public boolean resolucionMapaTesoro(List<List<String>> grafo, Integer i, Integer j){

        if(grafo.get(i).get(j).equals("t")) return true;
        if(grafo.get(i).get(j).equals("x")) return false;

        Integer adyI,adyJ;
        List<List<Integer>> direcciones = new ArrayList<>();
        direcciones.add(Arrays.asList(0,1));
        direcciones.add(Arrays.asList(0,-1));
        direcciones.add(Arrays.asList(-1,0));
        direcciones.add(Arrays.asList(1,0));


        grafo.get(i).set(j,"x");

        for(List<Integer> d : direcciones){
            adyI = i + d.get(0);
            adyJ = j + d.get(1);

            if(limitado(grafo,adyI,adyJ) && resolucionMapaTesoro(grafo,adyI,adyJ) ){
                return true;
            }

        }

        return false;
    }

    public List<Integer> dfsRecursivo(List<List<Integer>> grafo){
        int n = grafo.size();
        List<Integer> l = new ArrayList<>(n);
        boolean[] vis = new boolean[n];
        for(int i = 0; i<n; i++){
            vis[i]= false;
        }

        for(int u = 0; u<n;++u){
            dfsRecursivo(grafo, u, vis, l);
        }

        return l;
    }

    public void dfsRecursivo(List<List<Integer>> grafo, int u, boolean[] vis, List<Integer> l ){
        if(!vis[u]){
            vis[u] = true;
            l.add(u);
            for(Integer v: grafo.get(u) ){
                dfsRecursivo(grafo,v,vis,l);
            }
        }
    }


    //Problema Two colors
    //Ver si un grado se puede "pintar" de 2 colores sin que la misma arista tenga el mismo color
    public void twoColors(){
        List<List<Integer>> grafo1 = new ArrayList<>(2);
        grafo1.add(0,new ArrayList<>(Arrays.asList(1)));
        grafo1.add(1,new ArrayList<>(Arrays.asList(0)));

        List<List<Integer>> grafo2 = new ArrayList<>(4);
        grafo2.add(0,new ArrayList<>());
        grafo2.add(1,new ArrayList<>(Arrays.asList(2,3)));
        grafo2.add(2,new ArrayList<>(Arrays.asList(1,3)));
        grafo2.add(3,new ArrayList<>(Arrays.asList(1,1)));

        List<List<Integer>> grafo3 = new ArrayList<>(1);
        grafo3.add(0,new ArrayList<>());

        List<List<Integer>> grafo4 = new ArrayList<>(4);
        grafo4.add(0,new ArrayList<>(Arrays.asList(3)));
        grafo4.add(1,new ArrayList<>(Arrays.asList(2)));
        grafo4.add(2,new ArrayList<>(Arrays.asList(1)));
        grafo4.add(3,new ArrayList<>(Arrays.asList(0)));

        System.out.println(dfs(grafo1));
        System.out.println(dfs(grafo2));
        System.out.println(dfs(grafo3));
        System.out.println(dfs(grafo4));

    }

    public boolean dfs(List<List<Integer>> g){
        int n = g.size();
        List<Integer> color = new ArrayList<>(n);

        for(int i = 0; i<n; i++) color.add(i,0);

        for(int i = 0; i < n; ++i){
            if(color.get(i) == 0 && !esDosColoreable(g,color,i,i)) return false;
        }

        return true;
    }

    public boolean esDosColoreable(List<List<Integer>> g, List<Integer> color, Integer u, Integer viejoU){
        if(color.get(u) == 0){
            color.set(u,color.get(viejoU)%2+1); //poner colores distintos a u y viejo u

            for(Integer i : g.get(u)){
                if(!esDosColoreable(g,color,i,u)){
                    return false;
                }
            }
            return true;  //u y todos sus adyacentes son 2-coloreable
        }
        else {
            return color.get(u) != color.get(viejoU);
        }
    }

}