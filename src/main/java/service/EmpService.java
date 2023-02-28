package service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.EmpDao;
import dto.EmpDto;

@Service
public class EmpService {
	
	//Mybatis 작업
	private SqlSession sqlsession;

	@Autowired
	public void setSqlsession(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
	}
	
	public List<EmpDto> findAll() {
		List<EmpDto> list = null;
		try {
			EmpDao dao = sqlsession.getMapper(EmpDao.class);
			list = dao.findAll();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
