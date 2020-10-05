package learn.springrest.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import learn.springrest.crud.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
  // auto generates CRUD 
}
