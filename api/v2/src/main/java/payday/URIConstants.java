package payday;

public class URIConstants {

	// URIs
	public final String URI_BUSINESSES 		= "/api/businesses";

	public final String URI_BUSINESS 			= URI_BUSINESSES		+ "/{businessID}";
	public final String URI_EMPLOYEES 		= URI_BUSINESS 			+ "/employees";
	public final String URI_EMPLOYEE 			= URI_EMPLOYEES 		+ "/{employeeID}";
	public final String URI_WORKTIMES 		= URI_EMPLOYEE 			+ "/worktimes";
	public final String URI_WORKTIME 			= URI_WORKTIMES 		+ "/{worktimeID}";
	public final String URI_TRANSACTIONS 	= URI_BUSINESS 			+ "/transactions";
	public final String URI_TRANSACTION 	= URI_TRANSACTIONS	+ "/{transactionID}";
	public final String URI_CATEGORIES		= URI_BUSINESSES		+ "/categories";
	public final String URI_CATEGORY			= URI_CATEGORIES		+ "/{categoryID}";

}