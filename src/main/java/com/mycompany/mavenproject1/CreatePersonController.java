/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.mavenproject1.manager.CourseContext;
import com.mycompany.mavenproject1.manager.CourseManager;
import com.mycompany.mavenproject1.manager.PersonManager;
import com.mycompany.mavenproject1.model.Course;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author oskarp
 */
public class CreatePersonController implements Initializable {

    @FXML
    private TextField nameField;
    @FXML
    private TextField surnameField;
    @FXML
    private Button submitButton;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        submitButton.setOnMouseClicked(new javafx.event.EventHandler<javafx.scene.input.MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                Course course = CourseContext.getCourse();
                
                PersonManager.getDatabase();
                PersonManager.Create(nameField.getText(), surnameField.getText(), course.getIdCourse());
                switchScene(event);
            }
            
            
            
        });
    }
public void switchScene(javafx.scene.input.MouseEvent event){
        try{
            
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                
            
            
             
               
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
