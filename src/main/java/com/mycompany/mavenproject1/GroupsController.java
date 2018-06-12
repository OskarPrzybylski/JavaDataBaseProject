/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.mavenproject1.manager.CourseContext;
import com.mycompany.mavenproject1.manager.CourseManager;
import com.mycompany.mavenproject1.model.Course;
import java.io.IOException;
import java.net.URL;
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
public class GroupsController implements Initializable {
    @FXML 
    private ListView<String> listView;
    @FXML
    private Button createButton;
    
    
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      ObservableList<String> items = listView.getItems();
      CourseManager.getDatabase();
      ArrayList<Course> a = CourseManager.getAll();
      for(Course e : a){
            items.add("Course ID: " + e.getIdCourse() + " Course name: " + e.getDescription());
        }
      listView.setOnMouseClicked(new javafx.event.EventHandler<javafx.scene.input.MouseEvent>() {
             

             @Override
             public void handle(javafx.scene.input.MouseEvent event) {
                  if(listView.getSelectionModel().getSelectedItem()!=null){
                      switchScene(event,1);
                  }
                  
             }
           
           
       });
      createButton.setOnMouseClicked(new javafx.event.EventHandler<javafx.scene.input.MouseEvent>(){
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
                loader = new FXMLLoader(getClass().getResource("/fxml/CreateGroup.fxml"));
            }
            else{
                loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                
            
            
            String kk = listView.getSelectionModel().getSelectedItem();
            System.out.println(kk);
                 int id = Integer.parseInt(kk.substring(11, 12));
                 Course b = CourseManager.getById(id);
                 
                 CourseContext.setCourse(b.getIdCourse());
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
