package project.control;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.controller.CommandHandler;
import project.dto.Project;
import project.dto.ProjectIng;
import project.service.ProjectDaoService;

public class ReadHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String num = req.getParameter("no");
		Project project = new Project();
		project.setProjectNum(Integer.parseInt(num));
		
		ProjectDaoService service = ProjectDaoService.getInstance();
		Project selectProject = service.selectByNum(project);
		
		req.setAttribute("selectProject", selectProject);
		
		return "WEB-INF/view/Read.jsp";

	}

}
