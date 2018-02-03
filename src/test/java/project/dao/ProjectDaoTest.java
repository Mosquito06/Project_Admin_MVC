package project.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import mvc.util.MySqlSessionFactory;
import project.dto.Project;
import project.dto.ProjectIng;

public class ProjectDaoTest {

	/*@Test
	public void selectTest() {
		SqlSession sqlSession = MySqlSessionFactory.openSession();

		try {
			ProjectDao dao = sqlSession.getMapper(ProjectDao.class);

			List<Project> list = dao.selectProjectAll();

			for (Project p : list) {
				System.out.println(p.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MySqlSessionFactory.closeSession(sqlSession);
		}

	}

	@Test
	public void insertTest() {
		SqlSession sqlSession = MySqlSessionFactory.openSession();

		try {
			ProjectDao dao = sqlSession.getMapper(ProjectDao.class);

			Project project = new Project("추가 중", "추가 함 해보자", new Date(), new Date(), ProjectIng.HOLD);
			dao.insertProject(project);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MySqlSessionFactory.closeSession(sqlSession);
		}
	}*/

	/*@Test
	public void updateTest() {
		SqlSession sqlSession = MySqlSessionFactory.openSession();

		ProjectDao dao = sqlSession.getMapper(ProjectDao.class);

		Project project = new Project();
		project.setProjectNum(5);
		project.setProjectName("제목을 수정함");
		project.setProjectContent("내용을 수정함");
		project.setProjectStart(new Date());
		project.setProjectEnd(new Date());
		project.setProjectIng(ProjectIng.END);
		
		dao.updateProject(project);
		sqlSession.commit();

	}*/
	
	@Test
	public void deleteTest() {
		SqlSession sqlSession = MySqlSessionFactory.openSession();

		ProjectDao dao = sqlSession.getMapper(ProjectDao.class);

		Project project = new Project();
		project.setProjectNum(2);
		dao.deleteProject(project);
		sqlSession.commit();
	}
	
	@Test
	public void selectByNumTest() {
		SqlSession sqlSession = MySqlSessionFactory.openSession();

		ProjectDao dao = sqlSession.getMapper(ProjectDao.class);

		Project project = new Project();
		project.setProjectNum(4);
		
		System.out.println("번호로 선택한 프로젝트의 번호 = " + dao.selectByNum(project).getProjectNum());

	}

}
