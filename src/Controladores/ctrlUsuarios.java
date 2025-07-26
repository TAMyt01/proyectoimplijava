/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Conexion.clsConexion;
import Modelos.clsUsuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;

import java.sql.ResultSet;
import java.util.List;
/**
 *
 * @author JManu
 */
public class ctrlUsuarios extends clsUsuario{
    
    //Metodo Iniciar Sesion
    public boolean loginUser(){
        
        boolean resp = false;
        
        Connection cn = clsConexion.conectar();
        
   
        
        String sql="select nombre, password from tb_usuario where idUsuario='"+ idUsuario +"' and binary password= '"+contrasenia+"' and estado='Activo'";
        Statement st;
        
        try {
            
            st=cn.createStatement();
           ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {                
                resp=true;
            }
            cn.close();
        } catch (SQLException ex) {
            
            System.out.println("Error en iniciar Secion"+ex);
            
        }
        
        return resp;
    }
    
    
    
    //CRUD
    
    public boolean guardar(clsUsuario user){
        boolean resp = false;
        Connection cn = clsConexion.conectar();
        final String SQL= "INSERT INTO tb_usuario (idUsuario,nombre,correo,password,rol,estado) VALUES (?,?,?,?,?,'Activo')";
        try {
            PreparedStatement consulta = cn.prepareStatement(SQL);
            consulta.setString(1, user.getIdUsuario());
            consulta.setString(2, user.getNombre());
            consulta.setString(3, user.getCorreo());
            consulta.setString(4, user.getContrasenia());
            consulta.setString(5, user.getRol());
            resp = consulta.executeUpdate() > 0;
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Error al guardar usuario: " + ex);
        }
        return resp;
    }
    
    
    public boolean modificar(){
        boolean resp = false;
        Connection cn = clsConexion.conectar();
        final String SQL="update tb_usuario set nombre=?,correo=?,password=?, rol=?, estado=? where idUsuario=?";
        try {
            
            PreparedStatement consulta = cn.prepareStatement(SQL);
            System.out.println(""+idUsuario);
            consulta.setString(1, nombre);
            consulta.setString(2, correo);
            consulta.setString(3, contrasenia);
            consulta.setString(4, rol);
            consulta.setString(5, estado);
            
            consulta.setString(6, idUsuario);
            if (consulta.executeUpdate()>0) {
                resp=true;
            }
            cn.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al modificar categoria: "+ex);
            
        }
        
        System.out.println(estado);
        return resp;
    }
    

    
    //Verifacar si hay mas de un Administrador
     public boolean CantAdmin (){
        boolean resp=false;
        Connection cn = clsConexion.conectar();
        ResultSet rs;
        final String SQL="select count(rol) as cantidad from tb_usuario where rol = 'Gerente' and estado='activo'";
        try {
            
           PreparedStatement consulta = cn.prepareStatement(SQL);
            rs = consulta.executeQuery();
            if (rs.next() && rs.getInt("cantidad")==1) {
                resp=true;
            }
            cn.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al consultar administradores: "+ex);

        }
        
        return resp;
    }
    
    
   public String IdentificadorRol() {
        String permiso = "";

        final String sql = "SELECT rol FROM tb_usuario WHERE idUsuario = '" + enUso + "'";
        Connection cn = clsConexion.conectar();
        Statement st = null;
        ResultSet rs = null;

        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);

            if (rs.next()) {
                permiso = rs.getString("rol");
            }
             cn.close();
        } catch (SQLException ex) {
            System.out.println("Error al buscar: " + ex.getMessage());

        }

        return permiso;
    }
   
   public String IdentificadorNombre() {
        String name = "";

        final String sql = "SELECT nombre FROM tb_usuario WHERE idUsuario = '" + enUso + "'";
        Connection cn = clsConexion.conectar();
        Statement st = null;
        ResultSet rs = null;

        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);

            if (rs.next()) {
                name = rs.getString("nombre");
            }
             cn.close();
        } catch (SQLException ex) {
            System.out.println("Error al buscar nombre: " + ex.getMessage());

        }

        return name;
    }
   
   public String obtenerPassword() {
        String password = "";

        final String sql = "SELECT password FROM tb_usuario WHERE idUsuario = ?";
        Connection cn = clsConexion.conectar();
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            pst = cn.prepareStatement(sql);
            pst.setString(1, enUso); 
            rs = pst.executeQuery();

            if (rs.next()) {
                password = rs.getString("password");
            }
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Error al buscar contraseña: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (cn != null) cn.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e.getMessage());
            }
        }

        return password;
    }
   
    public String obtenerPasswordModif(String identidadModif) {
        String password = "";

        final String sql = "SELECT password FROM tb_usuario WHERE idUsuario = ?";
        Connection cn = clsConexion.conectar();
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            pst = cn.prepareStatement(sql);
            pst.setString(1, identidadModif); 
            rs = pst.executeQuery();

            if (rs.next()) {
                password = rs.getString("password");
            }
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Error al buscar contraseña: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (cn != null) cn.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e.getMessage());
            }
        }

        return password;
    }   
    
    
    public boolean existeUsuario(String id) {
        boolean existe = false;
        Connection cn = clsConexion.conectar();
        ResultSet rs;
        final String SQL = "SELECT idUsuario FROM tb_usuario WHERE idUsuario = ?";

        try {
            PreparedStatement pst = cn.prepareStatement(SQL);
            pst.setString(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                existe = true; // Ya existe un usuario con ese ID
            }
            rs.close();
            pst.close();
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Error al verificar existencia de usuario: " + ex);
        }

        return existe;
    }
    
    public String obtenerCorreoPorID(String idBuscado) {
        String Correo = "";
        final String SQL = "SELECT correo FROM tb_usuario WHERE idUsuario = ?";

        Connection cn = clsConexion.conectar();
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            pst = cn.prepareStatement(SQL);
            pst.setString(1, idBuscado);
            rs = pst.executeQuery();

            if (rs.next()) {
                Correo = rs.getString("correo");
            }
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Error al buscar correo: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (cn != null) cn.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e.getMessage());
            }
        }

        return Correo;
    }

    
}
