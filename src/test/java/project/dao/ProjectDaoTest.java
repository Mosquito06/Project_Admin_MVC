package project.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import mvc.util.MySqlSessionFactory;
import project.dto.Project;

public class ProjectDaoTest {
	
	@Test
	public void selectTest(){
		SqlSession sqlSession = MySqlSessionFactory.openSession();
		
		try{
			ProjectDao dao = sqlSession.getMapper(ProjectDao.class);
			
			List<Project> list = dao.selectProjectAll();
			
			for(Project p : list){
				System.out.println(p.toString());
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			MySqlSessionFactory.closeSession(sqlSession);
		}
		
	}
	
}
