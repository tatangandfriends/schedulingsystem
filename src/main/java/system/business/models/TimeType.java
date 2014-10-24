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
@Table(name="timetype")
@NamedQueries({
@NamedQuery(name = "TimeType.findAll", query = "SELECT r FROM TimeType r")})
public class TimeType implements Serializable {
    private IntegerProperty id;
    private StringProperty name;
    private StringProperty timeStart;
    private StringProperty timeEnd;

    
    
    public TimeType(){
        this.id = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
        this.timeStart = new SimpleStringProperty();
        this.timeEnd = new SimpleStringProperty();
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId(){
        return this.id.get();
    }
    public void setId(int id){
        this.id.set(id);
    }
    
    @Column(name = "name")
    public String getName(){
        return this.name.get();
    }
    
    public void setName(String name){
        this.name.set(name);
    }
    
    @Column(name = "time_started")
    public String getTimeStart(){
        return this.timeStart.get();
    }
    
    public void setTimeStart(String timeStart){
        this.timeStart.set(timeStart);
    }
    
    @Column(name = "time_ended")
    public String getTimeEnd(){
        return this.timeEnd.get();
    }
    public void setTimeEnd(String timeEnd){
        this.timeEnd.set(timeEnd);
    }
    
    public StringProperty nameProperty(){
        return name;
    }
    
    public StringProperty timeStartProperty(){
        return timeStart;
    }
    
    public StringProperty timeEndProperty(){
        return timeEnd;
    }

}
