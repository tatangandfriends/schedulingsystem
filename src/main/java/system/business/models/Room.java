/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package system.business.models;

import java.io.Serializable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
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
@Table(name="room")
@NamedQueries({
@NamedQuery(name = "Room.findAll", query = "SELECT r FROM Room r")})
public class Room implements Serializable {
    private IntegerProperty id;
    private IntegerProperty roomNumber;

    public Room(){
        this.id = new SimpleIntegerProperty();
        this.roomNumber = new SimpleIntegerProperty();
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
    
    public IntegerProperty roomNumberProperty(){
        return roomNumber;
    }

}
