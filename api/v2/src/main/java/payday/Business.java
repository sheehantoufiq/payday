package payday;

import java.util.ArrayList;
import java.util.List;

// Business Object
public class Business {

	public int id;
	public String name;
	public String address;
	public String city;
	public String state;
	public String zip;
	public String phone;

	public Business(int id, String name, String add, String city, String state, String zip, String phone) {
		this.id = id;
		this.name = name;
		this.address = add;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
	}
	
	public Business() {
	}

	@Override
	public String toString() {
		String template = "Business [ id: %d, name: %s, address: %s, city: %s, state: %s, zip: %s, phone: %s ]";
		String returnString = String.format(template, id, name, address, city, state, zip, phone);
		return returnString;
	}

	// Business Getters
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getZip() {
		return zip;
	}
	public String getPhone() {
		return phone;
	}

	// Business Setters
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String add) {
		this.address = add;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}