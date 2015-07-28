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

public class BusinessService {

	public static Connection connection = DBUtil.getConnection();

	public BusinessService() {
		connection = DBUtil.getConnection();
	}

	public static Business getBusiness(int businessID) {
		Business business = new Business();
		try {
			String query = "select * from business_table where business_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, businessID);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				business.setId(rs.getInt("business_id"));
				business.setName(rs.getString("business_name"));
				business.setAddress(rs.getString("address"));   
				business.setCity(rs.getString("city"));
				business.setState(rs.getString("state"));
				business.setZip(rs.getString("zip"));
				business.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return business;
	}

	public static void updateBusiness(Business business) throws ParseException {
	  try {
			String query = ("update business_table set business_name=?, address=?, city=?, state=?, zip=?, phone=? where business_id=?");
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, business.getName());
			preparedStatement.setString(2, business.getAddress());
			preparedStatement.setString(3, business.getCity());
			preparedStatement.setString(4, business.getState());
			preparedStatement.setString(5, business.getZip());
			preparedStatement.setString(6, business.getPhone());
			preparedStatement.setInt(7, business.getId());
	  		preparedStatement.executeUpdate();
  		} catch (SQLException e) {
   			e.printStackTrace();
  		}
 	}
}