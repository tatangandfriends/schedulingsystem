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
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Telafas
 */

@Entity
@Table(name = "student")
public class Student implements Serializable {
    IntegerProperty id;
    StringProperty firstName;
    StringProperty lastName;
    
    public Student(){
        id = new SimpleIntegerProperty();
        firstName = new SimpleStringProperty();
        lastName = new SimpleStringProperty();
    }
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId(){
        return this.id.get();
    }
    
    public void setId(Integer id){
        this.id.set(id);
    }
    
    @Column(name = "first_name")
    public String getFirstName(){
        return this.firstName.get();
    }
    
    public void setFirstName(String firstName){
        this.firstName.set(firstName);
    }
    
    @Column(name = "last_name")
    public String getLastName(){
     return this.lastName.get();
    }
    
    public void setLastName(String lastName){
        this.lastName.set(lastName);    
    }
                
    
}
