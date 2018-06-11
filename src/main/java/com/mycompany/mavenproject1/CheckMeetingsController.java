/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.mavenproject1.manager.CourseContext;
import com.mycompany.mavenproject1.manager.CourseManager;
import com.mycompany.mavenproject1.manager.MeetingContext;
import com.mycompany.mavenproject1.manager.MeetingManager;
import com.mycompany.mavenproject1.model.Course;
import com.mycompany.mavenproject1.model.Meeting;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author oskarp
 */
public class CheckMeetingsController implements Initializable {

    @FXML 
    private ListView<String> listView;
    @FXML
    private Button backButton;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ObservableList<String> items = listView.getItems();
        MeetingManager.getDatabase();
        String inf = "not realized yet";
        Course course = CourseContext.getCourse();
      ArrayList<Meeting> a = MeetingManager.getByIdCourse(course.getIdCourse());
      for(Meeting e : a){
          if(e.getRealized()==1){
              inf=" is realized";
          }
            
            items.add(e.getMeetingId() + e.getDate().toString() + " " + inf);
            inf= " not realized yet";
        }
        listView.setOnMouseClicked(new javafx.event.EventHandler<javafx.scene.input.MouseEvent>() {
             

             @Override
             public void handle(javafx.scene.input.MouseEvent event) {
                 String kk = listView.getSelectionModel().getSelectedItem();
                 String k = kk.substring(0, 1);
                 System.out.println(k);
             
              int indeks = Integer.parseInt(k);
                 
                 MeetingContext.setIdMeeting(indeks);
                 
                 
                  
                  switchScene(event,1);
             }
        });
        backButton.setOnMouseClicked(new javafx.event.EventHandler<javafx.scene.input.MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                switchScene(event, 0);
            }
            
            
            
        });
    }    
 
    public void switchScene(javafx.scene.input.MouseEvent event, int choise){
        try{
            FXMLLoader loader;
            if(choise==0){
                loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
            }
            else{
                loader = new FXMLLoader(getClass().getResource("/fxml/MeetingInformation.fxml"));
                
            
            
            
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
