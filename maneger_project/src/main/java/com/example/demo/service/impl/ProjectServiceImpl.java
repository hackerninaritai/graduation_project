package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Project;
import com.example.demo.entity.Staff;
import com.example.demo.entity.Task;
import com.example.demo.repository.ProjectRepo;
import com.example.demo.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService{
	
	@Autowired
	private ProjectRepo projectRepo;

	@Override
	public List<Project> getListProject() {
		// TODO Auto-generated method stub
		return projectRepo.findAll();
	}

	@Override
	public void saveProject(Project project) {
		// TODO Auto-generated method stub
		projectRepo.save(project);
	}

	@Override
	public Project getProjecByiD(int id) {
		// TODO Auto-generated method stub
		return projectRepo.getOne(id);
	}

	@Override
	public List<Task> getListTaskOfProject(int id) {
		// TODO Auto-generated method stub
		return projectRepo.fetchStaffProjectInnerJoin(id);
	}

	@Override
	public List<Staff> getListStaffOfProject(int id) {
		// TODO Auto-generated method stub
		return projectRepo.fetchStaff(id);
	}

	@Override
	public boolean deleteProjectById(int id) {
		if (null != projectRepo.getOne(id)) {
			projectRepo.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public List<Project> searchProject(String keyworld) {
		// TODO Auto-generated method stub
		return null;
	}

}
