/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package system.business.models;

import java.io.Serializable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author dennis
 */
@Entity
@Table(name="class_section")
@NamedQueries({
@NamedQuery(name = "ClassSection.findAll", query = "SELECT cs FROM ClassSection cs")})
public class ClassSection implements Serializable {
    private IntegerProperty id;
    private StringProperty sectionCode;
    private ListProperty<Subject> subjects;
    
    
    public ClassSection(){
        this.id = new SimpleIntegerProperty();
        this.sectionCode = new SimpleStringProperty();
    }
    public ClassSection(String sectionCode){
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
    public StringProperty sectionCodeProperty(){
        return sectionCode;
    }

}
