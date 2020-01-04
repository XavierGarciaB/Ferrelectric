/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.inventario;

import java.io.FileNotFoundException;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import view.MainMenuView;
import view.utils.GridComponents;

/**
 *
 * @author xavic
 */
public class InventarioView extends GridComponents{
    private VBox root;
    private final String[] lbl_Filtros = {"Nombre","Sección","Precio Unitario"};
    private final String[] lbl_Nombres = {"Nombre","Material","Sección","Precio Unitario","Cantidad"};
    
    public InventarioView() throws FileNotFoundException{
        super("Inventario", new MainMenuView().build());

    }

    public Parent build() throws FileNotFoundException {
        root = (VBox) super.build(lbl_Nombres, lbl_Filtros);
        
        return root;
    }
    
}
