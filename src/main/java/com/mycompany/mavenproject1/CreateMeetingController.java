/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.mavenproject1.manager.CourseContext;
import com.mycompany.mavenproject1.manager.CourseManager;
import com.mycompany.mavenproject1.manager.MeetingManager;
import com.mycompany.mavenproject1.model.Course;
import com.mycompany.mavenproject1.model.Meeting;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author oskarp
 */
public class CreateMeetingController implements Initializable {

   @FXML
   private DatePicker datepicker;
   @FXML
   private Button submitButton;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        submitButton.setOnMouseClicked(new javafx.event.EventHandler<javafx.scene.input.MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                MeetingManager.getDatabase();
                LocalDate cal = datepicker.getValue();
                Course course = CourseContext.getCourse();
                MeetingManager.Create(course.getIdCourse(),cal );
                        switchScene(event);
                
                
                
               
                
                
                
                
            }
            
            
            
        });
    }
public void switchScene(javafx.scene.input.MouseEvent event){
        try{
            FXMLLoader loader;
            
                loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                
            
            
           
            
               
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
