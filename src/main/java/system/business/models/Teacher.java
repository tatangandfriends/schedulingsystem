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
@Table(name="teacher")
@NamedQueries({
@NamedQuery(name = "Teacher.findAll", query = "SELECT te FROM Teacher te"),
    @NamedQuery(name = "Teacher.findById", query = "SELECT te FROM Teacher te WHERE te.id = :id"),
    @NamedQuery(name = "Teacher.findByFname", query = "SELECT te FROM Teacher te WHERE te.fname = :fname"),
    @NamedQuery(name = "Teacher.findByLname", query = "SELECT te FROM Teacher te WHERE te.lname = :lname"),
    @NamedQuery(name = "Teacher.findByTeacher", query = "SELECT te FROM Teacher te WHERE te.fname LIKE :fname OR te.lname LIKE :lname")
   })
public class Teacher implements Serializable {

    private IntegerProperty id;
    private StringProperty fname;
    private StringProperty lname;
    private ObjectProperty<Department> department;
    private ListProperty<Subject> subjects;
    private ListProperty<Schedule> schedules;
    
    public Teacher(){
        this.id = new SimpleIntegerProperty();
        this.fname = new SimpleStringProperty();
        this.lname = new SimpleStringProperty();
        this.subjects= new SimpleListProperty<>();
        this.schedules = new SimpleListProperty<>();
        this.department = new SimpleObjectProperty<>();
    }
    public Teacher(String fname, String lname){
        this();
        this.lname.set(lname);
        this.fname.set(fname);
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
    @Column (name = "first_name")
    public String getFname(){
        return this.fname.get();
    }
     public void setFname(String fname){
        this.fname.set(fname);
    }
    @Column (name = "last_name")
    public String getLname(){
        return this.lname.get();
    }
    public void setLname(String lname){
        this.lname.set(lname);
    }
    
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department")
    
    public Department getDepartment(){
        return this.department.get();
    }
    public void setDepartment(Department department){
        this.department.set(department);
    }
    
    @OneToMany(mappedBy = "teacher")
    public List<Schedule> getSchedules(){
        return this.schedules.get();
    }
    public void setSchedules(List<Schedule> schedules){
            ObservableList<Schedule> schedule = FXCollections.observableArrayList(schedules);
        this.schedules.set(schedule);
    }

        
}




