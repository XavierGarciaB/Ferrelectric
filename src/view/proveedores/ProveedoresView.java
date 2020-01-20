/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.proveedores;

import ferrelectric.sbd.FerrelectricSBD;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import models.CompraProveedor;
import view.MainMenuView;
import view.inventario.InventarioView;
import view.inventario.ItemView;
import view.utils.GridComponents;

/**
 *
 * @author xavic
 */
public class ProveedoresView extends GridComponents{
    private VBox root;
    private String[] nombreCampos = {"Num. Factura","Proveedor","RUC","Fecha","Total","Detalle Compra"};
    private String[] nombreFiltros = {"Num. Factura", "Proveedor", "RUC","Costo total", "Fecha"};
    
    public ProveedoresView() throws FileNotFoundException{
        super("Proveedores", new MainMenuView().build());
    }

    public Parent build() throws FileNotFoundException {
        root = (VBox) super.build(nombreCampos, nombreFiltros);
        
        for(CompraProveedor compra : dbController.getComprasProveedor()){
            addRow(compra);
        }
        
        addButtonAction();
        
        return root;
    }
    
    private void addButtonAction(){
        addBtn.setOnMouseClicked(e ->{
            try {
                FerrelectricSBD.setScene(new CompraProveedorView().build());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ProveedoresView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
}
