/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package system.business.models;

import java.io.Serializable;
import javafx.beans.property.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import system.business.models.enums.Days;


/**
 *
 * @author dennis
 */
@Entity
@NamedQueries({
@NamedQuery(name = "Schedule.findAll", query = "SELECT r FROM Schedule r")})
public class Schedule implements Serializable {
    
    private IntegerProperty id;
    private Days day;
    private ObjectProperty<Teacher> teacher;
    private ObjectProperty<Room> room;
    private ObjectProperty<Subject> subject;
    private ObjectProperty<TimeType> time;
    private ObjectProperty<ClassSection> section;
    public Schedule(){
        this.id = new SimpleIntegerProperty();
        this.teacher = new SimpleObjectProperty<>();
        this.room = new SimpleObjectProperty<>();
        this.subject = new SimpleObjectProperty<>();
        this.time = new SimpleObjectProperty<>();
        this.section = new SimpleObjectProperty<>();
    }

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    public int getId() {
        return this.id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }
        
    @OneToOne
    @JoinColumn(name = "teacher_id")
     public Teacher getTeacher(){
         return this.teacher.get();
     }
     public void setTeacher(Teacher teacher){
     
         this.teacher.set(teacher);
     }

    @OneToOne
    @JoinColumn(name = "room_id")
    public Room getRoom(){
        return this.room.get();
    }  
    public void setRoom(Room room){
        this.room.set(room);
    }
    
    @OneToOne
    @JoinColumn(name="time_id")
    public TimeType getTime(){
        return this.time.get();
    }
    public void setTime(TimeType time){
        this.time.set(time);
    }
    
    @Column(name = "days")
    @Enumerated(EnumType.STRING)
    public Days getDay(){
        return day;
    }
    
    public void setDay(Days day){
        this.day = day;
    }
    
    @OneToOne
    @JoinColumn(name="section")
    public ClassSection getSection(){
        return this.section.get();
    }
    
    public void setSection(ClassSection section){
        this.section.set(section);
    }
    
    @OneToOne
    @JoinColumn(name="subject")
    public Subject getSubject(){
       return this.subject.get();
    }
    
    public void setSubject(Subject subject){
        this.subject.set(subject);
    }
    
    
    
}
