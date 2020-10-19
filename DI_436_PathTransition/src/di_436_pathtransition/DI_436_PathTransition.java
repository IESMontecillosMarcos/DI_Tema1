/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di_436_pathtransition;


import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Marcos Gonzalez Leon
 */
public class DI_436_PathTransition extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        // Creating and Formating Circle and Rectangle SHapes.
        Circle circulo = new Circle(20,20,80);
        circulo.setFill(null);
        circulo.setStroke(Color.BLACK);
        Rectangle rectangulo = new Rectangle(40,60);
        rectangulo.setFill(Color.ORANGE);
        
        // Create a path transition
        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(4000));
        pt.setPath(circulo);
        pt.setNode(rectangulo);
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setCycleCount(Timeline.INDEFINITE);
                
        pt.play();
        
        circulo.setOnMousePressed(e->pt.pause());        
        circulo.setOnMouseReleased(e->pt.play());
                
        StackPane root = new StackPane();
        root.getChildren().addAll(circulo,rectangulo);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("PathTransitionDemo");
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
