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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author dennis
 */
@Entity
@Table(name="subject")
@NamedQueries({
@NamedQuery(name = "Subject.findAll", query = "SELECT s FROM Subject s"),
    @NamedQuery(name = "Subject.findById", query = "SELECT s FROM Subject s WHERE s.id = :id"),
    @NamedQuery(name = "Subject.findBySubCode", query = "SELECT s FROM Subject s WHERE s.subCode = :subCode")
    
   })
public class Subject implements Serializable {
    
    private IntegerProperty id;
    private StringProperty subDesc;
    private StringProperty subCode;
    private StringProperty Unit;    
    private ObjectProperty<Student> student;
    private ObjectProperty<Teacher> teacher;
    private ObjectProperty<Schedule> schedule;
    private ObjectProperty<Course> course; 
    private ObjectProperty<Section> section;
   
    
  //private StringProperty ;
    
    public Subject(){
        this.id = new SimpleIntegerProperty();
        this.subDesc = new SimpleStringProperty();
        this.subCode = new SimpleStringProperty();
        this.Unit = new SimpleStringProperty();
        this.teacher = new SimpleObjectProperty<>();
        this.student = new SimpleObjectProperty<>();
        this.schedule = new SimpleObjectProperty<>();
        this.section = new SimpleObjectProperty<>();
        
    }
    
    public Subject(String subName, String subCodeee, String Unit){
        this();
        this.subDesc.set(subName);
        this.subCode.set(subCodeee);
        this.Unit.set(Unit);
        
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId(){
        return this.id.get();
    }
    public void setId(int id){
        this.id.set(id);
    }
    @Column (name = "subject_name")
    public String getSubName(){
        return this.subDesc.get();
    }
     public void setSubName(String subDesc){
        this.subDesc.set(subDesc);
    }
    @Column (name = "subject_Code")
    public String getSubCode(){
        return this.subCode.get();
    }
     public void setSubCode(String subCode){
        this.subCode.set(subCode);
    }
    @Column(name = "unit")
    public String getUnit(){
        return this.Unit.get();
    }
    public void setUnit(String Unit){
        this.Unit.set(Unit);
    }
     
    @ManyToOne
    @JoinColumn(name = "schedule")
    public Schedule getSchedule(){
        return this.schedule.get();
    }
    public void setSchedule(Schedule schedule){
        this.schedule.set(schedule);
    }
    @ManyToOne
    @JoinColumn(name = "section")
    public Section getSection(){
        return this.section.get();
    }
    public void setSection(Section section){
        this.section.set(section);
    }
    
   
}

