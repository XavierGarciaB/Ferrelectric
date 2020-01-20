/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MySQL;

/**
 *
 * @author xavic
 */
public class Queries {
    public static final String getItems = "SELECT nombre, marca, costo, cantidad FROM item";
    public static final String getCompraProveedor = "select cp.numFactura as numFactura, p.nombre as nombre, p.ruc as ruc, cp.fecha as fecha, cp.costoTotal as Total, dc.idDetalleCompra as DetalleCompra\n" +
                                                    "from compraproveedor cp, proveedor p, detallecompra dc\n" +
                                                    "where cp.numFactura=dc.numFactura and cp.idProveedor=p.idProveedor";
}
