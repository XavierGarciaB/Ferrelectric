/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.inventario;

import controller.DBController;
import ferrelectric.sbd.FerrelectricSBD;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import models.Item;
import view.View;
import view.utils.Header;

/**
 *
 * @author xavic
 */
public class ItemView implements View {
    private VBox root, content;
    private Label name, labelName, labelMarca, labelPU, labelCantidad;
    private TextField inputName, inputMarca, inputPU, inputCantidad;
    private GridPane body;
    private Button saveBtn;
    private Header header;

    @Override
    public Parent build() throws FileNotFoundException {
        root = new VBox();
        content = new VBox();
        header = new Header("Item");
        header.addBackEventListener(new InventarioView().build());
        name = new Label("ITEM");
        body = new GridPane();
        saveBtn = new Button("Guardar");
        
        content.getStyleClass().add("cont_view");
        name.getStyleClass().add("logIn_lbl");
        body.getStyleClass().add("grid_view");
        saveBtn.getStyleClass().add("save_btn");
        
        createBody();
        saveButtonAction();
        
        content.getChildren().addAll(name, body, saveBtn);
        root.getChildren().addAll(header.render(), content);
        return root;
    }
    
    private void createBody(){
        labelName = new Label("Nombre");
        labelMarca = new Label("Marca");
        labelPU = new Label("Precio Unitario");
        labelCantidad = new Label("Cantidad");
        inputName = new TextField();
        inputMarca = new TextField();
        inputPU = new TextField();
        inputCantidad = new TextField();
        
        //ES POSIBLE QUE HAYA UNA FORMA MÁS EFICIENTE DE ASIGNAR ESTO
        //POR AHORA SE QUEDA ASÍ
        labelName.getStyleClass().add("grid_lbl_save");
        labelMarca.getStyleClass().add("grid_lbl_save");
        labelPU.getStyleClass().add("grid_lbl_save");
        labelCantidad.getStyleClass().add("grid_lbl_save");
        inputName.getStyleClass().add("grid_input");
        inputMarca.getStyleClass().add("grid_input");
        inputPU.getStyleClass().add("grid_input");
        inputCantidad.getStyleClass().add("grid_input");

        body.add(labelName, 0, 0);
        body.add(inputName, 1, 0);
        body.add(labelMarca, 0, 1);
        body.add(inputMarca, 1, 1);
        body.add(labelPU, 0, 3);
        body.add(inputPU, 1, 3);
        body.add(labelCantidad, 0, 4);
        body.add(inputCantidad, 1, 4);
    }
    
    private void saveButtonAction(){
        saveBtn.setOnAction(e ->{
            if(inputName.getText().equals("") || inputMarca.getText().equals("") || inputPU.getText().equals("")){
                this.cancel().showAndWait();
            }else{
                try {
                    String nombre = inputName.getText();
                    String marca = inputMarca.getText();
                    double precioUnitario = Double.parseDouble(inputPU.getText());
                    int cantidad = Integer.parseInt(inputCantidad.getText());
                    Item item = new Item(nombre, marca, precioUnitario, cantidad);
                    DBController.insertItem(item);
                    this.accept().showAndWait();
                    FerrelectricSBD.setScene(new InventarioView().build());
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ItemView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private Alert cancel(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("Error de datos");
        alert.setContentText("Los datos ingresados no son correctos");
        return alert;
    }
    
    private Alert accept(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("SAVE");
        alert.setHeaderText("Datos guardados");
        alert.setContentText("Los datos ingresados se han guardado en la base de datos");
        return alert;
    }
}
