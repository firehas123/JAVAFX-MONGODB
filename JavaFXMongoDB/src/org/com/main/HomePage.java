package org.com.main;


import javafx.application.Application;  
import javafx.event.ActionEvent;  
import javafx.event.EventHandler;  
import javafx.scene.Scene;  
import javafx.scene.control.Button;  
import javafx.stage.Stage;  
import javafx.scene.layout.VBox;  

public class HomePage extends Application {
	//elements
	Button profile;
	Button calendar;
	Button courses;
	Button grades;
	VBox root;
	Stage window;
	@Override  
    public void start(Stage primaryStage) throws Exception {  
        // This is the home page
		//setting the scene
        new HomePage().setHomPageScene(primaryStage);   
    } 
	public void setHomPageScene(Stage primaryStage) throws Exception{
		//initializing the buttons
		profile=new Button("Profile");
        calendar=new Button("Calendar");
        courses=new Button("Courses");
        grades=new Button("Grades");
        //setting the scene
        root = new VBox();  
        root.setSpacing(15);
        root.getChildren().addAll(profile,calendar,courses,grades);
        Scene scene=new Scene(root,600,400);      
        primaryStage.setTitle("Home Page");  
        primaryStage.setScene(scene);  
        primaryStage.show();  
        //creating event handlers for all four buttons
        profile.setOnAction(new EventHandler<ActionEvent>() {  
            
            @Override  
            public void handle(ActionEvent arg0) {  
                Profile prof = new Profile();
                prof.setStage(primaryStage);
                primaryStage.setTitle("Profile");  
                try {
					primaryStage.setScene(prof.getScene());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
                primaryStage.show();    
            }  
        });  
        
        calendar.setOnAction(new EventHandler<ActionEvent>() {  
		            
		            @Override  
		            public void handle(ActionEvent arg0) {  
		                Calendar cal = new Calendar();
		                cal.setStage(primaryStage);
		                primaryStage.setTitle("Calendar");
		                primaryStage.setScene(cal.getScene());  
		                primaryStage.show();
		            }  
		        });  
        
        courses.setOnAction(new EventHandler<ActionEvent>() {  
		    
		    @Override  
		    public void handle(ActionEvent arg0) {  
		    	Courses cour = new Courses();
		    	cour.setStage(primaryStage);
                primaryStage.setTitle("Courses");
                primaryStage.setScene(cour.getScene());  
                primaryStage.show();
		    }  
		});  
        
        grades.setOnAction(new EventHandler<ActionEvent>() {  
		    
		    @Override  
		    public void handle(ActionEvent arg0) {  
		    	Grades grades = new Grades();
		    	grades.setStage(primaryStage);
                primaryStage.setTitle("Courses");
                primaryStage.setScene(grades.getScene());  
                primaryStage.show();  
		    }  
		});
	}
    public static void main (String[] args)  
    {   
        launch(args);  
    }  
}

