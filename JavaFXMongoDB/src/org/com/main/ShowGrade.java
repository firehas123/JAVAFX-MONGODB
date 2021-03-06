package org.com.main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ShowGrade {
	Scene scene;
	Stage primaryStage;
	String temp;
	ShowGrade(){
		
	}
	public void setString (String s){
		this.temp= s;
	}
	public Scene getScene() {
				// This is the Calendar page
				//creating respective elements
		        Button btn = new Button("Go Back");
		        //setting event handler
		        btn.setOnAction(new EventHandler<ActionEvent>() {  
				    
				    @Override  
				    public void handle(ActionEvent arg0) {  
				    	Grades grades = new Grades();
				    	grades.setStage(primaryStage);
		                primaryStage.setTitle("Grades");
		                primaryStage.setScene(grades.getScene());  
		                primaryStage.show();  
				    }  
				});
		        //Initializing the elements
		        Label myGrades = new Label("My Grade");
		        Label weightedTotal = new Label("Weighted Total: ");
		        TextField showWeightedTotal = new TextField();
		        Label midTerm = new Label("MidTerm: ");
		        TextField showMidterm = new TextField();
		        Label Final = new Label("Final: ");
		        TextField showFinal = new TextField();
		        if(temp.equals("final")) {
		        	showWeightedTotal.setText("40");
		        	showMidterm.setText("50");
		        	showFinal.setText("50");
		        }
		        else {
		        	//mid
		        	showWeightedTotal.setText("20");
		        	showMidterm.setText("30");
		        	showFinal.setText("40");
		        }
		        //setting up the scene
		        VBox rootPane = new VBox();  
		        VBox rootOne = new VBox();
		        GridPane rootTwo=new GridPane();   
		        HBox rootThree = new HBox();
		        rootOne.setSpacing(15);
		      
		        rootThree.setSpacing(450);
		        rootTwo.setStyle("-fx-padding: 10;" + 
	                      "-fx-border-style: solid inside;" + 
	                      "-fx-border-width: 2;" +
	                      "-fx-border-insets: 5;" + 
	                      "-fx-border-radius: 5;" + 
	                      "-fx-border-color: black;");
		        rootOne.getChildren().addAll(myGrades);
		        rootTwo.addRow(0, weightedTotal,showWeightedTotal); 
		        rootTwo.addRow(1, midTerm,showMidterm);
		        rootTwo.addRow(2, Final,showFinal);
		        rootThree.getChildren().addAll(btn);
		        //adding all panes
		        rootPane.getChildren().addAll(rootOne,rootTwo,rootThree);
		        Scene scene=new Scene(rootPane,600,400);      
		        primaryStage.setTitle("Home Page");  
		        primaryStage.setScene(scene);  
		        primaryStage.show();    
		        return scene;
	}
	public void setStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
}
