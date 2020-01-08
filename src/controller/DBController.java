/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import MySQL.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author xavic
 */
public class DBController {
    private static Connection conn;
    
    
    public static void conectarBD(){
        conn = Connector.getConnection();
    }
    
    // YA ESTA IMPLEMENTADA LA VALIDACION DEL USUARIO 
    // LOS USUARIOS ESTAN DENTRO DE LA BASE DE DATOS
    // LA CONTRASEÑA ES LA CEDULA DEL EMPLEADO
    public static boolean existeUsuario(String nombre, String password) throws SQLException{
        PreparedStatement ps = conn.prepareStatement("SELECT * from empleado;");
        ResultSet result = ps.executeQuery();
        while(result.next()){
            String name = result.getString("Nombre");
            String cedula = result.getString("Cedula");
            boolean admin = result.getBoolean("Administrador");
            if(name.equals(nombre) && password.equals(cedula) && admin)
                return true;
        }
        return false;
    }
}
