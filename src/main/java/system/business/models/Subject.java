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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author dennis
 */
@Entity
@Table(name="subject")
@NamedQueries({
@NamedQuery(name = "Subjects.findAll", query = "SELECT s FROM Subject s")})
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
    
    @Column(name = "subject_name")
    public String getName(){
        return this.name.get();
    }
    public void setName(String name){
        this.name.set(name);
    }
    @Column(name = "code")
    public String getCode(){
        return this.code.get();
    }
    public void setCode(String code){
        this.code.set(code);
    }
    @Column(name = "unit")
    public String getUnit(){
        return this.unit.get();
    }
    public void setUnit(String unit){
        this.unit.set(unit);
    }
    public StringProperty nameProperty(){
        return name;
    }
    
    public StringProperty codeProperty(){
        return code;
    }
    
    public StringProperty unitProperty(){
        return unit;
    }
   
}

