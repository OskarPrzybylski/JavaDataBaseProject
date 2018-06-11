/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.manager;

import com.mycompany.mavenproject1.model.Person;
import java.util.ArrayList;

/**
 *
 * @author oskarp
 */
public class PersonContext {
    private static int id;
    
    public static void setPerson(int id){
        PersonContext.id=id;
        System.out.println(id + "oto jest w personcontexcie");
        
    }
    
    
    public static Person getPerson(){
        System.out.println(id + "oto jest w personcontexcie przy get");
        Person  a = PersonManager.getById(id);
        System.out.println(a.toString());
        return a;
    }
    
}
