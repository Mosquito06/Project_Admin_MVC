package project.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.controller.CommandHandler;
import project.dto.Project;
import project.service.ProjectDaoService;

public class MainHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ProjectDaoService service = ProjectDaoService.getInstance();
		List<Project> list = service.selectProjectAll();
		req.setAttribute("ProjectList", list);
		
		return "/WEB-INF/view/List.jsp";

	}

}
