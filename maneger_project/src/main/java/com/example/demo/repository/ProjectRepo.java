package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Project;
import com.example.demo.entity.Staff;
import com.example.demo.entity.Task;
@Repository
public interface ProjectRepo extends JpaRepository<Project, Integer>{
	
//	public Project findByUsename(String projectname);
	
	@Query("select t from Task t where t.projectId.projectId= :projectId")
	List<Task> fetchStaffProjectInnerJoin(@Param("projectId") int projectId);
	
	@Query("select s from Staff s inner join s.staffProject sp  where sp.projectId= :projectId")
	List<Staff> fetchStaff(@Param("projectId") int projectId);
}
