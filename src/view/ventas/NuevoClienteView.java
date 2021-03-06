/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.ventas;

import controller.Alertas;
import controller.DBController;
import java.io.FileNotFoundException;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.View;

/**
 *
 * @author xavic
 */
public class NuevoClienteView implements View {
    private VBox root, cont;
    private Label labelNombre, labelCedula, labelDireccion, labelTelefono;
    private TextField inputNombre, inputCedula, inputDireccion, inputTelefono;
    private Button saveBtn;
    private GridPane body;
    private Stage stage;
    
    public NuevoClienteView(Stage stage){
        this.stage = stage;
    }

    @Override
    public Parent build() throws FileNotFoundException {
        root = new VBox();
        cont = new VBox();
        Label titulo = new Label("Nuevo Cliente");
        saveBtn = new Button("Guardar");
        
        // STYLES
        cont.getStyleClass().add("cont_view");
        titulo.getStyleClass().add("logIn_lbl");
        saveBtn.getStyleClass().add("save_btn");
  
        body();
        body.getStyleClass().add("grid_view");
        
        saveButtonAction();
        
        cont.getChildren().addAll(titulo, body, saveBtn);
        
        root.getChildren().add(cont);
        
        return root;
    }
    
    private void body(){
        body = new GridPane();
        labelNombre = new Label("Nombre");
        labelCedula = new Label("Cedula");
        labelDireccion = new Label("Direccion");
        labelTelefono = new Label("Telefono");
        inputNombre = new TextField();
        inputCedula = new TextField();
        inputDireccion = new TextField();
        inputTelefono = new TextField();
        
        body.add(labelNombre, 0, 0);
        body.add(inputNombre, 1, 0);
        body.add(labelCedula, 0, 1);
        body.add(inputCedula, 1, 1);
        body.add(labelDireccion, 0, 2);
        body.add(inputDireccion, 1, 2);
        body.add(labelTelefono, 0, 3);
        body.add(inputTelefono, 1, 3);
        
        // styles
        labelNombre.getStyleClass().add("grid_lbl_save");
        labelCedula.getStyleClass().add("grid_lbl_save");
        labelDireccion.getStyleClass().add("grid_lbl_save");
        labelTelefono.getStyleClass().add("grid_lbl_save");
        inputNombre.getStyleClass().add("grid_input");
        inputCedula.getStyleClass().add("grid_input");
        inputDireccion.getStyleClass().add("grid_input");
        inputTelefono.getStyleClass().add("grid_input");
    }
    
    private void saveButtonAction(){
        saveBtn.setOnAction(e ->{
            DBController.crearCliente(inputNombre.getText(), inputCedula.getText(), inputDireccion.getText(), inputTelefono.getText());
            Alert alert = Alertas.informationAlert("Guardado", "Nuevo Cliente!", "Un nuevo cliente ha sido guardado en la base de datos.");
            alert.showAndWait();
            stage.close();
        });
    }
}
