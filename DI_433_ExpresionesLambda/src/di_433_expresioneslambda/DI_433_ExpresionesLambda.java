/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

Autor: Marcos Gonzalez Leon
 */
package di_433_expresioneslambda;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author CRAMi
 */
public class DI_433_ExpresionesLambda extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        // Creating Labels, TextFields & Button Calculate.
        Label annual = new Label("Annual Interest Rate");
        Label years = new Label("Number of Years");
        Label amount = new Label("Loan Amount");
        Label monthlypayment = new Label("Monthly Payment");
        Label totalpayment = new Label("Total Payment");
        Label missingfield = new Label();   // Shows error if any of the fields are not filled correctly.
        
        TextField annual_text = new TextField();
        annual_text.setAlignment(Pos.CENTER_RIGHT);
        TextField years_text = new TextField();
        years_text.setAlignment(Pos.CENTER_RIGHT);
        TextField amount_text = new TextField();
        amount_text.setAlignment(Pos.CENTER_RIGHT);
        TextField monthlypayment_text = new TextField();
        monthlypayment_text.setAlignment(Pos.CENTER_RIGHT);
        TextField totalpayment_text = new TextField();
        totalpayment_text.setAlignment(Pos.CENTER_RIGHT);
        
        Button calculate = new Button("Calcular");
        
        // Lambda Expression that Comes from AnonymousInnerClass
        calculate.setOnAction((ActionEvent event) -> {            
            
            // Variables.
            double m_pay;       // Monthly Payment Result.
            double t_pay;       // Total Payment Result.
            
            // Check if fields input are correct.
            if (annual_text.getText().equals("") || years_text.equals("") || amount_text.equals("")){
                // Error.
                missingfield.setText("Rellene los campos.");
            } else {                
                // Parse Data Type.
                double interes_v = Double.parseDouble(annual_text.getText());
                int years_v = Integer.parseInt(years_text.getText());
                double amount_v = Double.parseDouble(amount_text.getText());            

                // Formula.
                t_pay = amount_v + ((interes_v/100) * amount_v);
                m_pay = t_pay / (years_v * 12);

                // Show Results.
                monthlypayment_text.setText(String.valueOf(m_pay)+" €");
                totalpayment_text.setText(String.valueOf(t_pay)+" €");            
            }
        });
        
        // Creating Grid and Panning.   
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(40,40,40,40));
        grid.setHgap(10);
        grid.setVgap(10);
        
        // Adding Text,Labels & Button on grid.
        grid.add(annual,0,1);
        grid.add(years,0,2);
        grid.add(amount,0,3);
        grid.add(monthlypayment,0,4);
        grid.add(totalpayment,0,5);
        grid.add(missingfield,0,6);
        
        grid.add(annual_text, 1, 1);
        grid.add(years_text, 1, 2);
        grid.add(amount_text, 1, 3);
        grid.add(monthlypayment_text, 1, 4);
        grid.add(totalpayment_text, 1, 5);
        
        grid.add(calculate, 1, 6);
        
        Scene scene = new Scene(grid, 400, 300);
        
        primaryStage.setTitle("Expresiones Lambda. ActionEvent");
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
