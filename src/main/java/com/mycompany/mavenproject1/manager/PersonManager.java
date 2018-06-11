/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.manager;

import com.google.gson.Gson;
import com.mycompany.mavenproject1.model.Person;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.Map;



/**
 *
 * @author oskarp
 */
public class PersonManager {
    
    private static final String personsFile = "persons.json";
    private static ArrayList<Person> persons = new ArrayList<Person>();
    
    public static void Create(String name, String surname, int idCourse){
        
        
        
        Person a = new Person();
        a.setName(name);
        a.setSurname(surname);
        if(persons.isEmpty()){
            a.setId(0);
        }
        else{
            
            a.setId(persons.get(persons.size()-1).getId() + 1);
        }
        
        
        
        a.setIdCourse(idCourse);
        
        
        persons.add(a);
        
        save();
        
        
        
        
        
    }
    private static void save(){
        Gson gson = new Gson();
        String example = gson.toJson(persons);
       
        
        
        try{
            PrintWriter writer = new PrintWriter(personsFile, "UTF-8");
            writer.write(example);
            writer.close();
        }
        catch(Exception e){
            System.out.println("Write Person error");
        }
    }
    public static void getDatabase(){
        
        try{
            String content = new String(Files.readAllBytes(Paths.get(personsFile)));
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<Person>>(){}.getType();
            persons = gson.fromJson(content, listType );
            
        }
        catch(Exception e){
            System.out.println("Read Person Error");
        }
        
    }
    public static ArrayList<Person> getAll(){
        return persons;
    }
    public static Person getById(int id){
        return persons.get(id);
    }
    public static ArrayList<Person> getByIdCourse(int id){
        ArrayList<Person> a = new ArrayList<>();
        for(Person e : persons){
            if(e.getIdCourse()==id){
                a.add(e);
            }
        }
        return a;
    }
    public static ArrayList<Person> getByName(String name){
        ArrayList<Person> a = new ArrayList<>();
        for(Person e : persons){
            if(e.toString().equals(name)){
                a.add(e);
            }
        }
        return a;
    }
    public static void deletePerson(int id){
        for(Person e : persons){
        if(e.getId()==id){
            persons.remove(e);
        }
    }
        save();
        
    }
    
}
