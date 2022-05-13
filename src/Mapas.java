import Datos.Articulo;
import Datos.BuscaDatos;

import java.util.*;

public class Mapas {

    public static void main(String[] args) {

        BuscaDatos buscaDatos = new BuscaDatos();
        //Map<String,Integer> alumnoNota = new HashMap<>(); //Se basa en los metodos Hash para insertar
                                                            // Mayor tamaño en memoria, mas rapido a mayor cantidad de datos
                                                            //Permite valores nulos
        //Map<String,Integer> alumnoNota = new TreeMap<>(); //Se basa en un arbor Rojo-Negro, usa metodo toString para insertarlo de forma ordenada
                                                             //Menor tamaño de memoria para los datos, lento para insertar por el ordenamiento
                                                            //No permite valores nulos, NullPointerException
        //Map<String,Integer> alumnoNota = new Hashtable<>();
        Map<String,Integer> alumnoNota = new LinkedHashMap<>();
        alumnoNota.put("Bruno",10);
        alumnoNota.put("Juan", 9);
        alumnoNota.put("Fernanda",10);
        alumnoNota.put("Karen",8);

        for (Map.Entry entry: alumnoNota.entrySet()){
            System.out.println("El alumno "+ entry.getKey()+ " Tiene calificacion "+ entry.getValue());
        }

        List<Articulo> listaArt = buscaDatos.getArticulosList();
        for(Articulo art : listaArt){
            System.out.println(art.getNombre());
        }

        for(String nombre : buscaDatos.getNombres()){
            System.out.println(nombre);
        }

    }
}