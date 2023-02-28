package dao;

import java.sql.SQLException;
import java.util.List;

import dto.EmpDto;

public interface EmpDao {
	List<EmpDto> findAll() throws ClassNotFoundException, SQLException;
}
