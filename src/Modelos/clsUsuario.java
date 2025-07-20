
package Modelos;


public class clsUsuario 

{

    public String idUsuario;
    public String nombre;
    public String contrasenia;
    public String rol;
    public String estado;
    public String enUso;
    private String correo;

    // Constructor vacío
    public clsUsuario() 
    {
        this.idUsuario = "";
        this.nombre = "";
        this.contrasenia = "";
        this.rol = "";
        this.estado = "";
        this.enUso = "";
    }

    // Constructor con parámetros
    public clsUsuario(String idUsuario, String nombre, String contrasenia, String rol, String estado, String enUso) 
    {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.rol = rol;
        this.estado = estado;
        this.enUso = enUso;
    }

   
    public String getIdUsuario() 
    {
        return idUsuario;
    }

    public String getNombre() 
    {
        return nombre;
    }

    public String getContrasenia() 
    {
        return contrasenia;
    }

    public String getRol() {
        return rol;
    }

    public String getEstado() 
    {
        return estado;
    }

    public String getEnUso() 
    {
        return enUso;
    }

 
    public void setIdUsuario(String idUsuario) 
    {
        this.idUsuario = idUsuario;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public void setContrasenia(String contrasenia) 
    {
        this.contrasenia = contrasenia;
    }
    
    public void setCorreo (String correo)
    {
        this.correo = correo;
    } 

    public void setRol(String rol) 
    {
        this.rol = rol;
    }

    public void setEstado(String estado) 
    {
        this.estado = estado;
    }

    public void setEnUso(String enUso) 
    {
        this.enUso = enUso;
    }

    // Validación de contraseña
    public boolean validarContrasenia(String contraseniaIngresada) 
    {
        return this.contrasenia.equals(contraseniaIngresada);
    }
}
