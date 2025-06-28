package Controladores;

import Conexion.clsConexion;
import Modelos.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ctrlClientes extends Clientes {

    public boolean guardar() {
        boolean resp = false;
        Connection cn = clsConexion.conectar();
        final String SQL = "INSERT INTO tb_cliente (nombre, identidad, telefono, direccion, estado) VALUES (?, ?, ?, ?, 'Activo')";
        try {
            PreparedStatement consulta = cn.prepareStatement(SQL);
            consulta.setString(1, nombre);
            consulta.setString(2, identidad);
            consulta.setString(3, telefono);
            consulta.setString(4, direccion);

            if (consulta.executeUpdate() > 0) {
                resp = true;
            }
            cn.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Identidad ya registrada");
        }
        return resp;
    }

    public boolean modificar() {
        boolean resp = false;
        Connection cn = clsConexion.conectar();
        final String SQL = "UPDATE tb_cliente SET nombre=?,  telefono=?, direccion=?, estado=? WHERE identidad=?";
        try {
            PreparedStatement consulta = cn.prepareStatement(SQL);
            consulta.setString(1, nombre);
            consulta.setString(2, telefono);
            consulta.setString(3, direccion);
            consulta.setString(4, estado);
            consulta.setString(5, identidad);
            System.out.println(""+identidad);
            if (consulta.executeUpdate() > 0) {
                resp = true;
            }
            cn.close();

        } catch (SQLException ex) {
            System.out.println("Error al modificar cliente: " + ex);
        }
        return resp;
    }


}
