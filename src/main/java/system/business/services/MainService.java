/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package system.business.services;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import system.business.models.Subject;
import system.business.models.Teacher;

/**
 *
 * @author dennis
 */
public class MainService {
    private EntityManager em;
    private EntityTransaction et;
    
    
    @PostConstruct
    public void init(){
        this.em = (EntityManager)Persistence.createEntityManagerFactory("SchedulingSystemPU").createEntityManager();
        this.et = em.getTransaction();
    }
    
    public EntityManager getEM(){
        return this.em;
    }
    
    public EntityTransaction getET(){
        return this.et;
    }
    
    public List<Subject> getAllSubjects(){
        return this.em.createNamedQuery("Subjects.findAll").getResultList();
    }
    
    public void save(Subject subject){
        this.et.begin();
        Subject merged = em.merge(subject);
        this.et.commit();
    }
    
    public void delete(Subject subject){
        this.et.begin();
        this.em.remove(subject);
        this.et.commit();
    }
    
    
    public List<Teacher> getAllTeachers(){
        return this.em.createNamedQuery("Teacher.findAll").getResultList();
    }
    
    public void save(Teacher teacher){
        this.et.begin();
        Teacher merged = em.merge(teacher);
        this.et.commit();
    }
    
    public void delete(Teacher teacher){
        this.et.begin();
        this.em.remove(teacher);
        this.et.commit();
    }
    
    
}
