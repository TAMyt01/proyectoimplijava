
package Controladores;

import Conexion.clsConexion;
import Modelos.clsCategoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.ResultSet;


public class ctrlCategoria extends clsCategoria {
    
    public boolean guardar(){
        boolean resp = false;
        Connection cn = clsConexion.conectar();
        final String SQL= "insert into tb_categoria (nombre,descripcion,estado) values (?,?,'Activo')";
        try {
            
            PreparedStatement consulta = cn.prepareStatement(SQL);
            consulta.setString(1, nombre);
            consulta.setString(2, descripcion);
            if (consulta.executeUpdate()>0) {
                resp=true;
            }
            cn.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al guardar categoria: "+ex);
            
        }
        
        
        return resp;
    }
    
    
    public boolean modificar(){
        boolean resp = false;
        Connection cn = clsConexion.conectar();
        final String SQL="update tb_categoria set nombre=?,descripcion=?, estado=? where ID_categoria=?";
        try {
            
            PreparedStatement consulta = cn.prepareStatement(SQL);
           // System.out.println(""+getID_categoria());
            consulta.setString(1, nombre);
            consulta.setString(2, descripcion);
            consulta.setString(3, estado);
            consulta.setInt(4, ID_categoria);
            if (consulta.executeUpdate()>0) {
                resp=true;
            }
            cn.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al modificar categoria: "+ex);
            
        }
        
        
        return resp;
    }
    
    //Validamos si ya existe la categoria
    public static String mens;
    public boolean existeCategoria(String nom){
        boolean resp=false;
        Connection cn = clsConexion.conectar();
        ResultSet rs;
        final String SQL="select nombre from tb_categoria where nombre = ?";
        try {
            
           PreparedStatement consulta = cn.prepareStatement(SQL);
            consulta.setString(1, nom);
            rs = consulta.executeQuery();
           
            if (rs.next()) {
                resp=true;
                mens = "La categoria "+rs.getString("nombre")+" ya existe";
            }
            cn.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al consultar categoria: "+ex);
            
        }
        
        return resp;
    }
    
    
}
