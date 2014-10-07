/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package system.business.services;

import java.util.List;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import system.business.models.UserAccounts;

/**
 *
 * @author BlackBox
 */
public class Accounts {
    
    
   @Inject
   MainService service;
   
   public List<UserAccounts> findByUserName(String search){         
         return service.getEM().createNamedQuery("UserAccounts.findByUsername")
                 .setParameter("username", "%" + search + "%").getResultList();
    }

    public UserAccounts checkCredentials(String username, String password){
        try{
            return (UserAccounts)service.getEM().createNamedQuery("UserAccounts.CheckCredentials")
                .setParameter("username", username).setParameter("password", password).getSingleResult();
        }catch(NoResultException e){
            return null;
        }
    }
}
