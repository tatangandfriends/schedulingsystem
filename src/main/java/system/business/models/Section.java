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
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
@NamedQuery(name = "Section.findAll", query = "SELECT s FROM Section s"),
    @NamedQuery(name = "Section.findById", query = "SELECT s FROM Section s WHERE s.id = :id"),
    @NamedQuery(name = "Section.findBySectionCode", query = "SELECT s FROM Section s WHERE s.sectionCode = :sectionCode")
   
    })
public class Section implements Serializable {
    private IntegerProperty id;
    private StringProperty sectionCode;
    private ListProperty<Subject> subjects;
    
    
    public Section(){
        this.id = new SimpleIntegerProperty();
        this.sectionCode = new SimpleStringProperty();
        this.subjects = new SimpleListProperty<>();
        
    }
    public Section(String sectionCode){
        this();
        this.sectionCode.set(sectionCode);
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId(){
        return this.id.get();
    }
    public void setId(int id){
        this.id.set(id);
    }
    public String getSectionCode(){
        return this.sectionCode.get();
    }
    public void setSectionCode(String sectionCode){
        this.sectionCode.set(sectionCode);
    }
    @OneToMany(mappedBy = "section")
    public List<Subject> getSubjects(){
        return this.subjects.get();
    }
    public void setSubjects(List<Subject> subjects){
        ObservableList<Subject> subject = FXCollections.observableArrayList(subjects);
        this.subjects.set(subject);
    }
    
    
}
