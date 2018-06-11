/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.manager;

import com.mycompany.mavenproject1.model.Meeting;
import com.mycompany.mavenproject1.model.Person;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author oskarp
 */
public class MeetingContext {
    private static int idCourse;
    private static int idMeeting;
    
    public static void setIdCourse(int id){
        MeetingContext.idCourse=id;
      
        
    }
    
    
    public static Meeting getMeeting(){
      
       Meeting a = MeetingManager.getByIdMeeting(idMeeting);
        
        return a;
    }
    public static void setIdMeeting(int i){
        MeetingContext.idMeeting=i;
        
    }
    public static ArrayList<Meeting> getMeetings(){
        ArrayList<Meeting> a = MeetingManager.getByIdCourse(idCourse);
        return a;
    }
}
