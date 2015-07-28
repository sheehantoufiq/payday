package hello;


// Transaction Object
public class Transaction {

	public int id;
	public String type;
	public String category;
	public String description;
	public double amount;

	public Transaction(int id, String type, String cat, String des, double amt) {
		this.id = id;
		this.type = type;
		this.category = cat;
		this.description = des;
		this.amount = amt;
	}

	@Override
	public String toString() {
		String template = "Transaction [ id: %d, type: %s, category: %s, description: %s, amount: %.2f ]";
		String returnString = String.format(template, id, type, category, description, amount);
		return returnString;
	}

	// Transaction Getters
	public int getId() {
		return id;
	}
	public String getType() {
		return type;
	}
	public String getCategory() {
		return category;
	}
	public String getDescription() {
		return description;
	}
	public double getAmount() {
		return amount;
	}

	// Transaction Setters
	public void setType(String type) {
		this.type = type;
	}
	public void setCategory(String cat) {
		this.category = cat;
	}
	public void setDescription(String des) {
		this.description = des;
	}
	public void setAmount(double amt) {
		this.amount = amt;
	}
}