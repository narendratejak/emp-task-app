package com.neehait.emptask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.neehait.emptask.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	@Query(value = "select e.* from employee e join department d on e.dept_id=d.id where e.id=?",nativeQuery = true)
	Employee getemployeeById(int id);

}
