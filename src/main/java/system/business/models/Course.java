/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package system.business.models;

import java.io.Serializable;
import java.util.List;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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
public class Course implements Serializable {
    private IntegerProperty id;
    private StringProperty courseName;
    private StringProperty courseDesc;
    private ListProperty<Subject> subjects;
    
    public Course(){
        this.id = new SimpleIntegerProperty();
        this.courseName = new SimpleStringProperty();
        this.courseDesc = new SimpleStringProperty();
        this.subjects = new SimpleListProperty<>();
       
    }
    public Course(String courseName, String courseCode, String courseDesc){
        this();
        this.courseName.set(courseName);
        this.courseDesc.set(courseDesc);
        
        
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

    @Column (name = "coursename")
    public String getCourseName(){
        return this.courseName.get();
    }
    public void setCourseName(String courseName){
        this.courseName.set(courseName);
    }

    @Column (name = "coursedesc")
    public String getCourseDesc(){
        return this.courseDesc.get();
    }
    public void setCourseDesc(String courseDesc){
        this.courseDesc.set(courseDesc);
    }
   
    
    @OneToMany(mappedBy = "course")
    public List<Subject> getSubjects(){
        return this.subjects.get();
    }
    public void setSubjects(List<Subject> subjects){
        ObservableList<Subject> subject = FXCollections.observableArrayList(subjects);
        this.subjects.set(subject);
    }
    
    
}