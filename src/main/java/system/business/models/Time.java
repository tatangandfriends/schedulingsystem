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
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author dennis
 */
@Entity
@NamedQueries({
@NamedQuery(name = "Time.findAll", query = "SELECT t FROM Time t"),
    @NamedQuery(name = "Time.findById", query = "SELECT t FROM Time t WHERE t.id = :id"),
    @NamedQuery(name = "Time.findByTime", query = "SELECT t FROM Time t WHERE t.time = :time"),
     })
public class Time implements Serializable {

    private IntegerProperty id;
    private IntegerProperty time;
    private ListProperty<Schedule> schedules;
    
    
    public Time(){
        this.id = new SimpleIntegerProperty();
        this.time = new SimpleIntegerProperty();
        this.schedules = new SimpleListProperty<>();
    }
    public Time(int time){
        this();
        this.time.set(time);
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId(){
        return this.id.get();
    }
    public void setId(int id){
        this.id.set(id);
    }
    public int getTime(){
        return this.time.get();
    }
    public void setTime(int time){
        this.time.set(time);
    }
    
    @OneToMany(mappedBy = "time")
    
    public List<Schedule> getSchedules(){
        return this.schedules.get();
    }
    public void setSchedules(List<Schedule> schedules){
        ObservableList<Schedule> schedule = FXCollections.observableArrayList(schedules);
        this.schedules.set(schedule);
    }
}
