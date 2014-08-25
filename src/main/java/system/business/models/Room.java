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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author dennis
 */
@Entity
@NamedQueries({
@NamedQuery(name = "Room.findAll", query = "SELECT te FROM Room te"),
    @NamedQuery(name = "Room.findById", query = "SELECT te FROM Room te WHERE te.id = :id"),
    @NamedQuery(name = "Room.findByRoomNumber", query = "SELECT te FROM Room te WHERE te.roomNumber = :roomNumber"),
    })
public class Room implements Serializable {
    private IntegerProperty id;
    private IntegerProperty roomNumber;
    private ListProperty<Schedule> schedules;
    
    
    
    public Room(){
        this.id = new SimpleIntegerProperty();
        this.roomNumber = new SimpleIntegerProperty();
        this.schedules = new SimpleListProperty<>();
    }
    
    public Room(int roomNumber){
        this.roomNumber.set(roomNumber);
    }
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    @Id
    public int getId(){
        return this.id.get();
    }
    public void setId(int id){
        this.id.set(id);
    }
    @Column (name = "room_number")
    public int getRoomNumber(){
        return this.roomNumber.get();
    }
    public void setRoomNumber(int roomNumber){
        this.roomNumber.set(roomNumber);
    }
    @OneToMany(mappedBy = "room")
    public List<Schedule> getSchedules(){
        return this.schedules.get();
    }
    public void setSchedules(List<Schedule> schedules){
        ObservableList<Schedule> b = FXCollections.observableArrayList(schedules);
        this.schedules.set(b);
    }
    
    
}
