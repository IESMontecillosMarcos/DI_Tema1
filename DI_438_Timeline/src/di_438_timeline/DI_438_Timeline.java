/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di_438_timeline;

import com.sun.javafx.perf.PerformanceTracker;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Marcos Gonzalez Leon
 */
public class DI_438_Timeline extends Application {
    
    static public double speedX=1;
    static public double speedY=1;
    
    @Override
    public void start(Stage primaryStage) {
        
        // Creating Components and Formating.
        Circle bola = new Circle(20);        
        Label fps = new Label("FPS (Timeline) = ");
        fps.setTranslateX(-100);
        fps.setTranslateY(-100);
        
        StackPane root = new StackPane();
        root.getChildren().addAll(bola,fps);
        
        Scene scene = new Scene(root, 300, 300);
        
        
        //Escuchador a incluir en el bucle de Timeline
        EventHandler<ActionEvent> eH = e->{
            
            // Mostrar la frecuencia de refresco FPS
            PerformanceTracker perfTracker = PerformanceTracker.getSceneTracker(scene);
            
            fps.setText("FPS (Timeline) = "+perfTracker.getInstantFPS());
            
            // Cambiar la dirección de la bola si llega a los extremos Eje X.
            if(bola.getTranslateX()< -300 ||bola.getTranslateX()> 300){
            speedX *=-1;
            }
            bola.setTranslateX(bola.getTranslateX()+ speedX);
            
            
            // Cambiar la dirección de la bola si llega a los extremos Eje Y.
            if(bola.getTranslateY()< -250 ||bola.getTranslateY()> 250){
            speedY *=-1;
            }
            bola.setTranslateY(bola.getTranslateY()+ speedY);
        };

        Timeline animation = new Timeline(new KeyFrame(Duration.millis(5),eH));
        animation.setCycleCount(Timeline.INDEFINITE);
        
        // Start animation.
        animation.play();
        
        
        primaryStage.setTitle("Hello World!");
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
