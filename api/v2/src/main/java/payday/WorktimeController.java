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
public class WorktimeController {
  
  int counter = 2;

  WorktimeService worktimeService = new WorktimeService();

	// Get all worktimes
	@RequestMapping( value = "/api/businesses/1/employees/{employeeID}/worktimes", method = RequestMethod.GET )
	public List<Worktime> getAll() {
		List<Worktime> worktimes = WorktimeService.getAllWorktimes(1);
		return worktimes;
	}
	
	// Create new worktime	
	@RequestMapping( value = "/api/businesses/1/employees/{employeeID}/worktimes", method = RequestMethod.POST )
	public Worktime create(
		@RequestParam(value="timein") String timeIn, 
		@RequestParam(value="timeout") String timeOut) throws ParseException
	{

		Worktime worktime = new Worktime(counter, timeIn, timeOut);
		counter++;
		WorktimeService.createWorktime(worktime);

		return worktime;
	}

	// Get worktime	
	@RequestMapping( value = "/api/businesses/1/employees/{employeeID}/worktimes/{worktimeID}", method = RequestMethod.GET )
	public Worktime get(@PathVariable int employeeID, @PathVariable int worktimeID) {
		return WorktimeService.getWorktime(worktimeID);
	}

	// Update worktime
	@RequestMapping( value = "/api/businesses/1/employees/{employeeID}/worktimes/{worktimeID}", method = RequestMethod.PUT )
	public Worktime update(
		@PathVariable int employeeID,
		@PathVariable int worktimeID,
		@RequestParam(value="timein") String timeIn, 
		@RequestParam(value="timeout") String timeOut) throws ParseException
	{
		Worktime worktime = new Worktime();

		worktime.setId(worktimeID);
		worktime.setTimeIn(timeIn);
		worktime.setTimeOut(timeOut);

		WorktimeService.updateWorktime(worktime);

		return worktime;
	}

	// Delete worktime
	@RequestMapping( value = "/api/businesses/1/employees/{employeeID}/worktimes/{worktimeID}", method = RequestMethod.DELETE )
	public String delete(@PathVariable int employeeID, @PathVariable int worktimeID) {
		
		WorktimeService.deleteWorktime(worktimeID);
		return "HTTP 200 OK: Worktime worktime deleted from database.";
	}
}