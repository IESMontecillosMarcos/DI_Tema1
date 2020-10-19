/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di_435_keyevent;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Marcos Gonzalez Leon
 */
public class DI_435_KeyEvent extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        // Components.
        Text texto = new Text(20,20,"A");
        // Allow Text Translate position to be modified, in case it is not by default.
        texto.setFocusTraversable(true);
        
        
        texto.setOnKeyPressed((KeyEvent event) -> {
            switch (event.getCode()){
                case UP:
                    texto.setTranslateY(texto.getTranslateY()-10);
                    break;
                case DOWN:
                    texto.setTranslateY(texto.getTranslateY()+10);
                    break;
                case LEFT:
                    texto.setTranslateX(texto.getTranslateX()-10);
                    break;
                case RIGHT:
                    texto.setTranslateX(texto.getTranslateX()+10);
                    break;
                default:
                    texto.setText(texto.getText()+event.getCode());
            }
        });
        
        Pane root = new Pane();
        root.getChildren().add(texto);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("DI_435_KeyEvent");
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
