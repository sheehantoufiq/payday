package payday;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import java.text.ParseException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class EmployeeController {
  
  //Map<Integer, Employee> employeeData = new HashMap<Integer, Employee>();
  int counter = 2;

  EmployeeService employeeService = new EmployeeService();

	// Get all employees
	@RequestMapping( value = "/api/businesses/1/employees", method = RequestMethod.GET )
	public List<Employee> getAll() {

		/*if (employeeData == null) {
			Employee manager = new Employee(1, true);
 			employeeData.put(manager.getId(), manager);
		}

		List<Employee> employees = new ArrayList<Employee>();
		Set<Integer> employeeIDs = employeeData.keySet();
		for (Integer i : employeeIDs) {
			employees.add(employeeData.get(i));
		}*/
		List<Employee> employees = EmployeeService.getAllEmployees(1);
		return employees;
	}
	
	// Create new employee	
	@RequestMapping( value = "/api/businesses/1/employees", method = RequestMethod.POST )
	public Employee create(
		@RequestParam(value="email") String email, 
		@RequestParam(value="pass") String pass, 
		@RequestParam(value="fname") String fname, 
		@RequestParam(value="lname") String lname,
		@RequestParam(value="bio") String bio,
		@RequestParam(value="wage") float wage,
		@RequestParam(value="phone") String phone,
		@RequestParam(value="img") String image) throws ParseException
	{

		//final AtomicInteger counter = new AtomicInteger();
		Employee employee = new Employee(counter, email, pass, fname, lname, bio, wage, phone, image);
		counter++;
		EmployeeService.createEmployee(employee);
		//employeeData.put(employee.getId(), employee);

		return employee;

	}

	// Get employee	
	@RequestMapping( value = "/api/businesses/1/employees/{employeeID}", method = RequestMethod.GET )
	public Employee get(@PathVariable int employeeID) {
		return EmployeeService.getEmployee(employeeID);
	}

	// Update employee
	@RequestMapping( value = "/api/businesses/1/employees/{employeeID}", method = RequestMethod.PUT )
	public Employee update(
		@PathVariable int employeeID,
		@RequestParam(value="email") String email, 
		@RequestParam(value="pass") String pass, 
		@RequestParam(value="fname") String fname, 
		@RequestParam(value="lname") String lname,
		@RequestParam(value="bio") String bio,
		@RequestParam(value="wage") float wage,
		@RequestParam(value="phone") String phone,
		@RequestParam(value="img") String image) throws ParseException
	{
		Employee employee = new Employee();

		employee.setId(employeeID);
		employee.setEmail(email);
		employee.setPassword(pass);
		employee.setFirstName(fname);
		employee.setLastName(lname);
		employee.setBio(bio);
		employee.setWage(wage);
		employee.setPhone(phone);
		employee.setImage(image);

		//employeeData.put(employeeID, employee);
		EmployeeService.updateEmployee(employee);

		return employee;
	}

	// Delete employee
	@RequestMapping( value = "/api/businesses/1/employees/{employeeID}", method = RequestMethod.DELETE )
	public String delete(@PathVariable int employeeID) {
		

		if (employeeID == 1) {
			return "Manager cannot be deleted";
		} else {
			
			EmployeeService.deleteEmployee(employeeID);
			return "HTTP 200 OK: Employee deleted from database.";
		}

	}

	// Login User
	@RequestMapping( value = "/api/login", method = RequestMethod.PUT )
	public String login(@RequestParam(value="email") String email, @RequestParam(value="pass") String pass) {

		Employee employee = EmployeeService.login(email);
		if (employee == null) {
			return "No user found";
		} else if (!employee.getPassword().equals(pass)) {
			return "Wrong Password";
		} else {
			if (employee.getIsManager() == true) {
				return "Login success: Manager";
			} else {
				return "Login success: Employee";
			}
		}
	}

	@RequestMapping( value = "/api/login", method = RequestMethod.GET )
	public Employee login(@RequestParam(value="email") String email) {

		Employee employee = EmployeeService.login(email);
		return employee;
	}


}