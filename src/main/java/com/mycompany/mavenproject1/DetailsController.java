/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.mavenproject1.MainApp;
import com.mycompany.mavenproject1.manager.PersonContext;
import com.mycompany.mavenproject1.manager.PersonManager;
import com.mycompany.mavenproject1.model.Person;
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
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author oskarp
 */
public class DetailsController implements Initializable {

    private Person a;
    @FXML
    private Label information;
    @FXML
    private Button backButton;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        PersonManager.getDatabase();
        //Person a = PersonContext.getPerson();
        //System.out.println(a.getId() + "oto id");
        Person b = PersonContext.getPerson();
        information.setText("student id: " + b.getId() +
                "\nstudent name: " + b.getName() + 
                "\nstudent surname: " + b.getSurname() + 
                "\ncourse: " + b.getIdCourse());
        backButton.setOnMouseClicked(new javafx.event.EventHandler<javafx.scene.input.MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                switchScene(event);
            }
            
            
            
        });
        //lblTest.setText(a.toString());
        
        
       
        
        
    }
    public void switchScene(javafx.scene.input.MouseEvent event){
        try{
            
      
               FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
                 Parent home_page_parent =loader.load();
                 
                 
                 //System.out.println(id);
                 
                  //DetailsController controller;
                    //controller = loader.getController();
                    //controller.initdata(0);
                  Scene home_page_scene = new Scene(home_page_parent);
                  
                    Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    app_stage.setScene(home_page_scene);
                    app_stage.show();
                    
                  }
                  catch(IOException e){
                      
                  }
    
    }
   /* public void initdata(int id){
        PersonManager.getDatabase();
        a= PersonManager.getById(id);
    }*/
    
}
