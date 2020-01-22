/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.inventario;

import ferrelectric.sbd.FerrelectricSBD;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import models.Item;
import view.MainMenuView;
import view.utils.GridComponents;

/**
 *
 * @author xavic
 */
public class InventarioView extends GridComponents{
    private VBox root;
    private final String[] lbl_Filtros = {"Nombre","Marca","Precio Unitario"};
    private final String[] lbl_Nombres = {"Nombre","Marca","Precio Unitario","Cantidad"};
    
    public InventarioView() throws FileNotFoundException{
        super("Inventario", new MainMenuView().build());
    }

    public Parent build() throws FileNotFoundException {
        root = (VBox) super.build(lbl_Nombres, lbl_Filtros);
        
        for(Item item : dbController.getItems()){
            addRow(item);
        }
        
        addButtonAction();
        
        return root;
    }
    
    private void addButtonAction(){
        addBtn.setOnMouseClicked(e ->{
            try {
                FerrelectricSBD.setScene(new ItemView().build());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(InventarioView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
}
