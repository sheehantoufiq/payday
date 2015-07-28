/*
	Playground for testing api built on spring.io / pseudocode
	@author: sheehantoufiq 
*/

package payday;


/*
	Specify imports 
*/


/*
	Objects
*/

/*
	Mapping
*/

@RestController
@RequestMapping(value = "/api/businesses")
public class BusinessController {

	// URLs
	String URL_BUSINESS 		= "/{businessID}";
	String URL_EMPLOYEES 		= URL_BUSINESS 			+ "/employees";
	String URL_EMPLOYEE 		= URL_EMPLOYEES 		+ "/{employeeID}";
	String URL_WORKTIMES 		= URL_EMPLOYEE 			+ "/worktimes";
	String URL_WORKTIME 		= URL_WORKTIMES 		+ "/{worktimeID}";
	String URL_TRANSACTIONS = URL_BUSINESS 			+ "/transactions";
	String URL_TRANSACTION 	= URL_TRANSACTIONS	+ "/{transactionID}";
	String URL_CATEGORIES;
	String URL_CATEGORY;

	// Get business
	@RequestMapping( value = "/{businessID}", method = RequestMethod.GET )
	public Business get(@PathVariable String businessID) {}

	// Update business
	@RequestMapping( value = "/{businessID}", method = RequestMethod.PUT )
	public Business update(@PathVariable String businessID) {}

	// Get all employees
	@RequestMapping( value = "/{businessID}/employees", method = RequestMethod.GET )
	public Employee getAll(@PathVariable String businessID) {}
	
	// Create new employee	
	@RequestMapping( value = "/{businessID}/employees", method = RequestMethod.POST )
	public Employee create(@PathVariable String businessID) {}

	// Get employee	
	@RequestMapping( value = "/{businessID}/employees/{employeeID}", method = RequestMethod.GET )
	public Employee get(	@PathVariable String businessID, 
												@PathVariable String employeeID) {}

	// Update employee
	@RequestMapping( value = "/{businessID}/employees/{employeeID}", method = RequestMethod.PUT )
	public Employee update(	@PathVariable String businessID, 
													@PathVariable String employeeID) {}

	// Delete employee
	@RequestMapping( value = "/{businessID}/employees/{employeeID}", method = RequestMethod.DELETE )
	public Employee delete(	@PathVariable String businessID, 
													@PathVariable String employeeID) {}

	// Get all worktimes
	@RequestMapping( value = "/{businessID}/employees/{employeeID}/worktimes", method = RequestMethod.GET )
	public Worktime getAll(	@PathVariable String businessID, 
													@PathVariable String employeeID) {}

	// Create worktime
	@RequestMapping( value = "/{businessID}/employees/{employeeID}/worktimes", method = RequestMethod.POST )
	public Worktime create(	@PathVariable String businessID, 
													@PathVariable String employeeID) {}

	// Get worktime
	@RequestMapping( value = "/{businessID}/employees/{employeeID}/worktimes/{worktimeID}", method = RequestMethod.GET )
	public Worktime get(	@PathVariable String businessID, 
												@PathVariable String employeeID, 
												@PathVariable String worktimeID) {}

	// Update worktime
	@RequestMapping( value = "/{businessID}/employees/{employeeID}/worktimes/{worktimeID}", method = RequestMethod.PUT )
	public Worktime update(	@PathVariable String businessID, 
													@PathVariable String employeeID, 
													@PathVariable String worktimeID) {}

	// Delete worktime
	@RequestMapping( value = "/{businessID}/employees/{employeeID}/worktimes/{worktimeID}", method = RequestMethod.DELETE )
	public Worktime delete(	@PathVariable String businessID, 
													@PathVariable String employeeID, 
													@PathVariable String worktimeID) {}

	// Get all transactions
	@RequestMapping( value = "/{businessID}/transactions", method = RequestMethod.GET )
	public Transaction getAll(@PathVariable String businessID) {}

	// Create transaction
	@RequestMapping( value = "/{businessID}/transactions", method = RequestMethod.POST )
	public Transaction create(@PathVariable String businessID) {}

	// Get transaction
	@RequestMapping( value = "/{businessID}/transactions/{transactionID}", method = RequestMethod.GET )
	public Transaction get(	@PathVariable String businessID, 
													@PathVariable String transactionID) {}

	// Update transaction
	@RequestMapping( value = "/{businessID}/transactions/{transactionID}", method = RequestMethod.PUT )
	public Transaction update(@PathVariable String businessID, @PathVariable String transactionID) {}

	// Delete transaction
	@RequestMapping( value = "/{businessID}/transactions/{transactionID}", method = RequestMethod.DELETE )
	public Transaction delete(	@PathVariable String businessID, 
															@PathVariable String transactionID) {}

	// Get all categories
	@RequestMapping( value = "/{businessID}/categories", method = RequestMethod.GET )
	public Category getAll(@PathVariable String businessID) {}

	// Create category
	@RequestMapping( value = "/{businessID}/categories", method = RequestMethod.POST )
	public Category create(@PathVariable String businessID) {}

	// Get category
	@RequestMapping( value = "/{businessID}/categories/{categoryID}", method = RequestMethod.GET )
	public Category get(	@PathVariable String businessID, 
												@PathVariable String categoryID) {}

	// Update category
	@RequestMapping( value = "/{businessID}/categories/{categoryID}", method = RequestMethod.PUT )
	public Category update(	@PathVariable String businessID, 
													@PathVariable String categoryID) {}

	// Delete category
	@RequestMapping( value = "/{businessID}/categories/{categoryID}", method = RequestMethod.DELETE )
	public Category delete(	@PathVariable String businessID, 
													@PathVariable String categoryID) {}

	// Login
	@RequestMapping( value = "/", method = RequestMethod.POST )  // Login
	public Business login() {}


	//db methods

	public Business getBusiness(int businessID) {
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

	public void updateBusiness(Business business) throws ParseException {
	  try {
			String query = ("update business_table set business_name=?, address=?, city=?, state=?, zip=?, phone=? where task_id=?");
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, business.setName());
			preparedStatement.setString(2, business.setAddress());
			preparedStatement.setString(3, business.setCity());
			preparedStatement.setString(4, business.setState());
			preparedStatement.setString(5, business.setZip());
			preparedStatement.setString(6, business.setPhone());
			preparedStatement.setInt(7, business.getId());
	  	preparedStatement.executeUpdate();
  	} catch (SQLException e) {
   		e.printStackTrace();
  	}
 	}


	public List<Employee> getAllEmployees() {}
	public Employee createEmployee() {}
	public Employee getEmployee() {}
	public Employee updateEmployee() {}
	public Employee deleteEmployee() {}

	public List<Transaction> getAllTransactions() {}
	public Transaction createTransaction() {}
	public Transaction getTransaction() {}
	public Transaction updateTransaction() {}
	public Transaction deleteTransaction() {}

	public List<Worktime> getAllWorktimes() {}
	public Worktime createWorktime() {}
	public Worktime getWorktime() {}
	public Worktime updateWorktime() {}
	public Worktime deleteWorktime() {}

	public Category getAllCategories() {}
	public Category createCategory() {}
	public Category getCategory() {}
	public Category updateCategory() {}
	public Category deleteCategory() {}

}


























