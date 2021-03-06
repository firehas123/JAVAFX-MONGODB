package org.com.main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Profile{
	Scene scene;
	Stage primaryStage;
	public Scene getScene()  throws Exception{
				// This is the profile page
				//creating respective elements
		        Label name = new Label("Name:");
		        Label email = new Label("Email:");
		        Label phoneN = new Label("Phone Number:");
		        Label stid = new Label("Student ID:");
		        TextField showName = new TextField();
		        TextField showEmail = new TextField();
		        TextField showPhoneN = new TextField();
		        TextField showStid = new TextField();
		        getData(showName,showEmail,showPhoneN,showStid);
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
		        //setting the scene
		        GridPane root=new GridPane(); 
		        root.addRow(0, name,showName);  
		        root.addRow(1, email,showEmail);  
		        root.addRow(2, phoneN,showPhoneN);
		        root.addRow(3, stid, showStid);
		        root.addRow(4,btn);
		        scene=new Scene(root,600,400);  
		        return scene;
	}
	
	private void getData(TextField showName, TextField showEmail, TextField showPhoneN, TextField showStid) throws Exception{
		// TODO Auto-generated method stub
		
		
		showName.setText("Hassan");
		showEmail.setText("abc@gmail.com");
		showPhoneN.setText("123456");
		showStid.setText("1");
	}

	public void setStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
}
