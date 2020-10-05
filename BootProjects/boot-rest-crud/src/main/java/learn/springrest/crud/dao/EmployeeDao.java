package learn.springrest.crud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import learn.springrest.crud.model.Employee;

@Repository
public class EmployeeDao implements Dao<Employee>{
	
	@PersistenceContext
	private EntityManager entityManager;
    
	
	 public void save(Employee emp) {
		//entityManager.persist(emp);
	 }
	
	public List<Employee> getAll() {
        Query query = entityManager.createQuery("SELECT e FROM Employee e");
        return query.getResultList();
    }   
       
}
