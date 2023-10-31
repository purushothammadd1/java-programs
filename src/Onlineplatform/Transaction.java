package Onlineplatform;

import java.sql.Timestamp;

public class Transaction {
	private int transactionId;
	private Timestamp transactionDate;
	
	
	public Transaction() {
		super();
	}

	public Transaction(int transactionId, Timestamp transactionDate) {
		
		this.transactionId = transactionId;
		this.transactionDate = transactionDate;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public Timestamp getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	
	

}
