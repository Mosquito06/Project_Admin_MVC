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

public class WriteHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")){
			return "WEB-INF/view/Write.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")){
			req.setCharacterEncoding("UTF-8");
			
			Project project = new Project();
			
			String projectName = req.getParameter("title");
			project.setProjectName(projectName);
			String projectContent = req.getParameter("content");
			project.setProjectContent(projectContent);
			SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");

			Date projectStart = date.parse(req.getParameter("sDate"));
			project.setProjectStart(projectStart);
			
			Date projectEnd = date.parse(req.getParameter("eDate"));
			project.setProjectEnd(projectEnd);
			
			String ing = req.getParameter("status");

			switch(ing){
				case "준비":
					project.setProjectIng(ProjectIng.READY);
					break;
				case "준비중":
					project.setProjectIng(ProjectIng.ING);
					break;
				case "종료":
					project.setProjectIng(ProjectIng.END);
					break;
				case "보류":
					project.setProjectIng(ProjectIng.HOLD);
					break;
			}
			

			
			ProjectDaoService service = ProjectDaoService.getInstance();
			service.insertProject(project);
			List<Project> list = service.selectProjectAll();
						
			req.setAttribute("ProjectList", list);
			res.sendRedirect("list.do?insertResult=1");
			
			return null;
		}
		
		return null;

	}

}
