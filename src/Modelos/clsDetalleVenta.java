package Modelos;

/**
 * @author ediso
 */
public class clsDetalleVenta {

    //Atributos
    private int idDetalleVenta;
    private int idCabeceraVenta;
    private String idProducto;
    //esta de mas
    private String nombre;
    private int cantidad;
    private double precioUnitario;

    private double totalPagar;
    private int estado;

    //Contructor
    public clsDetalleVenta() {
        this.idDetalleVenta = 0;
        this.idCabeceraVenta = 0;
        this.idProducto = "";
        this.nombre = "";
        this.cantidad = 0;
        this.precioUnitario = 0.0;
    
        this.totalPagar = 0.0;
        this.estado = 0;
    }
    
    //Contructor sobrebargado

    public clsDetalleVenta(int idDetalleVenta, int idCabeceraVenta, String idProducto, String nombre, int cantidad, double precioUnitario,double totalPagar, int estado) {
        this.idDetalleVenta = idDetalleVenta;
        this.idCabeceraVenta = idCabeceraVenta;
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
       
        this.totalPagar = totalPagar;
        this.estado = estado;
    }
    
    //get and set

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public int getIdCabeceraVenta() {
        return idCabeceraVenta;
    }

    public void setIdCabeceraVenta(int idCabeceraVenta) {
        this.idCabeceraVenta = idCabeceraVenta;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    //toString

    @Override
    public String toString() {
        return "DetalleVenta{" + "idDetalleVenta=" + idDetalleVenta + ", idCabeceraVenta=" + idCabeceraVenta + ", idProducto=" + idProducto + ", nombre=" + nombre + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + ", totalPagar=" + totalPagar + ", estado=" + estado + '}';
    }
    

}
