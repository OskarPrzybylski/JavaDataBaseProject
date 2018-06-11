/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;


/**
 *
 * @author oskarp
 */
public class Meeting {
    private int idCourse;
    private LocalDate date;
    private ArrayList<Person> present = new ArrayList<Person>();
    private int realized;
    private String homework;
    private int MeetingId;

    public int getMeetingId() {
        return MeetingId;
    }

    public void setMeetingId(int MeetingId) {
        this.MeetingId = MeetingId;
    }

    public int getRealized() {
        return realized;
    }

    public void setRealized(int realized) {
        this.realized = realized;
    }

    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ArrayList<Person> getPresent() {
        return present;
    }

    public void setPresent(ArrayList<Person> present) {
        this.present = present;
    }

    public String getHomework() {
        return homework;
    }

    public void setHomework(String homework) {
        this.homework = homework;
    }
    
    
}
