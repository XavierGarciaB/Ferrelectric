/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.ventas;

import ferrelectric.sbd.FerrelectricSBD;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import models.Venta;
import view.View;
import view.inventario.ItemView;
import view.proveedores.ProveedoresView;
import view.utils.Header;

/**
 *
 * @author xavic
 */
public class VentaSimpleView implements View {
    private VBox root, content;
    private Label name, labelNumFactura, labelProveedor, labelRuc, labelFecha, labelTotal, labelDetalle;
    private TextField inputNumFactura, inputProveedor, inputRuc, inputFecha, inputTotal, inputDetalle;
    private GridPane body;
    private Button saveBtn;
    private Header header;

    @Override
    public Parent build() throws FileNotFoundException {
        root = new VBox();
        content = new VBox();
        header = new Header("Venta");
        header.addBackEventListener(new VentasView().build());
        name = new Label("Venta");
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
        labelNumFactura = new Label("Num Factura");
        labelProveedor = new Label("Cliente");
        labelRuc = new Label("Cedula");
        labelFecha = new Label("Fecha");
        labelTotal = new Label("Total");
        labelDetalle = new Label("Detalle Compra");
        inputNumFactura = new TextField();
        inputProveedor = new TextField();
        inputRuc = new TextField();
        inputFecha = new TextField();
        inputTotal = new TextField();
        inputDetalle = new TextField();
        
        //ES POSIBLE QUE HAYA UNA FORMA MÁS EFICIENTE DE ASIGNAR ESTO
        //POR AHORA SE QUEDA ASÍ
        labelNumFactura.getStyleClass().add("grid_lbl_save");
        labelProveedor.getStyleClass().add("grid_lbl_save");
        labelRuc.getStyleClass().add("grid_lbl_save");
        labelFecha.getStyleClass().add("grid_lbl_save");
        labelTotal.getStyleClass().add("grid_lbl_save");
        labelDetalle.getStyleClass().add("grid_lbl_save");
        inputNumFactura.getStyleClass().add("grid_input");
        inputProveedor.getStyleClass().add("grid_input");
        inputRuc.getStyleClass().add("grid_input");
        inputFecha.getStyleClass().add("grid_input");
        inputTotal.getStyleClass().add("grid_input");
        inputDetalle.getStyleClass().add("grid_input");

        body.add(labelNumFactura, 0, 0);
        body.add(inputNumFactura, 1, 0);
        body.add(labelProveedor, 0, 1);
        body.add(inputProveedor, 1, 1);
        body.add(labelRuc, 0, 3);
        body.add(inputRuc, 1, 3);
        body.add(labelFecha, 0, 4);
        body.add(inputFecha, 1, 4);
        body.add(labelTotal, 0, 5);
        body.add(inputTotal, 1, 5);
        body.add(labelDetalle, 0, 6);
        body.add(inputDetalle, 1, 6);
    }
    
    private void saveButtonAction(){
        saveBtn.setOnAction(e ->{
            if(inputNumFactura.getText().equals("") || inputProveedor.getText().equals("") || inputRuc.getText().equals("")){
                this.cancel().showAndWait();
            }else{
                try {
                    String numFactura = inputNumFactura.getText();
                    String nombreCliente = inputProveedor.getText();
                    String cedula = inputRuc.getText();
                    Date fecha = null;
                    double total = Double.parseDouble(inputTotal.getText());
                    String detalle = inputDetalle.getText();
                    Venta venta = new Venta(numFactura, nombreCliente, cedula, fecha, total, detalle);
                    this.accept().showAndWait();
                    FerrelectricSBD.setScene(new ProveedoresView().build());
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
