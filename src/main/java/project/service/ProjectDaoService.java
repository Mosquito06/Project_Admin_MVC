package project.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mvc.util.MySqlSessionFactory;
import project.dao.ProjectDao;
import project.dto.Project;

public class ProjectDaoService implements ProjectDao {
	private static final ProjectDaoService INSTANCE = new ProjectDaoService();

	public static ProjectDaoService getInstance() {
		return INSTANCE;
	}

	private ProjectDaoService() {
	}

	@Override
	public List<Project> selectProjectAll() {
		try (SqlSession sqlSession = MySqlSessionFactory.openSession()) {
			ProjectDao dao = sqlSession.getMapper(ProjectDao.class);
			List<Project> List = dao.selectProjectAll();

			return List;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insertProject(Project project) {

		try (SqlSession sqlSession = MySqlSessionFactory.openSession()) {
			ProjectDao dao = sqlSession.getMapper(ProjectDao.class);
			dao.insertProject(project);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Project selectByNum(Project project) {
		try (SqlSession sqlSession = MySqlSessionFactory.openSession()) {
			ProjectDao dao = sqlSession.getMapper(ProjectDao.class);
			return dao.selectByNum(project);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateProject(Project project) {
		try (SqlSession sqlSession = MySqlSessionFactory.openSession()) {
			ProjectDao dao = sqlSession.getMapper(ProjectDao.class);
			dao.updateProject(project);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteProject(Project project) {
		try (SqlSession sqlSession = MySqlSessionFactory.openSession()) {
			ProjectDao dao = sqlSession.getMapper(ProjectDao.class);
			dao.deleteProject(project);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
