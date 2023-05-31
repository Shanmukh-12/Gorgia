package jdbc.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.model.Employee;
import jdbc.model.EmployeeMapper;

public class EmpDAOImpl implements EmpDAO {

	JdbcTemplate jdbcTemplate;

	private final String SQL_FIND_EMPLOYEE = "select * from empsha where empno = ?";
	private final String SQL_DELETE_EMPLOYEE = "delete from empsha where empno = ?";
	private final String SQL_UPDATE_EMPLOYEE = "update empsha set ename = ?, job = ?, sal  = ?, deptno  = ? where empno = ?";
	private final String SQL_GET_ALL = "select * from empsha";
	private final String SQL_INSERT_EMPLOYEE = "insert into empsha(empno, ename, job, sal,deptno) values(?,?,?,?,?)";

	@Autowired
	public EmpDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public Employee getEmployeeByNo(Integer eno) {
		return jdbcTemplate.queryForObject(SQL_FIND_EMPLOYEE, new Object[] { eno }, new EmployeeMapper());
	}

	public List<Employee> getAllEmployees() {
		return jdbcTemplate.query(SQL_GET_ALL, new EmployeeMapper());
	}

	public boolean deleteEmployee(Employee e) {
		return jdbcTemplate.update(SQL_DELETE_EMPLOYEE, e.getEmpNo()) > 0;
	}

	public boolean updateEmployee(Employee e) {
		return jdbcTemplate.update(SQL_UPDATE_EMPLOYEE, e.getEName(), e.getJob(), e.getSalary(), e.getDeptNo(),
				e.getEmpNo()) > 0;
	}

	public boolean createEmployee(Employee e) {
		return jdbcTemplate.update(SQL_INSERT_EMPLOYEE, e.getEmpNo(), e.getEName(), e.getJob(), e.getSalary(),
				e.getDeptNo()) > 0;
	}

	// public boolean deleteEmployee(int empno) {
	// String sql = "DELETE FROM empsha WHERE empno = ?";
	// int rowsAffected = jdbcTemplate.update(sql, empno);
	// return rowsAffected > 0;
	// }
}