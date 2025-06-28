
package Modelos;

public class Categoria {
    protected static int ID_categoria;
    protected static String nombre;
    protected static String descripcion;
    protected static String estado;

    public static void setEstado(String estado) {
        Categoria.estado = estado;
    }
    
    public Categoria() {
        ID_categoria=0;
        nombre="";
        descripcion="";  
    }

   

    public static void setID_categoria(int ID_categoria) {
        Categoria.ID_categoria = ID_categoria;
    }



    public static void setNombre(String nombre) {
        Categoria.nombre = nombre;
    }



    public static void setDescripcion(String descripcion) {
        Categoria.descripcion = descripcion;
    }
    
    
    
    
}
