package project.dto;

import java.util.Date;

public class Project {
	private int projectNum;
	private String projectName;
	private String projectContent;
	private Date projectStart;
	private Date projectEnd;
	private ProjectIng projectIng;

	public Project() {
		super();
	}

	public int getProjectNum() {
		return projectNum;
	}

	public void setProjectNum(int projectNum) {
		this.projectNum = projectNum;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectContent() {
		return projectContent;
	}

	public void setProjectContent(String projectContent) {
		this.projectContent = projectContent;
	}

	public Date getProjectStart() {
		return projectStart;
	}

	public void setProjectStart(Date projectStart) {
		this.projectStart = projectStart;
	}

	public Date getProjectEnd() {
		return projectEnd;
	}

	public void setProjectEnd(Date projectEnd) {
		this.projectEnd = projectEnd;
	}

	public ProjectIng getProjectIng() {
		return projectIng;
	}

	public void setProjectIng(ProjectIng projectIng) {
		this.projectIng = projectIng;
	}

	@Override
	public String toString() {
		return "Project [projectNum=" + projectNum + ", projectName=" + projectName + ", projectContent="
				+ projectContent + ", projectStart=" + projectStart + ", projectEnd=" + projectEnd + ", projectIng="
				+ projectIng + "]";
	}

}
