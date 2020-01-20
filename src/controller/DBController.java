/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import MySQL.Connector;
import MySQL.Queries;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.CompraProveedor;
import models.Item;

/**
 *
 * @author xavic
 */
public class DBController {
    private static Connection conn;
    
    
    public DBController(){
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
            String pass = result.getString("Pass");
            boolean admin = result.getBoolean("Administrador");
            if(name.equals(nombre) && password.equals(pass) && admin)
                return true;
        }
        return false;
    }
    
    public List<Item> getItems(){
        List<Item> items = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(Queries.getItems);
            ResultSet result = ps.executeQuery();
            
            while(result.next()){
                String nombre = result.getString("nombre");
                String marca = result.getString("marca");
                double precioUnitario = result.getDouble("costo");
                int cantidad = result.getInt("cantidad");
                items.add(new Item(nombre, marca, precioUnitario, cantidad));                 
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return items;
    }
    
    public List<CompraProveedor> getComprasProveedor(){
        List<CompraProveedor> proveedores = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(Queries.getCompraProveedor);
            ResultSet result = ps.executeQuery();
            
            while(result.next()){
                String numFactura = String.valueOf(result.getInt("numfactura"));
                String nombre = result.getString("nombre");
                String ruc = result.getString("ruc");
                Date fecha = result.getDate("fecha");
                double total = result.getDouble("total");
                String detalleCompra = String.valueOf(result.getInt("DetalleCompra"));
                proveedores.add(new CompraProveedor(numFactura, nombre, ruc, fecha, total, detalleCompra));                 
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return proveedores;
    }

}
