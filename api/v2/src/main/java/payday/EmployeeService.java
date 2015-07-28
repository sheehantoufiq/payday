package payday;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeService {

	private static Connection connection = DBUtil.getConnection();

	public EmployeeService() {
		connection = DBUtil.getConnection();
	}

	public static List<Employee> getAllEmployees(int businessID) {
		List<Employee> employees = new ArrayList<Employee>();
		try {
			String query = "select * from employee_table where business_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, businessID);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Employee employee = new Employee();
				employee.setId(rs.getInt("employee_id"));
				employee.setEmail(rs.getString("email"));
				employee.setPassword(rs.getString("password"));
				employee.setFirstName(rs.getString("first_name"));
				employee.setLastName(rs.getString("last_name"));
				employee.setBio(rs.getString("bio"));
				employee.setIsManager(rs.getBoolean("is_manager"));
				employee.setWage(rs.getFloat("wage"));
				employee.setPhone(rs.getString("phone"));
				employee.setImage("default-image");
				employees.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();			
		}
		return employees;
	}

	public static void createEmployee(Employee employee) throws ParseException {
		try {
			String query = "insert into employee_table(business_id, employee_id, email, password, first_name, last_name, bio, is_manager, wage, phone) values (?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, 1);
			preparedStatement.setInt(2, employee.getId());
			preparedStatement.setString(3, employee.getEmail());
			preparedStatement.setString(4, employee.getPassword());
			preparedStatement.setString(5, employee.getFirstName());
			preparedStatement.setString(6, employee.getLastName());
			preparedStatement.setString(7, employee.getBio());
			preparedStatement.setBoolean(8, employee.getIsManager());
			preparedStatement.setFloat(9, employee.getWage());
			preparedStatement.setString(10, employee.getPhone());
			//preparedStatement.setBlob(11, employee.getImage());
	  	preparedStatement.executeUpdate();
  	} catch (SQLException e) {
   		e.printStackTrace();
  	}
	}

	public static Employee getEmployee(int employeeID) {
		Employee employee = new Employee();
		try {
			String query = "select * from employee_table where employee_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, employeeID);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				employee.setId(rs.getInt("employee_id"));
				employee.setEmail(rs.getString("email"));
				employee.setPassword(rs.getString("password"));
				employee.setFirstName(rs.getString("first_name"));
				employee.setLastName(rs.getString("last_name"));
				employee.setBio(rs.getString("bio"));
				employee.setIsManager(rs.getBoolean("is_manager"));
				employee.setWage(rs.getFloat("wage"));
				employee.setPhone(rs.getString("phone"));
				employee.setImage("default-image");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;		
	}

	public static void updateEmployee(Employee employee) throws ParseException {
		 try {
			String query = "update employee_table set email=?, password=?, first_name=?, last_name=?, bio=?, wage=?, phone=? where employee_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, employee.getEmail());
			preparedStatement.setString(2, employee.getPassword());
			preparedStatement.setString(3, employee.getFirstName());
			preparedStatement.setString(4, employee.getLastName());
			preparedStatement.setString(5, employee.getBio());
			preparedStatement.setFloat(6, employee.getWage());
			preparedStatement.setString(7, employee.getPhone());
			//preparedStatement.setBlob(8, employee.getImage());
			preparedStatement.setInt(9, employee.getId());
	  	preparedStatement.executeUpdate();
  	} catch (SQLException e) {
   		e.printStackTrace();
  	}
	}
	public static void deleteEmployee(int employeeID) {
		try {
			String query = "delete from employee_table where employee_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, employeeID);
	  	preparedStatement.executeUpdate();

  	} catch (SQLException e) {
   		e.printStackTrace();
  	}
	}
	public static Employee login(String email) {
		Employee employee = new Employee();
		try {
			String query = "select * from employee_table where email=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next() == false) {
				employee = null;
			} else {
				employee.setId(rs.getInt("employee_id"));
				employee.setEmail(rs.getString("email"));
				employee.setPassword(rs.getString("password"));
				employee.setFirstName(rs.getString("first_name"));
				employee.setLastName(rs.getString("last_name"));
				employee.setBio(rs.getString("bio"));
				employee.setIsManager(rs.getBoolean("is_manager"));
				employee.setWage(rs.getFloat("wage"));
				employee.setPhone(rs.getString("phone"));
				employee.setImage("default-image");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;		
	}
}