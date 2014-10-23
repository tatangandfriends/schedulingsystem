/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package system.business.models;

import java.io.Serializable;
import javafx.beans.property.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author dennis
 */
@Entity
@Table(name="subject")
public class Subject implements Serializable {
    
    private IntegerProperty id;
    private StringProperty name;
    private StringProperty code;
    private StringProperty unit;


    public Subject(){
        this.id = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
        this.code = new SimpleStringProperty();
        this.unit = new SimpleStringProperty();
    }
    
    public Subject(String subName, String subCodeee, String Unit){
        this();
        this.name.set(subName);
        this.code.set(subCodeee);
        this.unit.set(Unit);
        
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId(){
        return this.id.get();
    }
    public void setId(int id){
        this.id.set(id);
    }

   
}

