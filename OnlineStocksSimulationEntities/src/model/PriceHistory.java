package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the price_history database table.
 * 
 */
@Entity
@Table(name="price_history")
@NamedQuery(name="PriceHistory.findAll", query="SELECT p FROM PriceHistory p")
public class PriceHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PriceHistoryPK id;

	private double price;

	//bi-directional many-to-one association to Stock
	@ManyToOne
	@JoinColumn(name="SPK")
	private Stock stock;

	public PriceHistory() {
	}

	public PriceHistoryPK getId() {
		return this.id;
	}

	public void setId(PriceHistoryPK id) {
		this.id = id;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Stock getStock() {
		return this.stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

}