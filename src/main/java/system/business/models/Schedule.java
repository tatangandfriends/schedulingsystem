/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package system.business.models;

import java.io.Serializable;
import java.util.List;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author dennis
 */
@Entity
@NamedQueries({
@NamedQuery(name = "Schedule.findAll", query = "SELECT s FROM Schedule s"),
    @NamedQuery(name = "Schedule.findById", query = "SELECT s FROM Schedule s WHERE s.id = :id"),
    })
public class Schedule implements Serializable {
    
    private IntegerProperty id;
    private ObjectProperty<Teacher> teacher;
    private ObjectProperty<Student> student;
    private ObjectProperty<Room> room;
    private ListProperty<Subject> subjects;
    private ObjectProperty<Time> time;
    
    public Schedule(){
        this.id = new SimpleIntegerProperty();
        this.teacher = new SimpleObjectProperty<>();
        this.room = new SimpleObjectProperty<>();
        this.student = new SimpleObjectProperty<>();
        this.subjects = new SimpleListProperty<>();
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
        
    @ManyToOne
    @JoinColumn(name = "teacher")
     public Teacher getTeacher(){
         return this.teacher.get();
     }
     public void setTeacher(Teacher teacher){
     
         this.teacher.set(teacher);
     }
     
     @ManyToOne
     @JoinColumn(name = "student")
     public Student getStudent(){
         return this.student.get();
     }
     public void setStudent (Student student){
         this.student.set(student);
     }
    @ManyToOne
    @JoinColumn(name = "room")
    public Room getRoom(){
        return this.room.get();
    }  
    public void setRoom(Room room){
        this.room.set(room);
    }
    
    @OneToMany(mappedBy = "schedule")
    public List<Subject> getSubjects(){
        return this.subjects.get();
    }
    public void setSubjects(List<Subject> subjects){
        ObservableList<Subject> subject = FXCollections.observableArrayList(subjects);
        this.subjects.set(subject);
    }
    
    @ManyToOne
    public Time getTime(){
        return this.time.get();
    }
    public void setTime(Time time){
        this.time.set(time);
    }
     
}
