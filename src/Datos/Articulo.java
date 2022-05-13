package Datos;

import java.math.BigDecimal;
import java.util.Objects;

public class Articulo implements Comparable {
    private Integer id;
    private String nombre;
    private BigDecimal precio;
    private Integer cantidad;

    public Articulo(String[] linea){
        this.id = Integer.parseInt(linea[0]);
        this.nombre = linea[1];
        this.precio = new BigDecimal(linea[2]);
        this.cantidad = Integer.parseInt(linea[3]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Articulo articulo = (Articulo) o;
        return Objects.equals(id, articulo.id) && Objects.equals(nombre, articulo.nombre) && Objects.equals(precio, articulo.precio) && Objects.equals(cantidad, articulo.cantidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, precio, cantidad);
    }

    @Override
    public int compareTo(Object o) {
        return this.precio.compareTo(((Articulo)o).getPrecio());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}