/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author JManu
 */
public class Producto {

    protected static String ID_Producto;
    protected static String nombre;
    protected static String descripcion;
    protected static double precio_venta;
    protected static int cantidad;
    protected static String estado;
    
    protected static String categoria;

   public Producto() {
        ID_Producto = "";
        nombre = "";
        descripcion = "";
        categoria = "";
        precio_venta = 0.0;
        cantidad = 0;
    }

    public static void setID_Producto(String ID_Producto) {
        Producto.ID_Producto = ID_Producto;
    }

    public static void setNombre(String nombre) {
        Producto.nombre = nombre;
    }

    public static void setDescripcion(String descripcion) {
        Producto.descripcion = descripcion;
    }

    public static void setPrecio_venta(double precio_venta) {
        Producto.precio_venta = precio_venta;
    }

    public static void setCantidad(int cantidad) {
        Producto.cantidad = cantidad;
    }

    public static void setCategoria(String categoria) {
        Producto.categoria = categoria;
    }

    public static void setEstado(String estado) {
        Producto.estado = estado;
    }

    
    
    

}
