package Modelos;

/**
 * @author ediso
 */
public class clsCabeceraVenta {
    
    //Atributos
    private int idCabeceraventa;
    private String idCliente;
    private double valorPagar;
    private String fechaVenta;
    private int estado;
    
    //constructor
    public clsCabeceraVenta(){
        this.idCabeceraventa = 0;
        this.idCliente = "";
        this.valorPagar = 0.0;
        this.fechaVenta = "";
        this.estado = 0;
    }
    
     //constructor sobrecargado

    public clsCabeceraVenta(int idCabeceraventa, String idCliente, double valorPagar, String fechaVenta, int estado) {
        this.idCabeceraventa = idCabeceraventa;
        this.idCliente = idCliente;
        this.valorPagar = valorPagar;
        this.fechaVenta = fechaVenta;
        this.estado = estado;
    }
    
    //get and set 

    public int getIdCabeceraventa() {
        return idCabeceraventa;
    }

    public void setIdCabeceraventa(int idCabeceraventa) {
        this.idCabeceraventa = idCabeceraventa;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public double getValorPagar() {
        return valorPagar;
    }

    public void setValorPagar(double valorPagar) {
        this.valorPagar = valorPagar;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
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
        return "CabeceraVenta{" + "idCabeceraventa=" + idCabeceraventa + ", idCliente=" + idCliente + ", valorPagar=" + valorPagar + ", fechaVenta=" + fechaVenta + ", estado=" + estado + '}';
    }
    
    
    
}
