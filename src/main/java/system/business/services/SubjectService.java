/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package system.business.services;

import java.util.List;
import javax.inject.Inject;
import system.business.models.Department;
import system.business.models.Subject;
import system.business.models.Teacher;

/**
 *
 * @author BlackBox
 */
public class SubjectService {
    @Inject
   MainService service;
   
   public List<Subject> getAll(){
       return this.service.getEM().createNamedQuery("Subject.findAll").getResultList();
   }
   public List<Department> findDepartmentAll(String name){
         return service.getEM().createNamedQuery("Department.findByDepartment").setParameter("name", "%" + name + "%").getResultList();
     }
   
   public void save(Subject s){
       service.getET().begin();
       Subject merged = service.getEM().merge(s);
       service.getET().commit();
   }
   public void remove(Subject subject){
        service.getET().begin();
        service.getEM().remove(subject);
        service.getET().commit();
    }
}
