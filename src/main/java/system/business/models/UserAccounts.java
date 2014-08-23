/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package system.business.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author dennis
 */
public class UserAccounts {
    private IntegerProperty id;
    private StringProperty username;
    private StringProperty password;
    
    
    public UserAccounts(){
        this.id = new SimpleIntegerProperty();
        this.username = new SimpleStringProperty();
        this.password = new SimpleStringProperty();
    }
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id.get();
    }

    public void setId(Integer id) {
        this.id.set(id);
    }   
    
    @Column(name="username")
    public String getUsername(){
       return this.username.get();
    }
    
    public void setUsername(String username){
        this.username.set(username);
    }
    
    @Column(name="password")
    public String getPassword(){
       return this.password.get();
    }
    
    public void setPassword(String password){
        this.password.set(password);
    }
}
