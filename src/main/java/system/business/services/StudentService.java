/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package system.business.services;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import system.business.models.Student;

/**
 *
 * @author Telafas
 */
public class StudentService {
    
   @Inject
   MainService service;
   
   public List<Student> getAll(){
       return this.service.getEM().createNamedQuery("Student.findAll").getResultList();
   }
   
   
   public void save(Student s){
       service.getET().begin();
       Student merged = service.getEM().merge(s);
       service.getET().commit();
   }
   
   public List<Student> findByName(String name){
       Query query = service.getEM().createNamedQuery("Student.findByFname");
       query.setParameter("fname", "%" + name + "%");
       query.setParameter("lname", "%" + name + "%");
       
       return query.getResultList();       
   }
   
    
}
