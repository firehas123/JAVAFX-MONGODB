package org.com.main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Grades {
	Scene scene;
	Stage primaryStage;
	public Scene getScene() {
				// This is the Grades page
				//creating respective elements
		String ss;
				ObservableList<String> names = getCourseList();
				ListView<String> listView = new ListView<String>(names);
				listView.setMaxSize(100, 100);
		        Button btn = new Button("Go Back");
		        Button btn1 = new Button("Check Result");
		        //setting event handler
		        btn.setOnAction(new EventHandler<ActionEvent>() {  
				    
				    @Override  
				    public void handle(ActionEvent arg0) {  
				    	try {
							new HomePage().setHomPageScene(primaryStage);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				    }  
				});
		        //btn1
		        btn1.setOnAction(new EventHandler<ActionEvent>() {  
				    
				    @Override  
				    public void handle(ActionEvent arg0) {  
				    	ShowGrade grades = new ShowGrade();
				    	grades.setString(listView.getSelectionModel().getSelectedItem());
				    	grades.setStage(primaryStage);
		                primaryStage.setTitle("Show Grade");
		                primaryStage.setScene(grades.getScene());  
		                primaryStage.show();  
				    }  
				});
		   
		        //Initializing the elements
		        Label recentlyGraded = new Label("Recently Graded");
		        Label assignmentName = new Label("Assignment Name");
		        TextField courseName = new TextField();
		        
		        //
		        listView.setOnMouseClicked(new EventHandler<MouseEvent>() {

			        @Override
			        public void handle(MouseEvent event) {
			            System.out.println("clicked on " + listView.getSelectionModel().getSelectedItem());
			           if(listView.getSelectionModel().getSelectedItem().equals("final")) {
			        	   recentlyGraded.setText("Recently Graded: Nauman");
			        	   courseName.setText("Computer");
			        	   assignmentName.setText("final");
			        	   
			           }else {
			        	   recentlyGraded.setText("Recently Graded: Nauman");
			        	   courseName.setText("Computer");
			        	   assignmentName.setText("mid");
			        	   
			           }
			            
			        }
			    });
		        //
		        //setting up the scene
		        VBox rootPane = new VBox();  
		        VBox rootOne = new VBox();
		        VBox rootTwo = new VBox();  
		        HBox rootThree = new HBox();
		        rootOne.setSpacing(15);
		        rootTwo.setSpacing(15);
		        rootThree.setSpacing(450);
		        rootTwo.setStyle("-fx-padding: 10;" + 
	                      "-fx-border-style: solid inside;" + 
	                      "-fx-border-width: 2;" +
	                      "-fx-border-insets: 5;" + 
	                      "-fx-border-radius: 5;" + 
	                      "-fx-border-color: black;");
		        rootOne.getChildren().addAll(listView);
		        rootTwo.getChildren().addAll(courseName,recentlyGraded,assignmentName);
		        rootThree.getChildren().addAll(btn,btn1);
		        //adding all panes
		        rootPane.getChildren().addAll(rootOne,rootTwo,rootThree);
		        Scene scene=new Scene(rootPane,600,400);      
		        primaryStage.setTitle("Home Page");  
		        primaryStage.setScene(scene);  
		        primaryStage.show();    
		        return scene;
	}
	private ObservableList<String> getCourseList() {
		// TODO query database and return all courses
		ObservableList<String> names = FXCollections.observableArrayList("final","mid");
		return names;
	}
	public void setStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
}
