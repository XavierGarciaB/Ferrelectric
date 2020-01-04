/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.proveedores;

import java.io.FileNotFoundException;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import view.MainMenuView;
import view.utils.GridComponents;

/**
 *
 * @author xavic
 */
public class ProveedoresView extends GridComponents{
    private VBox root;
    private String[] nombreCampos = {"Num. Factura","Proveedor","RUC","Fecha","Detalle Compra"};
    private String[] nombreFiltros = {"Num. Factura", "Proveedor", "RUC", "Fecha"};
    
    public ProveedoresView() throws FileNotFoundException{
        super("Proveedores", new MainMenuView().build());
    }

    public Parent build() throws FileNotFoundException {
        root = (VBox) super.build(nombreCampos, nombreFiltros);
        
        return root;
    }
}
