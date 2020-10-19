/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di_4.pkg3.pkg1_innerclass;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Marcos Gonzalez Leon
 */
public class DI_431_InnerClass extends Application {  
    
    // Creating Circle.
    Circle circulo = new Circle();
    
        
    @Override
    public void start(Stage primaryStage) {
        
        // Format Circle.
        circulo.setCenterX(100.0f);
        circulo.setCenterY(100.0f);
        circulo.setRadius(100.0f);
        circulo.setFill(null);
        circulo.setStroke(Color.BLACK);
        
        // Creating Buttons and Format.
        Button boton1 = new Button();
        boton1.setText("Enlarge");
        boton1.setOnAction(new enlarge());
        
        
        // Creating HBox to contain Buttons and Circles.
        VBox vbox = new VBox(circulo);
        Button boton2 = new Button();
        boton2.setText("Shrink");
        boton2.setOnAction(new shrink());
        
        // Adding Buttons to HBox.
        HBox hb1 = new HBox(4);       
        hb1.getChildren().add(boton1);
        hb1.getChildren().add(boton2);
       
        
        // Positioning of BorderPane Components.
        GridPane root = new GridPane();
        
        //root.getChildren().add(vbox);
        root.setAlignment(Pos.CENTER);
        root.setHgap(5);
        root.setVgap(5);
        
        //root.getChildren().add(hb1);
        root.add(vbox,1,0);
        root.add(boton1, 0, 2);
        root.add(boton2, 2, 2);
        
        
        Scene scene = new Scene(root, 600, 600);       
        primaryStage.setTitle("DI_431_InnerClass");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public class enlarge implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            circulo.setRadius(circulo.getRadius()+10);
        }
        
    }
    
    public class shrink implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            circulo.setRadius(circulo.getRadius()-10);
        }
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
