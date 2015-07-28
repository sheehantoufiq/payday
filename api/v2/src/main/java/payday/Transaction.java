package payday;


// Transaction Object
public class Transaction {

	public int id;
	public boolean type;
	public String category;
	public String description;
	public float amount;
	public String transactionDate;
	public float accountBalance;

	public Transaction(int id, boolean type, String cat, String des, float amt, String td, float ab) {
		this.id = id;
		this.type = type;
		this.category = cat;
		this.description = des;
		this.amount = amt;
		this.transactionDate = td;
		this.accountBalance = ab;
	}

	public Transaction() {
	}

	@Override
	public String toString() {
		String template = "Transaction [ id: %d, type: %b, category: %s, description: %s, amount: %.2f, transaction-date: %s, account-balance: %.2f ]";
		String returnString = String.format(template, id, type, category, description, amount, transactionDate, accountBalance);
		return returnString;
	}

	// Transaction Getters
	public int getId() {
		return id;
	}
	public boolean getType() {
		return type;
	}
	public String getCategory() {
		return category;
	}
	public String getDescription() {
		return description;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public float getAmount() {
		return amount;
	}
	public float getAccountBalance() {
		return accountBalance;
	}

	// Transaction Setters
	public void setId(int id) {
		this.id = id;
	}
	public void setType(boolean type) {
		this.type = type;
	}
	public void setCategory(String cat) {
		this.category = cat;
	}
	public void setDescription(String des) {
		this.description = des;
	}
	public void setAmount(float amt) {
		this.amount = amt;
	}
	public void setTransactionDate(String td) {
		this.transactionDate = td;
	}
	public void setAccountBalance(float ab) {
		this.accountBalance = ab;
	}
}