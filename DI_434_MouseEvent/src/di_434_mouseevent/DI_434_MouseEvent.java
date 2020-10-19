/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
    
    Autor: Marcos Gonzalez Leon
 */
package di_434_mouseevent;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Marcos Gonzalez Leon
 */
public class DI_434_MouseEvent extends Application {
    
    // Variables.
    int pos_x;
    int pos_y;
    
    @Override
    public void start(Stage primaryStage) {
        
        
        Label texto = new Label();
        texto.setMinWidth(10);
        texto.setPrefWidth(10);
        texto.setMaxWidth(150);
        texto.setText("Programming is fun");        
        
        // Lambda Expresion for DraggedEvent.
        texto.setOnMouseDragged((MouseEvent event) -> {
            // Move Text with Cursor/Mouse poisition.
            texto.setTranslateX(texto.getTranslateX()+event.getX());
            texto.setTranslateY(texto.getTranslateY()+event.getY());
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(texto);
        
        Scene scene = new Scene(root, 300, 250);        
        
        primaryStage.setTitle("Expresiones Lambda. Action Event");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
