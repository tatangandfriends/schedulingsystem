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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author dennis
 */
@Entity
@NamedQueries ({
@NamedQuery(name = "UserAccounts.findAll", query = "SELECT a FROM UserAccounts a"),
    @NamedQuery(name = "UserAccounts.findById", query = "SELECT a FROM UserAccounts a WHERE a.id = :id"),
    @NamedQuery(name = "UserAccounts.findByUserName", query = "SELECT a FROM UserAccounts a WHERE a.userName LIKE :userName"),
    @NamedQuery(name = "UserAccounts.findByPassword", query = "SELECT a FROM UserAccounts a WHERE a.password LIKE :password"),
//    @NamedQuery(name = "UserAccounts.CheckCredentials", query = "SELECT a FROM UserAccounts a WHERE a.userName = :userName AND a.password = :password")})
})
public class UserAccounts {
    private IntegerProperty id;
    private StringProperty userName;
    private StringProperty password;
    
    
    public UserAccounts(){
        this.id = new SimpleIntegerProperty();
        this.userName = new SimpleStringProperty();
        this.password = new SimpleStringProperty();
    }
    public UserAccounts(String userName, String password){
        this();
        this.userName.set(userName);
        this.password.set(password);
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
       return this.userName.get();
    }
    
    public void setUserName(String userName){
        this.userName.set(userName);
    }
    
    @Column(name="password")
    public String getPassword(){
       return this.password.get();
    }
    
    public void setPassword(String password){
        this.password.set(password);
    }
}
