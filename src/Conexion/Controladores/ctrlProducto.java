package Controladores;

import Conexion.clsConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Modelos.clsProducto;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author JManu
 */
public class ctrlProducto extends clsProducto {

    public boolean guardar() {
        boolean resp = false;
        Connection cn = clsConexion.conectar();
        final String SQL = "insert into tb_producto (ID_producto, nombre, descripcion, precio_venta, cantidad, ID_categoria, estado) values (?,?,?,?,?,?,'Activo')";
        try {

            PreparedStatement consulta = cn.prepareStatement(SQL);
            consulta.setString(1, ID_Producto);
            consulta.setString(2, nombre);
            consulta.setString(3, descripcion);
            consulta.setDouble(4, precio_venta);
            consulta.setInt(5, cantidad);
            consulta.setInt(6, IdCate(categoria));
            if (consulta.executeUpdate() > 0) {
                resp = true;
            }
            cn.close();

        } catch (SQLException ex) {
            System.out.println("Error al guardar categoria: " + ex);
            JOptionPane.showMessageDialog(null, "Id de producto ya registrado");
            

        }

        return resp;
    }

    public boolean modificar() {
        boolean resp = false;
        Connection cn = clsConexion.conectar();
        final String SQL = "update tb_producto set  nombre=?, descripcion=?, precio_venta=?, cantidad=?, ID_categoria=?, estado=? where ID_producto=?";
        try {

            PreparedStatement consulta = cn.prepareStatement(SQL);

            consulta.setString(7, ID_Producto);
            consulta.setString(1, nombre);
            consulta.setString(2, descripcion);
            consulta.setDouble(3, precio_venta);
            consulta.setInt(4, cantidad);
            consulta.setInt(5, IdCate(categoria));
            consulta.setString(6, estado);
            if (consulta.executeUpdate() > 0) {
                resp = true;
            }
            cn.close();

        } catch (SQLException ex) {
            System.out.println("Error al modificar categoria: " + ex);

        }

        return resp;
    }

    public static String mens;

    public boolean existeProducto(String id, String nom, String metodo) {
        boolean resp = false;
        Connection cn = clsConexion.conectar();
        ResultSet rs ;


        try (PreparedStatement consulta = cn.prepareStatement(buildSQLQuery(metodo))) {

            if (metodo.equals("Agregar")) {
                consulta.setString(1, id);
                consulta.setString(2, nom);
            } else {
                consulta.setString(1, nom);
            }

            rs = consulta.executeQuery();

            if (rs.next()) {
                resp = true;
                System.out.println("existe");
                mens = "Nombre o codigo de producto ya esta en uso: \n Codigo de producto: "
                        + rs.getString("ID_Producto")
                        + "\n Nombre de Producto: "
                        + rs.getString("nombre");
            }

        } catch (SQLException ex) {
            System.out.println("Error al consultar producto: " + ex);
        } 
        return resp;
    }

    private String buildSQLQuery(String metodo) {
        if (metodo.equals("Agregar")) {
            return "SELECT ID_Producto, nombre FROM tb_producto WHERE ID_Producto = ? OR nombre = ?";
        } else {
            return "SELECT ID_Producto, nombre FROM tb_producto WHERE nombre = ?";
        }
    }

    public int IdCate(String nombre) {
        Connection cn = clsConexion.conectar();
        ResultSet rs;
        final String SQL = "select ID_categoria from tb_categoria where nombre = ?";
        try {

            PreparedStatement consulta = cn.prepareStatement(SQL);
            consulta.setString(1, nombre);

            rs = consulta.executeQuery();

            if (rs.next()) {
                return rs.getInt("ID_categoria");
            }
            cn.close();

        } catch (SQLException ex) {
            System.out.println("Error al consultar producto: " + ex);

        }
        return -1;
    }
    
    
    //Actualizar clsProducto
    public boolean ActualizarStock() {
        boolean resp = false;
        Connection cn = clsConexion.conectar();
        final String SQL = "update tb_producto set cantidad=? where ID_producto=?";
        try {

            PreparedStatement consulta = cn.prepareStatement(SQL);

            
            consulta.setInt(1, cantidad);
            consulta.setString(2, ID_Producto);
            
            if (consulta.executeUpdate() > 0) {
                resp = true;
            }
            cn.close();

        } catch (SQLException ex) {
            System.out.println("Error al Actualzar Stock: " + ex);

        }

        return resp;
    }
}
