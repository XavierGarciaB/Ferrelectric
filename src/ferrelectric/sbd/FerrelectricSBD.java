/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferrelectric.sbd;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import res.PATHS;
import view.LogInView;

/**
 *
 * @author xavic
 */
public class FerrelectricSBD extends Application {
    private static Scene scene;
    
    @Override
    public void start(Stage primaryStage) {
        scene = new Scene(new LogInView().build(), 1200, 800);
        scene.getStylesheets().add(PATHS.STYLESHEET_PATH);
        
        primaryStage.setTitle("FERRELECTRIC SBD");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public static void setScene(Parent newRoot){
        scene.setRoot(newRoot);
    }
    
}