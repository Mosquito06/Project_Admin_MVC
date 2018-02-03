package project.dao;

import java.util.List;

import project.dto.Project;

public interface ProjectDao {
	public List<Project> selectProjectAll();
	public Project selectByNum(Project project);
	public void updateProject(Project project);
	public void deleteProject(Project project);
	public void insertProject(Project project);
	
}
