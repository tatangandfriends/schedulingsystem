/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package system.business.services;

import java.util.List;
import javax.inject.Inject;
import javax.persistence.Query;
import system.business.models.Department;
import system.business.models.Teacher;

/**
 *
 * @author dennis
 */
public class TeacherService {
    @Inject
   MainService service;
   
   public List<Teacher> getAll(){
       return this.service.getEM().createNamedQuery("Teacher.findAll").getResultList();
   }
   
   
   public void save(Teacher t){
       service.getET().begin();
       Teacher merged = service.getEM().merge(t);
       service.getET().commit();
   }
   public List<Teacher> findByName(String name){
       Query query = service.getEM().createNamedQuery("Teacher.findByFname");
       query.setParameter("fname", "%" + name + "%");
       query.setParameter("lname", "%" + name + "%");
       
       return query.getResultList();       
   }
   public void remove(Teacher teacher){
        service.getET().begin();
        service.getEM().remove(teacher);
        service.getET().commit();
    }
   
   public Department findDepartment(String name){
         return (Department)this.service.getEM().createNamedQuery("Teacher.findByDepartment")
                 .setParameter("deptName", name).getSingleResult();
     }
   public List<Department> findAllDepartment(){
       return this.service.getEM().createNamedQuery("Department.findAll").getResultList();
   }
   public List<Teacher> findByDeptName(Department department){
       return service.getEM().createNamedQuery("Teacher.byDeparment").setParameter("department", department).getResultList();
   }
   public List<Department> findDepartmentAll(String name){
         return service.getEM().createNamedQuery("Department.findByDepartment").setParameter("name", "%" + name + "%").getResultList();
     }
   
}
