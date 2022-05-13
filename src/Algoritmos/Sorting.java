package Algoritmos;

import Datos.BuscaDatos;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class Sorting <T extends Comparable>{

    public void ordenaPorQuickSort(T[] arreglo){
        quickSort(arreglo,0,arreglo.length-1);
    }

    public void ordenarPorInsercion(T[] arreglo){
        for(int i = 1; i< arreglo.length; ++i){
            T x = arreglo[i];
            int j = i;
            while(j > 0 && arreglo[j-1].compareTo(x) > 0){
                arreglo[j] = arreglo[j-1];
                --j;
            }
            arreglo[j] = x;
        }
    }

    public void ordenarPorSeleccion(T[] arreglo){
        for(int i = 0; i< arreglo.length-1; i++){
            for(int j = i+1; j< arreglo.length; j++){
                if(arreglo[j].compareTo(arreglo[i])<0){
                    T tmp = arreglo[j];
                    arreglo[j] = arreglo[i];
                    arreglo[i] = tmp;
                }
            }
        }
    }

    public void ordenarPorMergeSort(T[] arreglo){
        mergeSort(arreglo,0,arreglo.length-1);
    }

    public void ordenarPorCountingSort(int[] arr){
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int range = max - min + 1;
        int count[] = new int[range];
        int output[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }

    private void mergeSort(T[] arreglo, int left, int right){
        if(left<right){
            int mid = (left + right)/2;
            mergeSort(arreglo,left,mid);
            mergeSort(arreglo,mid+1,right);
            merge(arreglo,left,mid,right);
        }
    }

    private void merge(T[] arreglo, int left, int mid, int right){
        int n = right - left + 1;
        T[] aux = (T[]) Array.newInstance(arreglo[0].getClass(),n);
        int i= left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right){
            if(arreglo[i].compareTo(arreglo[j]) <= 0){          //Se cambia por ">=" para ordenar en la inversa
                aux[k] = arreglo[i]; i++;
            }else{
                aux[k] = arreglo[j];
                j++;
            }
            k++;
        }
        while(i<= mid){
            aux[k] = arreglo[i];
            k++;
            i++;
        }
        while(j<= right){
            aux[k] = arreglo[j];
            k++;
            j++;
        }
        for(k=0; k<n; ++k){
            arreglo[left+k] = aux[k];
        }
    }

    private void quickSort(T[] arreglo,int inicio, int valorFinal ){
        if(inicio <= valorFinal){
            int q = particion(arreglo,inicio,valorFinal);
            quickSort(arreglo,inicio,q-1);
            quickSort(arreglo,q+1,valorFinal);
        }
    }

    private int particion(T[] arreglo, int inicio, int valorFinal){
        T x = arreglo[valorFinal];
        int i = inicio - 1;
        for(int j = inicio; j<= valorFinal -1 ; j++){
            if(arreglo[j].compareTo(x) <= 0){
                i++;
                T save = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = save;
            }
        }
        T save = arreglo[i+1];
        arreglo[i+1] = arreglo[valorFinal];
        arreglo[valorFinal] = save;

        return i+1;
    }

}
