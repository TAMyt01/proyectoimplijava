
package Conexion;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class clsConexion {
    private static final String database="jdbc:mysql://localhost:3306/Empresa?useSSL=false";
    private static final String userdatabase="root";
    private static final String contradatabase="TAMyt_01";
    
    public static Connection conectar(){
        
        try {
            
            Connection cn = DriverManager.getConnection(database,userdatabase,contradatabase);
            return cn;
        } catch (SQLException ex) {
            
            System.out.println("Error en la conexion"+ex+"\n");
        }
        return null;
        
    }
    
}
