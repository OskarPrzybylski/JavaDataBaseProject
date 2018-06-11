/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.model;

/**
 *
 * @author oskarp
 */
public class Grade {
    
    private float grade;
    private boolean toAverage;
    private int idTest;
    private int idPerson;

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public boolean isToAverage() {
        return toAverage;
    }
    public void setToAverage(boolean toAverage){
        this.toAverage=toAverage;
    }
}
