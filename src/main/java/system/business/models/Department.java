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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author dennis
 */
@Entity
public class Department implements Serializable {
    private IntegerProperty id;
    private StringProperty deptName;
    private ListProperty<Teacher> teachers;
   
    public Department(){
        this.id = new SimpleIntegerProperty();
        this.deptName = new SimpleStringProperty();
        this.teachers = new SimpleListProperty<>();
    }
    public Department(String deptName){
        this();
        this.deptName.set(deptName);
    }
    
    @Id
    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId(){
        return this.id.get();
    }
    public void setId(int id){
        this.id.set(id);
    }
    
    @Column (name = "dept_name")
    public String getDeptName(){
        return this.deptName.get();
    }
    public void setDeptName(String deptName){
        this.deptName.set(deptName);
    }
    
    @OneToMany(mappedBy = "department")
    public List<Teacher> getTeachers(){
        return this.teachers.get();
    }
    public void setTeachers(List<Teacher> teachers){
        ObservableList<Teacher> teacher = FXCollections.observableArrayList(teachers);
        this.teachers.set(teacher);
    }
    
}


