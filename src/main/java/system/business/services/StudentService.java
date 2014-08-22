/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package system.business.services;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import system.business.models.Student;

/**
 *
 * @author Telafas
 */
public class StudentService {
    
    EntityManager em;
    EntityTransaction et;
        
    @PostConstruct
    public void init(){
        this.em = Persistence.createEntityManagerFactory("SchedulingSystemPU").createEntityManager();
        this.et = em.getTransaction();
    }
    
    public void save(Student s){
        et.begin();
        Student merged = em.merge(s);
        et.commit();
    }
    
}
