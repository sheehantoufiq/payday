package payday;


// Category Object
public class Category {

	public int id;
	public String name;

	public Category(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public Category() {
	}

	@Override
	public String toString() {
		String template = "Category [ id: %d, name: %s ]";
		String returnString = String.format(template, id, name);
		return returnString;
	}

	// Category Getters
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}

	// Category Setters
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
}