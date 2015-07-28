package payday;


public class Employee {

	public int id;
	public String email;
	public String password;
	public String firstName;
	public String lastName;
	public String	bio;
	public boolean isManager = false;
	public float wage;
	public String	phone;
	public String	image;

	public Employee(int id, boolean im) {
		this.id = id;
		this.isManager = im;
	}

	public Employee(int id, String email, String pass, String fn, String ln, String bio, float wage, String phone, String img) {
		this.id = id;
		this.email = email;
		this.password = pass;
		this.firstName = fn;
		this.lastName = ln;
		this.bio = bio;
		this.wage = wage;
		this.phone = phone;
		this.image = img;
	}
	
	public Employee() {
	}

	@Override
	public String toString() {
		String template = "Employee [ id: %d, email: %s, password: %s, name: %s %s, wage: %.2f, bio: %s, phone: %s ]";
		String returnString = String.format(template, id, email, password, firstName, lastName, bio, phone);
		return returnString;
	}

	// Employee Getters
	public int getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getBio() {
		return bio;
	}
	public boolean getIsManager() {
		return isManager;
	}
	public float getWage() {
		return wage;
	}
	public String getPhone() {
		return phone;
	}
	public String getImage() {
		return image;
	}

	// Employee Setters
	public void setId(int id) {
		this.id = id;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String pass) {
		this.password = pass;
	}
	public void setFirstName(String fn) {
		this.firstName = fn;
	}
	public void setLastName(String ln) {
		this.lastName = ln;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public void setIsManager(boolean im) {
		this.isManager = im;
	}
	public void setWage(float wage) {
		this.wage = wage;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setImage(String img) {
		this.image = img;
	}
}