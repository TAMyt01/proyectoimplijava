
package Modelos;

public class clsCategoria {
    protected static int ID_categoria;
    protected static String nombre;
    protected static String descripcion;
    protected static String estado;

    public static void setEstado(String estado) {
        clsCategoria.estado = estado;
    }
    
    public clsCategoria() {
        ID_categoria=0;
        nombre="";
        descripcion="";  
    }

   

    public static void setID_categoria(int ID_categoria) {
        clsCategoria.ID_categoria = ID_categoria;
    }



    public static void setNombre(String nombre) {
        clsCategoria.nombre = nombre;
    }



    public static void setDescripcion(String descripcion) {
        clsCategoria.descripcion = descripcion;
    }
    
    
    
    
}
