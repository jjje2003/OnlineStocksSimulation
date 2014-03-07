package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tran_stock database table.
 * 
 */
@Entity
@Table(name="tran_stock")
@NamedQuery(name="TranStock.findAll", query="SELECT t FROM TranStock t")
public class TranStock implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TranStockPK id;

	private int quantity;

	//bi-directional many-to-one association to Transaction
	@ManyToOne
	@JoinColumn(name="TRANID")
	private Transaction transaction;

	//bi-directional many-to-one association to Stock
	@ManyToOne
	@JoinColumn(name="SPK")
	private Stock stock;

	public TranStock() {
	}

	public TranStockPK getId() {
		return this.id;
	}

	public void setId(TranStockPK id) {
		this.id = id;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Transaction getTransaction() {
		return this.transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public Stock getStock() {
		return this.stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

}