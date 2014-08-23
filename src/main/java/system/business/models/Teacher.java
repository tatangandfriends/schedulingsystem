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
import javax.persistence.OneToMany;

/**
 *
 * @author dennis
 */
@Entity
public class Teacher implements Serializable {

    private IntegerProperty id;
    private StringProperty fName;
    private StringProperty lName;
    private ObjectProperty<Department> department;
    private ListProperty<Subject> subjects;
    private ListProperty<Schedule> schedules;
    
    public Teacher(){
        this.id = new SimpleIntegerProperty();
        this.fName = new SimpleStringProperty();
        this.lName = new SimpleStringProperty();
        this.subjects= new SimpleListProperty<>();
        this.schedules = new SimpleListProperty<>();
        this.department = new SimpleObjectProperty<>();
    }
    public Teacher(String fName, String lName){
        this();
        this.lName.set(lName);
        this.fName.set(fName);
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
    public String getFName(){
        return this.fName.get();
    }
     public void setFName(String fName){
        this.fName.set(fName);
    }
    @Column (name = "last_name")
    public String getLName(){
        return this.lName.get();
    }
    public void setLName(String lName){
        this.lName.set(lName);
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




