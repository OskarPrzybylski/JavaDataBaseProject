/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.manager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mycompany.mavenproject1.model.Course;
import com.mycompany.mavenproject1.model.Person;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author oskarp
 */
public class CourseManager {
    private static final String coursesFile = "courses.json";
    private static ArrayList<Course> courses = new ArrayList<Course>();
    
    public static void Create(int hours, String description){
        Course a = new Course();
        a.setHours(hours);
        a.setDescription(description);
        a.setCompletedHours(0);
        if(courses.isEmpty()){
            a.setIdCourse(0);
        }
        else{
            a.setIdCourse(courses.get(courses.size()-1).getIdCourse()+1);
        }
        courses.add(a);
        save();
    }
    
     private static void save(){
        Gson gson = new Gson();
        String example = gson.toJson(courses);
       
        
        
        try{
            PrintWriter writer = new PrintWriter(coursesFile, "UTF-8");
            writer.write(example);
            writer.close();
        }
        catch(Exception e){
            System.out.println("Write Person error");
        }
    }
     
     public static void getDatabase(){
        
        try{
            String content = new String(Files.readAllBytes(Paths.get(coursesFile)));
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<Course>>(){}.getType();
            courses = gson.fromJson(content, listType );
            
        }
        catch(Exception e){
            System.out.println("Read Person Error");
        }
        
    }
     
     public static ArrayList<Course> getAll(){
        return courses;
    }
     public static Course getById(int id){
         Course a = new Course();
        for(Course e : courses){
            if(e.getIdCourse()==id){
                return e;
            }
        }
        return a;
     }
     public static ArrayList<Person> getAllPersons(int id){
         ArrayList<Person> all = PersonManager.getAll();
         ArrayList<Person> notall = new ArrayList<Person>();
         for(Person a : all){
             if(a.getIdCourse()==id){
                 notall.add(a);
             }
         }
         return notall;
     }
    
    
    
    
    
}
