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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

public class Calendar {
	Scene scene;
	Stage primaryStage;
	public Scene getScene() {
				// This is the Calendar page
				//creating respective elements
				ObservableList<String> names = getDueDateList();
				ListView<String> listView = new ListView<String>(names);
				listView.setMaxSize(100, 100);
				
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
		        TextField showInfo = new TextField();
		        //
		        listView.setOnMouseClicked(new EventHandler<MouseEvent>() {

			        @Override
			        public void handle(MouseEvent event) {
			            System.out.println("clicked on " + listView.getSelectionModel().getSelectedItem());
			           if(listView.getSelectionModel().getSelectedItem().equals("22/03/2022")) {
			        	   showInfo.setText("Due Date: 22/03/2022 - Computer Mid");
			           }else {
			        	   showInfo.setText("Due Date: 03/03/2022 - Computer Final");
			           }
			            
			        }
			    });
		        //
		        //setting up the scene
		        VBox root = new VBox();  
		        root.setSpacing(15);
		        root.getChildren().addAll(listView,msgInfoBox,showInfo,btn);
		        Scene scene=new Scene(root,600,400);      
		        primaryStage.setTitle("Home Page");  
		        primaryStage.setScene(scene);  
		        primaryStage.show();    
		        return scene;
	}
	private ObservableList<String> getDueDateList() {
		// TODO query database and return all due dates
		ObservableList<String> names = FXCollections.observableArrayList("22/03/2022","03/03/2022");;
		//names.addAll(new DB().getCalendar());
		
		return names;
	}
	public void setStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
}
