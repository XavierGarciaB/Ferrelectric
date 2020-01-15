/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.inventario;

import controller.DBController;
import java.io.FileNotFoundException;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import models.Item;
import models.Listable;
import view.MainMenuView;
import view.utils.GridComponents;

/**
 *
 * @author xavic
 */
public class InventarioView extends GridComponents{
    private VBox root;
    private final String[] lbl_Filtros = {"Nombre","Marca","Precio Unitario"};
    private final String[] lbl_Nombres = {"Nombre","Marca","Precio Unitario"};
    private static DBController dbController;
    
    public InventarioView() throws FileNotFoundException{
        super("Inventario", new MainMenuView().build());
        dbController = new DBController();
    }

    public Parent build() throws FileNotFoundException {
        root = (VBox) super.build(lbl_Nombres, lbl_Filtros);
        
        for(Item item : dbController.getItems()){
            addRow(item);
        }
        
        return root;
    }
    
}
