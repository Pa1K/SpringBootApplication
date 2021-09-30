package com.pavan.restapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.pavan.restapi.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	List<Employee> findByTech(String tech);

	List<Employee> findByIdGreaterThan(int i);

	List<Employee>  findByIdLessThan(int i);

	List<Employee>  findByIdEquals(int i);
	
	@Query("from Employee where tech=?1 order by name")
	List<Employee> findByTechSorted(String tech);
}

/**
 * replacing  CrudRepository with JpaRepository as it extends PagingAndSortingRepository which extends CrudRepository, so we will get multiple options
 * @NoRepositoryBean
  public interface JpaRepository<T, ID> extends PagingAndSortingRepository<T, ID>, QueryByExampleExecutor<T> {
  
  @NoRepositoryBean
public interface PagingAndSortingRepository<T, ID> extends CrudRepository<T, ID> {
 */
