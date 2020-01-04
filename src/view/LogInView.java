/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import ferrelectric.sbd.FerrelectricSBD;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author xavic
 */
public class LogInView implements View{
    private GridPane root;
    private VBox mainRoot;

    @Override
    public Parent build() {
        root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10,10,10,10));
        root.setVgap(10);
        root.setHgap(10);
        
        Label nombreLabel = new Label("Usuario");
        nombreLabel.getStyleClass().add("logIn_lbl");
        GridPane.setConstraints(nombreLabel, 0, 0);
        
        TextField nombreInput = new TextField();
        nombreInput.getStyleClass().add("logIn_input");
        GridPane.setConstraints(nombreInput, 1, 0);
        
        Label passwordLabel = new Label("Contraseña");
        passwordLabel.getStyleClass().add("logIn_lbl");
        GridPane.setConstraints(passwordLabel, 0, 1);
        
        TextField passwordInput = new TextField();
        passwordInput.getStyleClass().add("logIn_input");
        GridPane.setConstraints(passwordInput, 1, 1);
        
        Button logIn = new Button("Ingresar");
        logIn.getStyleClass().add("logIn_btn");
        logInAction(logIn);
        
        root.getChildren().addAll(nombreLabel, nombreInput, passwordLabel, passwordInput);
        
        mainRoot = new VBox();
        mainRoot.getChildren().addAll(root, logIn);
        mainRoot.setSpacing(20);
        mainRoot.setAlignment(Pos.CENTER);
        
        return mainRoot;
    }
    
    private void logInAction(Button btn){
        btn.setOnAction(e ->{
            try {
                FerrelectricSBD.setScene(new MainMenuView().build());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(LogInView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    
}
