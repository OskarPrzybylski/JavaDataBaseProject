package com.mycompany.mavenproject1;

import com.mycompany.mavenproject1.manager.CourseContext;
import com.mycompany.mavenproject1.manager.CourseManager;
import com.mycompany.mavenproject1.manager.PersonContext;
import com.mycompany.mavenproject1.manager.PersonManager;
import com.mycompany.mavenproject1.model.Course;
import com.mycompany.mavenproject1.model.Person;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FXMLController implements Initializable {
    
   // @FXML
   // private Label label;
    @FXML 
    private ListView<String> listView;
     @FXML
    private Button backButton;
     @FXML
     private Label inflabel;
     @FXML
     private Label hourslabel;
     @FXML
    private Button createMeeting;
     @FXML
     private Button checkMeetingsButton;
    
   
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         ObservableList<String> items = listView.getItems();
         PersonManager.getDatabase();
         
         
        ArrayList<Person> a = PersonManager.getAll();
        Course b = CourseContext.getCourse();
        inflabel.setText("Students in Course: " + b.getDescription());
        hourslabel.setText("Hours in Course: " + b.getHours() + "\nCompleted hours: " + b.getCompletedHours());
        
        for(Person e : a){
            if(e.getIdCourse()==b.getIdCourse()){
                items.add(e.toString());
            }
            
        }
       listView.setOnMouseClicked(new javafx.event.EventHandler<javafx.scene.input.MouseEvent>() {
             

             @Override
             public void handle(javafx.scene.input.MouseEvent event) {
                  
                  switchScene(event,1);
             }
           
           
       });
       backButton.setOnMouseClicked(new javafx.event.EventHandler<javafx.scene.input.MouseEvent>(){
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                switchScene(event,0);
            }
            
            
            
        });
       createMeeting.setOnMouseClicked(new javafx.event.EventHandler<javafx.scene.input.MouseEvent>(){
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                
                switchScene(event, 2);
            }
            
            
            
        });
        checkMeetingsButton.setOnMouseClicked(new javafx.event.EventHandler<javafx.scene.input.MouseEvent>(){
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                
                switchScene(event, 3);
            }
            
            
            
        });
       
       
       
         
    }
    public void switchScene(javafx.scene.input.MouseEvent event, int choice){
        try{
            FXMLLoader loader;
            if(choice==0){
                loader = new FXMLLoader(getClass().getResource("/fxml/Groups.fxml"));
                 
            }
            else if(choice==2){
                loader = new FXMLLoader(getClass().getResource("/fxml/CreateMeeting.fxml"));
            }
            else if(choice==3){
                loader = new FXMLLoader(getClass().getResource("/fxml/CheckMeetings.fxml"));
            }
            else{
                loader = new FXMLLoader(getClass().getResource("/fxml/Details.fxml"));
                String kk = listView.getSelectionModel().getSelectedItem();
                 int id = Integer.parseInt(kk.substring(0, 1));
                 System.out.println(id);
                 Person b = PersonManager.getById(id);
                 //System.out.println(b.toString());
                 //System.out.println(b.getIdCourse());
                 PersonContext.setPerson(b.getId());
            }
            
            
             
      
                 Parent home_page_parent =loader.load();
                 Scene home_page_scene = new Scene(home_page_parent);
                  
                    Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    app_stage.setScene(home_page_scene);
                    app_stage.show();
                    
                  }
                  catch(IOException e){
                      
                  }
    
    }
 
}
