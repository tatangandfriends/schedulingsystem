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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author dennis
 */
@Entity
@NamedQueries({
@NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c"),
    @NamedQuery(name = "Course.findById", query = "SELECT c FROM Course c WHERE c.id = :id"),
    @NamedQuery(name = "Course.findByCourseDesc", query = "SELECT c FROM Course c WHERE c.courseDesc = :courseDesc"),
    @NamedQuery(name = "Course.findByCourse", query = "SELECT c FROM Course c WHERE c.courseCode = :courseCode")
    })
public class Course implements Serializable {
    private IntegerProperty id;
    private StringProperty courseCode;
    private StringProperty courseDesc;
    private ListProperty<Student> students;
    
    public Course(){
        this.id = new SimpleIntegerProperty();
        this.courseCode = new SimpleStringProperty();
        this.courseDesc = new SimpleStringProperty();
        this.students = new SimpleListProperty<>();
       
    }
    public Course(String courseCode){
        this();
        this.courseCode.set(courseCode);
     
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

    @Column (name = "coursecode")
    public String getCourseCode(){
        return this.courseCode.get();
    }
    public void setCourseCode(String courseCode){
        this.courseCode.set(courseCode);
    }

    @Column (name = "coursedesc")
    public String getCourseDesc(){
        return this.courseDesc.get();
    }
    public void setCourseDesc(String courseDesc){
        this.courseDesc.set(courseDesc);
    }
   
    
    @OneToMany(mappedBy = "course")
    public List<Student> getStudents(){
        return this.students.get();
    }
    public void setStudents(List<Student> students){
        ObservableList<Student> student = FXCollections.observableArrayList(students);
        this.students.set(student);
    }
    
    @Override
    public String toString(){
        return getCourseCode();
    }
}