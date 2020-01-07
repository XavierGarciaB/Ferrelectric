/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.ventas;

import Tablas.CargarFactura;
import Tablas.FacturasCo;
import java.io.FileNotFoundException;
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
    private String[] nombreCampos = {"No. Factura","Total","Cantidad","Cliente","Descripcion","Direccion"};
    private String[] nombreFiltros = {"Num. Factura","Cliente","Cédula","Fecha"};
    
    public VentasView() throws FileNotFoundException{
        super("Ventas", new MainMenuView().build());
        CargarFactura.leerArchivo();
        for(FacturasCo fac: CargarFactura.getFacturas()){
            addRow(fac);
        }
    }

    public Parent build() throws FileNotFoundException {
        root = (VBox) super.build(nombreCampos, nombreFiltros);
        
        return root;
    }
}
