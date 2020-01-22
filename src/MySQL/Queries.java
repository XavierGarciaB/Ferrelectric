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
    
    
    public static final String getCompraProveedor = "select cp.numFactura as numFactura, p.nombre as nombre, p.ruc as ruc, cp.fecha as fecha, total.total as Total, dc.idDetalleCompra as DetalleCompra\n" +
                                                    "from compraproveedor cp, proveedor p, detallecompra dc, (select cp.numFactura as numFactura, sum(i.costo*dc.cantidad) as total\n" +
                                                    "														from detallecompra dc, item i, compraproveedor cp\n" +
                                                    "														where i.idItem=dc.idItem and cp.numFactura=dc.numFactura\n" +
                                                    "														group by cp.numFactura) as total\n" +
                                                    "where cp.numFactura=dc.numFactura and cp.idProveedor=p.idProveedor and total.numFactura=cp.numFactura\n" +
                                                    "group by cp.numFactura;";
    
    
    public static final String getVentas = "select f.numFactura as numFactura, c.nombre as nombre, c.cedula as cedula, f.fecha as fecha, total.total as total, dv.idVenta as DetalleVenta\n" +
                                            "from factura f, cliente c, descripcionventa dv, (select f.numFactura as numFactura, sum(i.costo*dv.cantidad) as total\n" +
                                            "												from descripcionventa dv, item i, factura f\n" +
                                            "												where i.idItem=dv.idItem and f.numFactura=dv.numFactura\n" +
                                            "												group by f.numFactura) as total \n" +
                                            "where f.cedula=c.cedula and dv.numFactura=f.numFactura and total.numFactura=f.numFactura\n" +
                                            "group by f.numFactura;";

    
    public static final String insertItem = "INSERT INTO `mydb`.`Item` (`Nombre`, `Costo`, `Marca`,`Cantidad`) VALUES (?, ?, ?, ?);";
    
    public static final String storedDetallesVenta = "{call obtenerDetalleVentaNumFactura(?)}";
    
    public static final String storedDetallesCompra = "{call obtenerDetalleCompraNumFactura(?)}";
}
