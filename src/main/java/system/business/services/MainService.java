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
import system.business.models.ClassSection;
import system.business.models.Room;
import system.business.models.Schedule;
import system.business.models.Subject;
import system.business.models.Teacher;
import system.business.models.TimeType;

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
    
    public List<Schedule> getAllSchedules(){
        return this.em.createNamedQuery("Schedule.findAll").getResultList();
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
    
    public List<ClassSection> getAllSection(){
        return this.em.createNamedQuery("ClassSection.findAll").getResultList();
    }
    
    public void save(ClassSection classSection){
        this.et.begin();
        ClassSection merged = em.merge(classSection);
        this.et.commit();
    }
    
    public void delete(ClassSection classSection){
        this.et.begin();
        this.em.remove(classSection);
        this.et.commit();
    }
    
    public List<Room> getAllRooms(){
        return this.em.createNamedQuery("Room.findAll").getResultList();
    }
    
    public void save(Room room){
        this.et.begin();
        Room merged = em.merge(room);
        this.et.commit();
    }
    
    public void delete(Room room){
        this.et.begin();
        this.em.remove(room);
        this.et.commit();
    }
    
    public List<TimeType> getAllTime(){
        return this.em.createNamedQuery("TimeType.findAll").getResultList();
    }
    
    public void save(TimeType timeType){
        this.et.begin();
        TimeType merged = em.merge(timeType);
        this.et.commit();
    }
    
    public void delete(TimeType timeType){
        this.et.begin();
        this.em.remove(timeType);
        this.et.commit();
    }
    
}
