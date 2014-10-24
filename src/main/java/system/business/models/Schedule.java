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
import javax.persistence.OneToOne;
import system.business.models.enums.Days;


/**
 *
 * @author dennis
 */
@Entity
public class Schedule implements Serializable {
    
    private IntegerProperty id;
    private Days day;
    private ObjectProperty<Teacher> teacher;
    private ObjectProperty<Room> room;
    private ObjectProperty<Subject> subject;
    private ObjectProperty<TimeType> time;
    private ObjectProperty<Schedule> schedule;
    
    public Schedule(){
        this.id = new SimpleIntegerProperty();
        this.teacher = new SimpleObjectProperty<>();
        this.room = new SimpleObjectProperty<>();
        this.subject = new SimpleObjectProperty<>();
        this.time = new SimpleObjectProperty<>();
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
    @JoinColumn(name="schedule_id")
    public Schedule getSchedule(){
        return this.schedule.get();
    }
    public void setSchedule(Schedule schedule){
        this.schedule.set(schedule);
    }
}
