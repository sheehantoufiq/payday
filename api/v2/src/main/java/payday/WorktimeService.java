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

public class WorktimeService {

	private static Connection connection = DBUtil.getConnection();

	public WorktimeService() {
		connection = DBUtil.getConnection();
	}

	public static List<Worktime> getAllWorktimes(int employeeID) {
		List<Worktime> worktimes = new ArrayList<Worktime>();
		try {
			String query = "select * from worktime_table where employee_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, employeeID);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Worktime worktime = new Worktime();
				worktime.setId(rs.getInt("worktime_id"));
				worktime.setTimeIn(rs.getString("time_in"));
				worktime.setTimeOut(rs.getString("time_out"));
				worktimes.add(worktime);
			}
		} catch (SQLException e) {
			e.printStackTrace();			
		}
		return worktimes;
	}

	public static void createWorktime(Worktime worktime) throws ParseException {
		try {
			String query = "insert into worktime_table(employee_id, worktime_id, time_in, time_out) values (?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, 1);
			preparedStatement.setInt(2, worktime.getId());
			preparedStatement.setString(3, worktime.getTimeIn());
			preparedStatement.setString(3, worktime.getTimeOut());
	  	preparedStatement.executeUpdate();
  	} catch (SQLException e) {
   		e.printStackTrace();
  	}
	}

	public static Worktime getWorktime(int worktimeID) {
		Worktime worktime = new Worktime();
		try {
			String query = "select * from worktime_table where worktime_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, worktimeID);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				worktime.setId(rs.getInt("worktime_id"));
				worktime.setTimeIn(rs.getString("time_in"));
				worktime.setTimeIn(rs.getString("time_out"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return worktime;		
	}

	public static void updateWorktime(Worktime worktime) throws ParseException {
		 try {
			String query = "update worktime_table set time_in=?, time_out=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, worktime.getTimeIn());
			preparedStatement.setString(1, worktime.getTimeOut());
	  	preparedStatement.executeUpdate();
  	} catch (SQLException e) {
   		e.printStackTrace();
  	}
	}
	
	public static void deleteWorktime(int worktimeID) {
		try {
			String query = "delete from worktime_table where worktime_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, worktimeID);
	  	preparedStatement.executeUpdate();
  	} catch (SQLException e) {
   		e.printStackTrace();
  	}
	}
}