package payday;

// Worktime Object
public class Worktime {

	public int id;
	public String timeIn;
	public String timeOut;

	public Worktime(int id, String ti, String to) {
		this.id = id;
		this.timeIn = ti;
		this.timeOut = to;
	}
	public Worktime() {
	}

	@Override
	public String toString() {
		String template = "Worktime [ id: %d, time in: %s, time out: %s ]";
		String returnString = String.format(template, id, timeIn, timeOut);
		return returnString;
	}

	// Worktime Getters
	public int getId() {
		return id;
	}
	public String getTimeIn() {
		return timeIn;
	}
	public String getTimeOut() {
		return timeOut;
	}

	// Worktime Setters
	public void setId(int id) {
		this.id = id;
	}
	public void setTimeIn(String ti) {
		this.timeIn = ti;
	}
	public void setTimeOut(String to) {
		this.timeOut = to;
	}
}