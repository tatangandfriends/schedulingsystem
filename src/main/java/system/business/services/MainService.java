/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package system.business.services;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author dennis
 */
public class MainService {
    private EntityManager em;
    private EntityTransaction et;
    
    
    @PostConstruct
    public void init(){
        this.em = (EntityManager)Persistence.createEntityManagerFactory("SchedulingSystemPU").createEntityManager();
        this.et = em.getTransaction();
    }
    
    public EntityManager getEM(){
        return this.em;
    }
    
    public EntityTransaction getET(){
        return this.et;
    }
    
}
