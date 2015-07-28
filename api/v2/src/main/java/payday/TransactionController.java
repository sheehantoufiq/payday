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
public class TransactionController {

  TransactionService transactionService = new TransactionService();
  int counter = 2;

	// Get all transactions
	@RequestMapping( value = "/api/businesses/1/transactions", method = RequestMethod.GET )
	public List<Transaction> getAll() {

		List<Transaction> transactions = TransactionService.getAllTransactions(1);
		return transactions;
	}

	// Create new transaction	
	@RequestMapping( value = "/api/businesses/1/transactions", method = RequestMethod.POST )
	public Transaction create(
		@RequestParam(value="type") boolean type,
		@RequestParam(value="cat") String cat, 
		@RequestParam(value="des") String des, 
		@RequestParam(value="amt") float amt,
		@RequestParam(value="tdate") String tdate) throws ParseException
	{

		Transaction transaction = new Transaction();

		transaction.setId(counter);
		counter++;
		transaction.setType(type);
		transaction.setCategory(cat);
		transaction.setDescription(des);
		transaction.setAmount(amt);
		transaction.setTransactionDate(tdate);

		float abalance = TransactionService.getAccountBalance(1);

		if (type = false) {
			abalance -= amt;
		} else {
			abalance += amt;
		}

		transaction.setAccountBalance(abalance);
		
		TransactionService.createTransaction(transaction);

		return transaction;

	}

	// Get transaction	
	@RequestMapping( value = "/api/businesses/1/transactions/{transactionID}", method = RequestMethod.GET )
	public Transaction get(@PathVariable int transactionID) {
		return TransactionService.getTransaction(transactionID);
	}

	// Get account balance
	@RequestMapping( value = "/api/businesses/1/balance", method = RequestMethod.GET )
	public String getBalance() {
		float amount = TransactionService.getTotalBalance(1);
		String template = "%.2f";
		String returnAmount = String.format(template, amount);

		return returnAmount;
	}

	// Update transaction
	@RequestMapping( value = "/api/businesses/1/transactions/{transactionID}", method = RequestMethod.PUT )
	public Transaction update(
		@PathVariable int transactionID,
		@RequestParam(value="type") boolean type,
		@RequestParam(value="cat") String cat, 
		@RequestParam(value="des") String des, 
		@RequestParam(value="amt") float amt,
		@RequestParam(value="tdate") String tdate) throws ParseException
	{
		Transaction transaction = new Transaction();

		transaction.setId(transactionID);
		transaction.setType(type);
		transaction.setCategory(cat);
		transaction.setDescription(des);
		transaction.setAmount(amt);
		transaction.setTransactionDate(tdate);

		float abalance = TransactionService.getAccountBalance(1);

		if (type = false) {
			abalance -= amt;
		} else {
			abalance += amt;
		}

		transaction.setAccountBalance(abalance);
		TransactionService.updateTransaction(transaction);

		return transaction;
	}

	// Delete transaction
	@RequestMapping( value = "/api/businesses/1/transactions/{transactionID}", method = RequestMethod.DELETE )
	public String delete(@PathVariable int transactionID) {

		TransactionService.deleteTransaction(transactionID);
		return "HTTP 200 OK: Transaction deleted from database.";
	}
}