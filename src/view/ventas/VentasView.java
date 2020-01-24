/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.ventas;

import ferrelectric.sbd.FerrelectricSBD;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import models.Venta;
import view.MainMenuView;
import view.proveedores.ProveedoresView;
import view.utils.GridComponents;

/**
 *
 * @author xavic
 */
public class VentasView extends GridComponents{
    private VBox root;
    private String[] nombreCampos = {"Num. Factura","Cliente","Cedula","Fecha","Total"};
    private String[] nombreFiltros = {"Num. Factura","Proveedor","RUC","Fecha","Total"};
    
    public VentasView() throws FileNotFoundException{
        super("Ventas", new MainMenuView().build());

    }

    public Parent build() throws FileNotFoundException {
        root = (VBox) super.build(nombreCampos, nombreFiltros);
        
        for(Venta venta : dbController.getVentas()){
            addRow(venta);
        }
        
        addButtonAction();
        
        return root;
    }
    
    private void addButtonAction(){
        addBtn.setOnMouseClicked(e ->{
            try {
                FerrelectricSBD.setScene(new VentaSimpleView().build());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ProveedoresView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

}
