import Algoritmos.Sorting;
import Datos.Articulo;
import Datos.BuscaDatos;

import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        //Dependencia que se inyecta a los metodos
        Sorting sorting = new Sorting<Integer>();

        ordenarPorQuicksort(arreglo.clone(),sorting);
        ordenarPorSelect(arreglo.clone(),sorting);
        ordenarPorInsercion( arreglo.clone(), sorting);
        ordenarPorMerge(arreglo.clone(),sorting);
        //Se transforma de un arreglo de Integers a arreglo de ints
        ordenarPorCounting(Arrays.stream(arreglo.clone()).mapToInt(i -> i.intValue()).toArray(), sorting);
    }

    private static void ordenarPorQuicksort(Comparable[] arreglo,Sorting sorting){
        Long tiempoInicial, tiempoFinal;
        System.out.println(Arrays.toString(arreglo));
        System.out.println("-----------------");
        tiempoInicial = new Date().getTime();
        sorting.ordenaPorQuickSort(arreglo);
        tiempoFinal = new Date().getTime();
        System.out.println(Arrays.toString(arreglo));
        System.out.println("Quicksort Tiempo en milisegundos: "+ (tiempoFinal-tiempoInicial));
    }

    private static void ordenarPorSelect(Comparable[] arreglo,Sorting sorting){
        Long tiempoInicial, tiempoFinal;
        System.out.println("\n\n\n");
        System.out.println(Arrays.toString(arreglo));
        System.out.println("-----------------");
        tiempoInicial = new Date().getTime();
        sorting.ordenarPorSeleccion(arreglo);
        tiempoFinal = new Date().getTime();
        System.out.println(Arrays.toString(arreglo));
        System.out.println("Selectsort Tiempo en milisegundos: "+ (tiempoFinal-tiempoInicial));
    }

    private static void ordenarPorInsercion(Comparable[] arreglo,Sorting sorting){
        Long tiempoInicial, tiempoFinal;
        System.out.println("\n\n\n");
        System.out.println(Arrays.toString(arreglo));
        System.out.println("-----------------");
        tiempoInicial = new Date().getTime();
        sorting.ordenarPorInsercion(arreglo);
        tiempoFinal = new Date().getTime();
        System.out.println(Arrays.toString(arreglo));
        System.out.println("Insercion Tiempo en milisegundos: "+ (tiempoFinal-tiempoInicial));
    }


    private static void ordenarPorMerge(Comparable[] arreglo, Sorting sorting){
        Long tiempoInicial, tiempoFinal;
        System.out.println("\n\n\n");
        System.out.println(Arrays.toString(arreglo));
        System.out.println("-----------------");
        tiempoInicial = new Date().getTime();
        sorting.ordenarPorMergeSort(arreglo);
        tiempoFinal = new Date().getTime();
        System.out.println(Arrays.toString(arreglo));
        System.out.println("MergeSort Tiempo en milisegundos: "+ (tiempoFinal-tiempoInicial));
    }


    private static void ordenarPorCounting(int[] arreglo,Sorting sorting){
        Long tiempoInicial, tiempoFinal;
        System.out.println("\n\n\n");
        System.out.println(Arrays.toString(arreglo));
        System.out.println("-----------------");
        tiempoInicial = new Date().getTime();
        sorting.ordenarPorCountingSort(arreglo);
        tiempoFinal = new Date().getTime();
        System.out.println(Arrays.toString(arreglo));
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