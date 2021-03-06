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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Courses {
	Scene scene;
	Stage primaryStage;
	public Scene getScene() {
				// This is the Calendar page
				//creating respective elements
				ObservableList<String> names = getCourseList();
				ListView<String> listView = new ListView<String>(names);
				listView.setMaxSize(70, 40);
		        Button btn = new Button("Go Back");
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
		        //Initializing the elements
		        Label msgInfoBox = new Label("Info Box");
		        TextField showProfName = new TextField();
		        TextField courseName = new TextField();
		        TextField courseNum = new TextField();
		        //
		        listView.setOnMouseClicked(new EventHandler<MouseEvent>() {

			        @Override
			        public void handle(MouseEvent event) {
			            System.out.println("clicked on " + listView.getSelectionModel().getSelectedItem());
			           if(listView.getSelectionModel().getSelectedItem().equals("Computer")) {
			        	   showProfName.setText("Nauman");
			        	   courseName.setText("Computer");
			        	   courseNum.setText("1");
			           }else {
			        	   
			           }
			            
			        }
			    });
		        //
		        //setting up the scene
		        VBox root = new VBox();  
		        root.setSpacing(15);
		        root.getChildren().addAll(listView,msgInfoBox,showProfName,courseName,courseNum,btn);
		        Scene scene=new Scene(root,600,400);      
		        primaryStage.setTitle("Home Page");  
		        primaryStage.setScene(scene);  
		        primaryStage.show();    
		        return scene;
	}
	private ObservableList<String> getCourseList() {
		// TODO query database and return all courses
		ObservableList<String> names = FXCollections.observableArrayList("Computer");
		return names;
	}
	public void setStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
}
