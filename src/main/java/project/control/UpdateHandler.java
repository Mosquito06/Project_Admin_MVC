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

public class UpdateHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {

		if (req.getMethod().equalsIgnoreCase("get")) {
			ProjectDaoService service = ProjectDaoService.getInstance();
			Project selectProject = selectProject(req, service);

			req.setAttribute("selectProject", selectProject);

			return "/WEB-INF/view/Update.jsp";

		} else if (req.getMethod().equalsIgnoreCase("post")) {
			req.setCharacterEncoding("UTF-8");

			ProjectDaoService service = ProjectDaoService.getInstance();
			Project selectProject = selectProject(req, service);

			String projectName = req.getParameter("title");
			selectProject.setProjectName(projectName);

			String projectContent = req.getParameter("content");
			selectProject.setProjectContent(projectContent);

			SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");

			Date projectStart = date.parse(req.getParameter("sDate"));
			selectProject.setProjectStart(projectStart);

			Date projectEnd = date.parse(req.getParameter("eDate"));
			selectProject.setProjectEnd(projectEnd);

			String ing = req.getParameter("status");

			switch (ing) {
			case "준비":
				selectProject.setProjectIng(ProjectIng.READY);
				break;
			case "준비중":
				selectProject.setProjectIng(ProjectIng.ING);
				break;
			case "종료":
				selectProject.setProjectIng(ProjectIng.END);
				break;
			case "보류":
				selectProject.setProjectIng(ProjectIng.HOLD);
				break;
			}

			service.updateProject(selectProject);
			List<Project> list = service.selectProjectAll();

			req.setAttribute("ProjectList", list);
			res.sendRedirect("list.do?updateResult=1");

			return null;
		}

		return null;

	}

	public Project selectProject(HttpServletRequest req, ProjectDaoService service) {
		String num = req.getParameter("no");
		Project project = new Project();
		project.setProjectNum(Integer.parseInt(num));
		return service.selectByNum(project);
	}

}
