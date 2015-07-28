package hello;


// Employee Object
public class Employee {

	public int id;
	public String email;
	public String password;
	public String firstName;
	public String lastName;
	public String	bio;
	public boolean isManager;
	public String	phone;
	public String	image;

	public Employee(int id, String email, String pass, String fn, String ln, String bio, boolean im, String phone, String img) {
		this.id = id;
		this.email = email;
		this.password = pass;
		this.firstName = fn;
		this.lastName = ln;
		this.bio = bio;
		this.isManager = im;
		this.phone = phone;
		this.image = img;
	}

	@Override
	public String toString() {
		String template = "Employee [ id: %d, email: %s, password: %s, name: %s %s, bio: %s, phone: %s ]";
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
	public String getPhone() {
		return phone;
	}
	public String getImage() {
		return image;
	}

	// Employee Setters
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
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setImage(String img) {
		this.image = img;
	}
}