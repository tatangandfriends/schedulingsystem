/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package system.business.models;

import java.io.Serializable;
import java.util.List;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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
@Table(name="student")
@NamedQueries({
@NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findById", query = "SELECT s FROM Student s WHERE s.id = :id"),
    @NamedQuery(name = "Student.findByFname", query = "SELECT s FROM Student s WHERE s.fname = :fname"),
    @NamedQuery(name = "Student.findByLname", query = "SELECT s FROM Student s WHERE s.lname = :lname"),
    @NamedQuery(name = "Student.findByStudent", query = "SELECT s FROM Student s WHERE s.fname LIKE :fname OR s.lname LIKE :lname")
   })
public class Student implements Serializable {
    private IntegerProperty id;
    private StringProperty fname;
    private StringProperty lname;
    private ListProperty<Subject> subjects;
    private ListProperty<Schedule> schedules;
    
    public Student(){
        this.id = new SimpleIntegerProperty();
        this.fname = new SimpleStringProperty();
        this.lname = new SimpleStringProperty();
        this.subjects = new SimpleListProperty<>();
        this.schedules = new SimpleListProperty<>();
    }
    public Student(String fname, String lname){
        this();
        this.fname.set(lname);
        this.lname.set(lname);
    }
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    public int getId(){
        return this.id.get();
    }
    public void setId(int id){
        this.id.set(id);
    }
    
    public String getFname(){
        return this.fname.get();
    }
     public void setFname(String fname){
        this.fname.set(fname);
    }
    
    public String getLname(){
        return this.lname.get();
    }
    public void setLname(String lname){
        this.lname.set(lname);
    }
    
    

    @OneToMany(mappedBy = "student")
    public List<Schedule> getSchedules(){
        return this.schedules.get();
    }
    public void setSchedules(List<Schedule> schedules){
        ObservableList<Schedule> schedule = FXCollections.observableArrayList(schedules);
        this.schedules.set(schedule);
    }

       
}




