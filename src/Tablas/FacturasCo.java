/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablas;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class FacturasCo {  
    //ME DA PROBLEMAS LA FECHA
    String no;
    double total;
    int cantidad;
    String nombre;
    //Date fecha;
    String descripcion;
    String direccion;

    public FacturasCo(String no, double total, int cantidad,String nombre, /*Date fecha,*/ String descripcion, String direccion) {
        this.no = no;
        this.total = total;
        this.cantidad = cantidad;
        this.nombre = nombre;
        //this.fecha = fecha;
        this.descripcion = descripcion;
        this.direccion = direccion;
    }        
    
    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
//    public Date getFecha() {
//        return fecha;
//    }
//
//    public void setFecha(Date fecha) {
//        this.fecha = fecha;
//    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }   

    @Override
    public String toString() {
        return "FacturasCo{" + "no=" + no + ", total=" + total + ", cantidad=" + cantidad + ", nombre=" + nombre + ", descripcion=" + descripcion + ", direccion=" + direccion + '}';
    }
    
    

}
