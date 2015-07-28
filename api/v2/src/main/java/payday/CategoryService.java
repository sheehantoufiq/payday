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

public class CategoryService {

	private static Connection connection = DBUtil.getConnection();

	public CategoryService() {
		connection = DBUtil.getConnection();
	}

	public static List<Category> getAllCategories(int businessID) {
		List<Category> categories = new ArrayList<Category>();
		try {
			String query = "select * from category_table where business_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, businessID);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt("category_id"));
				category.setName(rs.getString("category_name"));
				categories.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();			
		}
		return categories;
	}

	public static void createCategory(Category category) throws ParseException {
		try {
			String query = ("insert into category_table(business_id, category_id, category_name) values (?,?,?)");
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, 1);
			preparedStatement.setInt(2, category.getId());
			preparedStatement.setString(3, category.getName());
	  	preparedStatement.executeUpdate();
  	} catch (SQLException e) {
   		e.printStackTrace();
  	}
	}

	public static Category getCategory(int categoryID) {
		Category category = new Category();
		try {
			String query = "select * from category_table where category_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, categoryID);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				category.setId(rs.getInt("category_id"));
				category.setName(rs.getString("category_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return category;		
	}

	public static void updateCategory(Category category) throws ParseException {
		 try {
			String query = ("update category_table set name=?");
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, category.getName());
	  	preparedStatement.executeUpdate();
  	} catch (SQLException e) {
   		e.printStackTrace();
  	}
	}

	public static void deleteCategory(int categoryID) {
		try {
			String query = ("delete from category_table where category_id=?");
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, categoryID);
	  	preparedStatement.executeUpdate();

  	} catch (SQLException e) {
   		e.printStackTrace();
  	}
	}
}