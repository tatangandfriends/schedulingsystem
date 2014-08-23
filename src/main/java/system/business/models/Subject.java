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
import javafx.collections.ObservableList;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author dennis
 */
@Entity
public class Subject implements Serializable {
    
    private IntegerProperty id;
    private StringProperty subjDesc;
    private StringProperty subjCode;
    private IntegerProperty unit;    
    private ObjectProperty<Student> student;
    private ObjectProperty<Teacher> teacher;
    private ObjectProperty<Schedule> schedule;
    private ObjectProperty<Course> course; 
   
    
  //private StringProperty ;
    
    public Subject(){
        this.id = new SimpleIntegerProperty();
        this.subjDesc = new SimpleStringProperty();
        this.subjCode = new SimpleStringProperty();
        this.unit = new SimpleIntegerProperty();
        this.teacher = new SimpleObjectProperty<>();
        this.student = new SimpleObjectProperty<>();
        this.schedule = new SimpleObjectProperty<>();
        
    }
    
    public Subject(int id, String subjName, String subjCode, int unit){
        this();
        this.subjDesc.set(subjName);
        this.subjCode.set(subjCode);
        this.unit.set(unit);
        
    }
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId(){
        return this.id.get();
    }
    public void setId(int id){
        this.id.set(id);
    }
    @Column (name = "subject_name")
    public String getSubjName(){
        return this.subjDesc.get();
    }
     public void setSubjName(String subjDesc){
        this.subjDesc.set(subjDesc);
    }
    @Column (name = "subject_Code")
    public String getSubjCode(){
        return this.subjCode.get();
    }
     public void setSubjCode(String subjCode){
        this.subjCode.set(subjCode);
    }
    @Column(name = "column")
    public int getUnit(){
        return this.unit.get();
    }
    public void setUnit(int unit){
        this.id.set(unit);
    }
     
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "schedule")
    public Schedule getSchedule(){
        return this.schedule.get();
    }
    public void setSchedule(Schedule schedule){
        this.schedule.set(schedule);
    }
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course")
    public Course getCourse(){
        return this.course.get();
    }
    public void setCourse(Course course){
        this.course.set(course);
    }
   
}

