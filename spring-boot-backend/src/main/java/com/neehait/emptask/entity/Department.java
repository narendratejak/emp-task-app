package com.neehait.emptask.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;

@Entity
public class Department {
	
	@Id
	private Integer id;
	public Department() {
		super();
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", deptName=" + deptName + ", employess=" + employess + "]";
	}
	private String deptName;
	@OneToMany
	private List<Employee> employess;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Department(int id, String deptName) {
		super();
		this.id = id;
		this.deptName = deptName;
	}
	public List<Employee> getEmployess() {
		return employess;
	}
	public void setEmployess(List<Employee> employess) {
		this.employess = employess;
	}
	
	
	
	
	
	
}
