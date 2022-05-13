package Datos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BuscaDatos {

    public List<Articulo> getArticulosList() {
        return getLines("./resources/archivos/Articulos.tsv").map(s -> s.split("\t")).map(arr -> new Articulo(arr)).collect(Collectors.toList());
        //Reducimos todo el codigo a una linea con streams y lamdas
        /*File doc = new File("./resources/archivos/Articulos.tsv");
        List<Articulo> articulos = new ArrayList<>();
        try {
            Scanner sc = new Scanner(doc);
            while (sc.hasNextLine()) {
                String[] strs = sc.nextLine().split("\t");
                articulos.add(new Articulo(strs));
            }
        }catch(FileNotFoundException fnfe){
            System.err.println("Error al abirr el archivo: "+fnfe.getMessage());
        }finally {
            return articulos;
        }*/
    }

    public String[] getNombres(){
        return getLines("./resources/archivos/Nombres.txt").collect(Collectors.toList()).toArray(new String[1]);
        //Se reduce todo el codigo a una sola linea al usar Streams
        /*File doc = new File("./resources/archivos/Nombres.txt");
        List<String> articulos = new ArrayList<>();
        try {
            Scanner sc = new Scanner(doc);
            while (sc.hasNextLine()) {
                articulos.add(sc.nextLine());
            }
        }catch(FileNotFoundException fnfe){
            System.err.println("Error al abirr el archivo: "+fnfe.getMessage());
        }finally {
            return articulos.toArray(new String[articulos.size()]);
        }*/
    }

    private Stream<String> getLines(String file){
        Stream<String> stream = new ArrayList<String>().stream();
        try{
            stream = Files.lines(Paths.get(file));
        }catch(IOException ioe){
            System.err.println("Error al leer el archivo: "+ioe.getMessage());
        }
        return stream;
    }

    public Integer[] getRandomIntegers(int cantidad, int limite){
        Integer[] array = new Integer[cantidad];

        for(int i = 0; i<cantidad; i++){
            Random rnd = new Random();
            array[i] = rnd.nextInt(limite);
        }

        return array;
    }

}
