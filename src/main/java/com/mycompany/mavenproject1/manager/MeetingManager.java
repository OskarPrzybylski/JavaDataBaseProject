/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.manager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mycompany.mavenproject1.model.Course;
import com.mycompany.mavenproject1.model.Meeting;
import com.mycompany.mavenproject1.model.Person;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author oskarp
 */
public class MeetingManager {
    private static final String meetingsFile = "meetings.json";
    private static ArrayList<Meeting> meetings = new ArrayList<Meeting>();
    
     public static void save(){
        Gson gson = new Gson();
        String example = gson.toJson(meetings);
       
        
        
        try{
            PrintWriter writer = new PrintWriter(meetingsFile, "UTF-8");
            writer.write(example);
            writer.close();
        }
        catch(Exception e){
            System.out.println("Write Person error");
        }
    }
     public static void getDatabase(){
        
        try{
            String content = new String(Files.readAllBytes(Paths.get(meetingsFile)));
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<Meeting>>(){}.getType();
            meetings = gson.fromJson(content, listType );
            
        }
        catch(Exception e){
            System.out.println("Read Person Error");
        }
        
    }
     public static void Create(int idCourse, LocalDate date){
         
         Meeting a = new Meeting();
         a.setIdCourse(idCourse);
         a.setDate(date);
         a.setHomework(null);
         Course course = CourseContext.getCourse();
         CourseManager.updateRealizedHours(course.getIdCourse());
         a.setPresent(null);
         a.setRealized(0);
          if(meetings.isEmpty()){
            a.setMeetingId(0);
        }
        else{
            a.setMeetingId(meetings.get(meetings.size()-1).getMeetingId()+1);
          }
         meetings.add(a);
         save();
         
         
     }
     public static Meeting getByDate(LocalDate date){
         Meeting a = new Meeting();
         for(Meeting e : meetings){
             if(e.getDate().equals(date)){
                 return e;
             }
         }
         return a;
     }
     public static ArrayList<Meeting> getByIdCourse(int idCourse){
         ArrayList<Meeting> a = new ArrayList<Meeting>();
         for(Meeting e : meetings){
             if(e.getIdCourse()==idCourse){
                 a.add(e);
             }
         }
         return a;
     }
     public static Meeting getByIdMeeting(int id){
         Meeting a = new Meeting();
         for(Meeting e : meetings){
             if(e.getMeetingId()==id){
                 System.out.println("hehehhe");
                 a=e;
                 return a;
             }
         }
         return a;
     }
     public static void AddPresent(Person person, int id){
         
         int i=0;
         int indeks=0;
         for(Meeting e : meetings){
             if(e.getMeetingId()==id){
                 indeks=i;
             }
             i++;
         }
         
         
         ArrayList<Person> list = meetings.get(indeks).getPresent();
         list.add(person);
         Meeting test = meetings.get(indeks);
         test.setPresent(list);
         test.setRealized(1);
         
         meetings.set(indeks, test);
         save();
         
         
     }
     public static void RemovePresent(Person person, int id){
         int i=0;
         int indeks=0;
         int indeks2=0;
         for(Meeting e : meetings){
             if(e.getMeetingId()==id){
                 indeks=i;
             }
             i++;
         }
         ArrayList<Person> list = meetings.get(indeks).getPresent();
         i=0;
         for(Person e : list){
             if(e.getId()==person.getId()){
                 indeks2=i;
             }
             i++;
         }
         list.remove(indeks2);
         Meeting test = meetings.get(indeks);
         test.setPresent(list);
         meetings.set(indeks, test);
         save();
         
     }
     public static ArrayList<Person> returnPresent(int id){
         return getByIdMeeting(id).getPresent();
     }
}
