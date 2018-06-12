/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.mavenproject1.manager.CourseContext;
import com.mycompany.mavenproject1.manager.CourseManager;
import com.mycompany.mavenproject1.manager.MeetingContext;
import com.mycompany.mavenproject1.manager.MeetingManager;
import com.mycompany.mavenproject1.manager.PersonContext;
import com.mycompany.mavenproject1.manager.PersonManager;
import com.mycompany.mavenproject1.model.Course;
import com.mycompany.mavenproject1.model.Meeting;
import com.mycompany.mavenproject1.model.Person;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author oskarp
 */
public class MeetingInformationController implements Initializable {
    private ObservableList<String> items;
   @FXML 
    private ListView<String> listView;
    @FXML
    private Button backButton;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         items = listView.getItems();
            MeetingManager.getDatabase();
            Meeting meeting = MeetingContext.getMeeting();
            int loop=0;
            
           Course course = CourseContext.getCourse();
            ArrayList<Person> all = CourseManager.getAllPersons(course.getIdCourse());
            
            if(meeting.getRealized()==1){
                
            
            for(Person e : all){
                for(Person a : meeting.getPresent()){
                    if(e.getId()==a.getId()){
                        items.add(e.toString() + " was on meeting");
                        loop=1;
                    }
                }
                if(loop==0){
                    items.add(e.toString() + " was not on meeting");
                    
                }
                loop=0;
                
            }
            }
            else{
                for(Person e : all){
                    items.add(e.toString());
                }
            }
            
            
            
     listView.setOnMouseClicked(new javafx.event.EventHandler<javafx.scene.input.MouseEvent>() {
             

             @Override
             public void handle(javafx.scene.input.MouseEvent event) {
                 if(listView.getSelectionModel().getSelectedItem()!=null){
                  MeetingManager.getDatabase();
                  String kk = listView.getSelectionModel().getSelectedItem();
                 int id = Integer.parseInt(kk.substring(0, 1));
                 Person b = PersonManager.getById(id);
                  Meeting meeting = MeetingContext.getMeeting();
                  int i=0;
                  int indeks=0;
                  for(String e : items){
                      if(e.substring(0, 1).equals(kk.substring(0,1))){
                          indeks=i;
                      }
                      i++;
                  }
                  
                  int loop=0;
                  i=0;
                  
  
                  for(Person e : meeting.getPresent()){
                     
                      if(e.getId()==b.getId()){
                          
                         items.set(indeks, b.toString() + " was not on meeting");
                         MeetingManager.RemovePresent(b, meeting.getMeetingId());
                         loop=1;
                      }
                      
                      
                  }
                  
                  if(loop==0){
                          items.set(indeks, b.toString() + " was on meeting");
                          MeetingManager.AddPresent(b, meeting.getMeetingId());
                          loop=0;
                      }
                  
                 
                
                 
                 
                 
                  
                 } 
             }
           
           
       }); 
     backButton.setOnMouseClicked(new javafx.event.EventHandler<javafx.scene.input.MouseEvent>(){
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                switchScene(event);
            }
            
            
            
        });
    }
     public void switchScene(javafx.scene.input.MouseEvent event){
        try{
            FXMLLoader loader;
            
                loader = new FXMLLoader(getClass().getResource("/fxml/CheckMeetings.fxml"));
                
            
            
             
      
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
