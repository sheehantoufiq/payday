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

public class TransactionService {

	private static Connection connection = DBUtil.getConnection();

	public TransactionService() {
		connection = DBUtil.getConnection();
	}

	public static float getAccountBalance(int businessID) {
		float balance = 0;
		try {
			String query = ("select type, amount from transaction_table where business_id=?");
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, businessID);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				if (rs.getBoolean("type") == false) {
					balance -= rs.getFloat("amount");
				} else {
					balance += rs.getFloat("amount");
				}
			}
  	} catch (SQLException e) {
   		e.printStackTrace();
  	}
  	return balance;
	}

	public static float getTotalBalance(int businessID) {
		float balance = 0;
		try {
			String query = "select account_balance from transaction_table where business_id=? order by id desc limit 1";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, businessID);
			ResultSet rs = preparedStatement.executeQuery();
			balance = rs.getFloat("account_balance");
  	} catch (SQLException e) {
   		e.printStackTrace();
  	}
  	return balance;
	}

	public static List<Transaction> getAllTransactions(int businessID) {
		List<Transaction> transactions = new ArrayList<Transaction>();
		try {
			String query = "select * from transaction_table where business_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, businessID);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Transaction transaction = new Transaction();
				transaction.setId(rs.getInt("transaction_id"));
				transaction.setType(rs.getBoolean("type"));
				transaction.setCategory(rs.getString("category"));
				transaction.setDescription(rs.getString("description"));
				transaction.setAmount(rs.getFloat("amount"));
				transaction.setTransactionDate(rs.getString("transaction_date"));
				transaction.setAccountBalance(rs.getFloat("account_balance"));
				transactions.add(transaction);
			}
		} catch (SQLException e) {
			e.printStackTrace();			
		}
		return transactions;
	}

	public static void createTransaction(Transaction transaction) throws ParseException {
		try {
			String query = "insert into transaction_table(business_id, transaction_id, type, category, description, amount, transaction_date, account_balance) values (?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, 1);
			preparedStatement.setInt(2, transaction.getId());
			preparedStatement.setBoolean(3, transaction.getType());
			preparedStatement.setString(4, transaction.getCategory());
			preparedStatement.setString(5, transaction.getDescription());
			preparedStatement.setFloat(6, transaction.getAmount());
			preparedStatement.setString(7, transaction.getTransactionDate());
			preparedStatement.setFloat(8, transaction.getAccountBalance());
	  	preparedStatement.executeUpdate();
  	} catch (SQLException e) {
   		e.printStackTrace();
  	}
	}

	public static Transaction getTransaction(int transactionID) {
		Transaction transaction = new Transaction();
		try {
			String query = "select * from transaction_table where transaction_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, transactionID);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				transaction.setId(rs.getInt("transaction_id"));
				transaction.setType(rs.getBoolean("type"));
				transaction.setCategory(rs.getString("category"));
				transaction.setDescription(rs.getString("description"));
				transaction.setAmount(rs.getFloat("amount"));
				transaction.setTransactionDate(rs.getString("transaction_date"));
				transaction.setAccountBalance(rs.getFloat("account_balance"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return transaction;		
	}

	public static void updateTransaction(Transaction transaction) throws ParseException {
		 try {
			String query = "update transaction_table set type=?, category=?, description=?, amount=?, transaction_date=?, account_balance=? where transaction_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, 1);
			preparedStatement.setInt(2, transaction.getId());
			preparedStatement.setBoolean(3, transaction.getType());
			preparedStatement.setString(4, transaction.getCategory());
			preparedStatement.setString(5, transaction.getDescription());
			preparedStatement.setFloat(6, transaction.getAmount());
			preparedStatement.setString(7, transaction.getTransactionDate());
			preparedStatement.setFloat(8, transaction.getAccountBalance());
	  	preparedStatement.executeUpdate();
  	} catch (SQLException e) {
   		e.printStackTrace();
  	}
	}
	public static void deleteTransaction(int transactionID) {
		try {
			String query = "delete from transaction_table where transaction_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, transactionID);
	  	preparedStatement.executeUpdate();

  	} catch (SQLException e) {
   		e.printStackTrace();
  	}
	}
}