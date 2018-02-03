package project.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.controller.CommandHandler;
import project.dto.Project;
import project.service.ProjectDaoService;

public class DeleteHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String num = req.getParameter("no");
		Project project = new Project();
		project.setProjectNum(Integer.parseInt(num));
		
		ProjectDaoService service = ProjectDaoService.getInstance();
		service.deleteProject(project);
		List<Project> list = service.selectProjectAll();
		
		req.setAttribute("ProjectList", list);
		res.sendRedirect("list.do?delteReulst=1");
		return null;

	}

}
