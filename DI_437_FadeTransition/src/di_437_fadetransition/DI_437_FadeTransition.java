/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di_437_fadetransition;

import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Marcos Gonzalez Leon
 */
public class DI_437_FadeTransition extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        // Creating Ellipse and Formating Properties.
        Ellipse elipse = new Ellipse(20,20,100,80);      
        elipse.setFill(Color.RED);
        elipse.setStroke(Color.BLACK);
        
        // Applica una fade transition a elipse
        FadeTransition ft = new FadeTransition(Duration.millis(3000),elipse);
        ft.setFromValue(1.0);
        ft.setToValue(0.1);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        
        // Start animation
        ft.play();        
        
        // Control animation
        elipse.setOnMousePressed(e->ft.pause());
        elipse.setOnMouseReleased(e->ft.play());
        
        StackPane root = new StackPane();
        root.getChildren().add(elipse);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("FadeTransitionDemo");
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
