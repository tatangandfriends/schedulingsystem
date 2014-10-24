/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package system.business.models;

import java.io.Serializable;
import javafx.beans.property.*;
import javafx.beans.value.ObservableListValue;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 *
 * @author dennis
 */
@Entity
@Table(name="timetype")
public class TimeType implements Serializable {
    
    private IntegerProperty id;
    private StringProperty name;
    private StringProperty timeStart;
    private StringProperty timeEnd;
    private ObjectProperty<Schedule> schedule;
    
    
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
    
    @OneToOne
    @JoinColumn(name="time_id")
    public Schedule getSchedule(){
        return this.schedule.get();
    }
    public void setSchedule(Schedule schedule){
        this.schedule.set(schedule);
    }

}
