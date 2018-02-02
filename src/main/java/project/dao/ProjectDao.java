package project.dao;

import java.util.List;

import project.dto.Project;

public interface ProjectDao {
	public List<Project> selectProjectAll();
}
