/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

Autor: Marcos Gonzalez Leon
 */
package di_432_anonymousinnerclass;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author Marcos Gonzalez Leon
 */
public class DI_432_AnonymousInnerClass extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        // Creating Buttons.
        Button newbutton = new Button();
        newbutton.setText("New");
        newbutton.setId("New");
        newbutton.setOnAction(new sayNew());
        
        Button open = new Button();
        open.setText("Open");
        open.setId("Open");
        open.setOnAction(new sayOpen());
        
        Button save = new Button();
        save.setText("Save");
        save.setId("Save");
        save.setOnAction(new saySave());
        
        Button print = new Button();
        print.setText("Print");
        print.setId("Print");
        print.setOnAction(new sayPrint());
        
        // Creating HBox to contain buttons.
        HBox hbox = new HBox(8);
        hbox.getChildren().addAll(newbutton);
        hbox.getChildren().addAll(open);
        hbox.getChildren().addAll(save);
        hbox.getChildren().addAll(print);
        
        
        // Positioning Buttons and Circle.
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.add(hbox, 0, 0);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("AnonymousHandlerDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
    // EventHandlers.
    public class sayNew implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            System.out.println("Nuevo Proceso");
        }
        
    }
    
    public class sayOpen implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            System.out.println("Abrir Proceso");
        }
        
    }
    
    public class saySave implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            System.out.println("Guardar proceso");
        }
        
    }
    
    public class sayPrint implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            System.out.println("imprimir proceso");
        }
        
    }
    
}
