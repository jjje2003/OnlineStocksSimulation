package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the transaction database table.
 * 
 */
@Entity
@NamedQuery(name="Transaction.findAll", query="SELECT t FROM Transaction t")
public class Transaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int tranid;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="TRAN_DATE")
	private Date tranDate;

	@Column(name="TRANSACTION_TYPE")
	private String transactionType;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="TUPK")
	private User user;

	//bi-directional many-to-one association to TranStock
	@OneToMany(mappedBy="transaction")
	private List<TranStock> tranStocks;

	public Transaction() {
	}

	public int getTranid() {
		return this.tranid;
	}

	public void setTranid(int tranid) {
		this.tranid = tranid;
	}

	public Date getTranDate() {
		return this.tranDate;
	}

	public void setTranDate(Date tranDate) {
		this.tranDate = tranDate;
	}

	public String getTransactionType() {
		return this.transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<TranStock> getTranStocks() {
		return this.tranStocks;
	}

	public void setTranStocks(List<TranStock> tranStocks) {
		this.tranStocks = tranStocks;
	}

	public TranStock addTranStock(TranStock tranStock) {
		getTranStocks().add(tranStock);
		tranStock.setTransaction(this);

		return tranStock;
	}

	public TranStock removeTranStock(TranStock tranStock) {
		getTranStocks().remove(tranStock);
		tranStock.setTransaction(null);

		return tranStock;
	}

}