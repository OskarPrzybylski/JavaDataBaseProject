/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.manager;

import com.mycompany.mavenproject1.model.Course;
import com.mycompany.mavenproject1.model.Person;

/**
 *
 * @author oskarp
 */
public class CourseContext {
     private static int id;
    
    public static void setCourse(int id){
        CourseContext.id=id;
       
        
    }
    
    
    public static Course getCourse(){
     
        Course  a = CourseManager.getById(id);
        return a;
    }
    
    
    
}
