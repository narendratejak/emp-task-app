package com.neehait.emptask.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neehait.emptask.entity.Department;

public interface DeptRepository extends JpaRepository<Department, Integer> {
	
	//Department findById(int id);

}
