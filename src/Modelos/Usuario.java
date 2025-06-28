
package Modelos;


public class Usuario {
    
    protected static String idUsuario;
    protected static String nombre;
     protected static String contrasenia;
     protected static String rol;
     protected static String estado ;
     protected static String enUso ;

   
     

    public Usuario() {
    idUsuario="";
    nombre="";
    contrasenia="";
    rol="";
    }

 

    public static void setIdUsuario(String idUsuario) {
        Usuario.idUsuario = idUsuario;
    }

    

    public static void setNombre(String nombre) {
        Usuario.nombre = nombre;
    }

   
    public static void setContrasenia(String contrasenia) {
        Usuario.contrasenia = contrasenia;
    }

    public static void setEstado(String estado) {
        Usuario.estado = estado;
    }

   

    public static void setRol(String rol) {
        Usuario.rol = rol;
    }

    public static String getEnUso() {
        return enUso;
    }

    public static void setEnUso(String enUso) {
        Usuario.enUso = enUso;
    }
    
    
    
    
}
