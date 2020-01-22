/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.utils;

import controller.DBController;
import ferrelectric.sbd.FerrelectricSBD;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import models.CompraProveedor;
import models.Listable;
import models.Venta;
import res.PATHS;
import view.proveedores.DetalleCompra;
import view.ventas.DetalleVenta;

/**
 *
 * @author xavic
 */
public class GridComponents{
    private VBox root;
    private GridPane contComponents;
    private Button searchBtn;
    protected StackPane addBtn;
    private TextField input;
    private ComboBox filtros;
    private Label lblFiltro;
    private HBox contBusqueda;
    private AnchorPane contInicial;
    private ScrollPane scroll;
    private Header header;
    private int rowsNumber;
    protected DBController dbController;
    
    public GridComponents(String headerTitle, Parent scenePrevia) throws FileNotFoundException{
        dbController = new DBController();
        header = new Header(headerTitle);
        header.addBackEventListener(scenePrevia);
        rowsNumber = 1;
    }

    public Parent build(String[] nombreCampos, String[] nombreFiltros) throws FileNotFoundException {
        root = new VBox();
        contComponents = new GridPane();
        scroll = new ScrollPane(contComponents);
        root.setSpacing(10);
        
        crearBusqueda(nombreFiltros);
        
        crearCuerpo(nombreCampos);
        
        root.getChildren().addAll(header.render(), contInicial, scroll);
        
        root.setPadding(new Insets(0, 0, 10, 0));
                
        
        return root;
    }
    
    private void crearBusqueda(String[] nombreLabels) throws FileNotFoundException{
        contBusqueda = new HBox();
        filtros = new ComboBox(FXCollections.observableArrayList(nombreLabels));
        input = new TextField();
        lblFiltro = new Label("Filtrar");
        searchBtn = new Button("Buscar");
        
        contBusqueda.getChildren().addAll(lblFiltro, input, filtros, searchBtn);
        contBusqueda.setSpacing(10);
        
        ImageView add = new ImageView(new Image(new FileInputStream(PATHS.IMAGE_PATH+"add-icon.png")));
        add.setFitHeight(35);
        add.setFitWidth(35);
        add.setPreserveRatio(true);
        addBtn = new StackPane(add);
        addBtn.getStyleClass().add("add_btn");
        
        contInicial = new AnchorPane();
        AnchorPane.setRightAnchor(addBtn, 10.0);
        AnchorPane.setLeftAnchor(contBusqueda, 10.0);
        contInicial.getChildren().addAll(contBusqueda, addBtn);
        
    }
    
    private void crearCuerpo(String[] nombreCampos){
        // Crea la cabecera de la tabla
        for(int i = 0; i < nombreCampos.length; i++){
            Label nombre = new Label(nombreCampos[i]);
            nombre.getStyleClass().add("title_lbl");
            StackPane nombrePane = new StackPane(nombre);
            nombrePane.getStyleClass().add("title_cont");
            GridPane.setConstraints(nombrePane, i, 0);
            GridPane.setHgrow(nombrePane, Priority.ALWAYS);
            contComponents.getChildren().add(nombrePane);
        }
        
        contComponents.getStyleClass().add("grid_components");
        
        scroll.setFitToWidth(true);
        scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scroll.hbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.AS_NEEDED);
      
    }
    
    public void addRow(Listable row){
        // No hay necesidad de separar por casos
        List<String> values = row.getValues();
        for(int i=0; i < values.size(); i++){
                Label value = new Label(values.get(i));
                value.getStyleClass().add("grid_lbl");
                StackPane contValue = new StackPane(value);
                // PROBANDO LLEVAR LA REFERENCIA
                asignarReferencia(contValue, row);
                contValue.setStyle("-fx-border-color: white;");
                contComponents.add(contValue, i, rowsNumber);
                GridPane.setHgrow(contValue, Priority.ALWAYS);
            }
        rowsNumber++;
    }
    
    private void asignarReferencia(Parent cont, Listable row){
        cont.setOnMouseClicked(e ->{
            if(row instanceof Venta){
                try {
                    Venta venta = (Venta) row;
                    FerrelectricSBD.setScene(new DetalleVenta(venta).build());
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(GridComponents.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(row instanceof CompraProveedor){
                try {
                    CompraProveedor compra = (CompraProveedor) row;
                    FerrelectricSBD.setScene(new DetalleCompra(compra).build());
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(GridComponents.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    
}
