/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.ventas;

import MySQL.Connector;
import Tablas.CargarFactura;
import Tablas.FacturasCo;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import view.MainMenuView;
import view.utils.GridComponents;

/**
 *
 * @author xavic
 */
public class VentasView extends GridComponents{
    private VBox root;
    private String[] nombreCampos = {"No. Factura","Total","Cantidad","Cliente","Fecha","Descripcion","Direccion"};
    private String[] nombreFiltros = {"Num. Factura","Cliente","Cédula","Fecha"};
    
    public VentasView() throws FileNotFoundException{
        super("Ventas", new MainMenuView().build());

    }

    public Parent build() throws FileNotFoundException {
        root = (VBox) super.build(nombreCampos, nombreFiltros);
        
        CargarFactura.leerArchivo();
        for(FacturasCo fac: CargarFactura.getFacturas()){
            addRow(fac);
        }
        
        return root;
    }

}
