/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package system.business.models;

import java.io.Serializable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author dennis
 */
@Entity
public class Section implements Serializable {
    private IntegerProperty id;
    private StringProperty sectionCode;
    
    
    public Section(){
        this.id = new SimpleIntegerProperty();
        this.sectionCode = new SimpleStringProperty();
        
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
    
    
}
