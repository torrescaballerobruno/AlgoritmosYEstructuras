import Algoritmos.Sorting;
import Datos.Articulo;
import Datos.BuscaDatos;

import java.util.Arrays;
import java.util.Date;

public class QuickSortTest {

    public static void main(String[] args) {
        BuscaDatos buscaDatos = new BuscaDatos();
        Long tiempoInicial, tiempoFinal;

        tiempoInicial = new Date().getTime();
        //ordenaArregloInts(buscaDatos.getRandomIntegers(1000,500));
        ordenaArregloArticulos(buscaDatos.getArticulosList().toArray(new Articulo[0]));
        tiempoFinal = new Date().getTime();
        System.out.println("Tiempo en milisegundos: "+ (tiempoFinal-tiempoInicial));

        ordenarArregloNumeros(buscaDatos.getRandomIntegers(10000,500));
    }

    public static void ordenarArregloNumeros(Integer[] arreglo){
        Integer[] arregloCopy = arreglo.clone();
        Integer[] arregloCopy2 = arreglo.clone();
        Integer[] arregloCopy3 = arreglo.clone();
        int[] arregloCopy4 = new int[arreglo.length];
        int j = 0;
        for(Integer i : arreglo){
            arregloCopy4[j++] = i.intValue();
        }
        Sorting sorting = new Sorting<Integer>();
        Long tiempoInicial, tiempoFinal;


        System.out.println(Arrays.toString(arreglo));
        System.out.println("-----------------");
        tiempoInicial = new Date().getTime();
        sorting.ordenaPorQuickSort(arreglo);
        tiempoFinal = new Date().getTime();
        System.out.println(Arrays.toString(arreglo));
        System.out.println("Quicksort Tiempo en milisegundos: "+ (tiempoFinal-tiempoInicial));

        System.out.println("\n\n\n");

        System.out.println(Arrays.toString(arregloCopy));
        System.out.println("-----------------");
        tiempoInicial = new Date().getTime();
        sorting.ordenarPorSeleccion(arregloCopy);
        tiempoFinal = new Date().getTime();
        System.out.println(Arrays.toString(arregloCopy));
        System.out.println("Selectsort Tiempo en milisegundos: "+ (tiempoFinal-tiempoInicial));

        System.out.println("\n\n\n");

        System.out.println(Arrays.toString(arregloCopy2));
        System.out.println("-----------------");
        tiempoInicial = new Date().getTime();
        sorting.ordenarPorInsercion(arregloCopy2);
        tiempoFinal = new Date().getTime();
        System.out.println(Arrays.toString(arregloCopy2));
        System.out.println("Insercion Tiempo en milisegundos: "+ (tiempoFinal-tiempoInicial));

        System.out.println("\n\n\n");

        System.out.println(Arrays.toString(arregloCopy3));
        System.out.println("-----------------");
        tiempoInicial = new Date().getTime();
        sorting.ordenarPorMergeSort(arregloCopy3);
        tiempoFinal = new Date().getTime();
        System.out.println(Arrays.toString(arregloCopy3));
        System.out.println("MergeSort Tiempo en milisegundos: "+ (tiempoFinal-tiempoInicial));

        System.out.println("\n\n\n");

        System.out.println(Arrays.toString(arregloCopy4));
        System.out.println("-----------------");
        tiempoInicial = new Date().getTime();
        sorting.ordenarPorCountingSort(arregloCopy4);
        tiempoFinal = new Date().getTime();
        System.out.println(Arrays.toString(arregloCopy4));
        System.out.println("CountingSort Tiempo en milisegundos: "+ (tiempoFinal-tiempoInicial));
    }
    public static void ordenaArregloArticulos(Articulo[] articulos){
        Sorting sorting = new Sorting<Articulo>();
        for(Articulo a : articulos){
            System.out.println("Precio:  "+a.getPrecio().toString()+"  Nombre:  "+a.getNombre());
        }
        System.out.println("-----------------");
        sorting.ordenaPorQuickSort(articulos);
        for(Articulo a : articulos){
            System.out.println("Precio:  "+a.getPrecio().toString()+"  Nombre:  "+a.getNombre());
        }

    }

    public static void ordenaArregloInts(Integer[] arreglo){

        System.out.println(Arrays.toString(arreglo));
        System.out.println("-----------------");
        quickSort(arreglo,0,arreglo.length-1);
        System.out.println(Arrays.toString(arreglo));
    }

    public static void quickSort(Integer[] arreglo,int inicio, int valorFinal ){
        if(inicio <= valorFinal){
            int q = particion(arreglo,inicio,valorFinal);
            quickSort(arreglo,inicio,q-1);
            quickSort(arreglo,q+1,valorFinal);
        }
    }

    public static int particion(Integer[] arreglo, int inicio, int valorFinal){
        int x = arreglo[valorFinal];
        int i = inicio - 1;
        for(int j = inicio; j<= valorFinal -1 ; j++){
            if(arreglo[j] <= x){
                i++;
                int save = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = save;
            }
        }
        int save = arreglo[i+1];
        arreglo[i+1] = arreglo[valorFinal];
        arreglo[valorFinal] = save;

        return i+1;
    }

}