package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Employee;

public class EmployeeDAO extends DAO {
	public List<Employee> findAll() throws Exception {
		List<Employee> list = new ArrayList<>();
		try (Connection con = getConnection();
				PreparedStatement st = con.prepareStatement("SELECT * FROM employees");) {
			try (ResultSet rs = st.executeQuery();) {
				while (rs.next()) {
					Employee e = new Employee();
					e.setId(rs.getInt("id"));
					e.setName(rs.getString("name"));
					e.setAge(rs.getInt("age"));

					list.add(e);
				}
			}
		}
		return list;
	}

	public Employee findById(int id) throws Exception {
		try (Connection con = getConnection();
				PreparedStatement st = con.prepareStatement("SELECT * FROM employees WHERE id=?");) {
			st.setInt(1, id);
			try (ResultSet rs = st.executeQuery();) {
				if (rs.next()) {
					return new Employee(rs.getInt("id"), rs.getString("name"), rs.getInt("age"));
				}
			}
		}
		return null;
	}

	public boolean insert(Employee employee) throws Exception {
		try (Connection con = getConnection();
				PreparedStatement st = con.prepareStatement("INSERT INTO employees (name,age) VALUES(?,?)");) {
			st.setString(1, employee.getName());
			st.setInt(2, employee.getAge());
			return st.executeUpdate() > 0;
		}
	}

	public boolean update(Employee employee) throws Exception {
		try (Connection con = getConnection();
				PreparedStatement st = con
						.prepareStatement("UPDATE employees SET age = ? , name=? WHERE id = ?");) {
			st.setInt(1, employee.getAge());
			st.setString(2, employee.getName());
			st.setInt(3, employee.getId());
			return st.executeUpdate() > 0;
		}
	}

	public boolean delete(int id) throws Exception {
		try (Connection con = getConnection();
				PreparedStatement st = con
						.prepareStatement("DELETE FROM employees WHERE id = ?");) {
			st.setInt(1, id);
			return st.executeUpdate() > 0;
		}
	}
}
