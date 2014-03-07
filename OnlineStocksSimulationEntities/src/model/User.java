package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int upk;

	private double cash;

	private double stockvalue;

	private String userid;

	private String userpw;

	//bi-directional many-to-one association to Transaction
	@OneToMany(mappedBy="user")
	private List<Transaction> transactions;
	
	//bi-directional many-to-one association to UserStocks
	@OneToMany(mappedBy="user")
	private List<UserStock> userStocks;

	public User() {
	}

	public int getUpk() {
		return this.upk;
	}

	public void setUpk(int upk) {
		this.upk = upk;
	}

	public double getCash() {
		return this.cash;
	}

	public void setCash(double cash) {
		this.cash = cash;
	}

	public double getStockvalue() {
		return this.stockvalue;
	}

	public void setStockvalue(double stockvalue) {
		this.stockvalue = stockvalue;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpw() {
		return this.userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}

	public List<Transaction> getTransactions() {
		return this.transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Transaction addTransaction(Transaction transaction) {
		getTransactions().add(transaction);
		transaction.setUser(this);

		return transaction;
	}

	public Transaction removeTransaction(Transaction transaction) {
		getTransactions().remove(transaction);
		transaction.setUser(null);

		return transaction;
	}

	public List<UserStock> getUserStocks() {
		return this.userStocks;
	}

	public void setUserStocks(List<UserStock> userStocks) {
		this.userStocks = userStocks;
	}
	
	

}