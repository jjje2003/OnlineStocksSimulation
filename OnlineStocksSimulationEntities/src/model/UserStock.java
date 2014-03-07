package model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the user_stock database table.
 * 
 */
@Entity
@Table(name="user_stock")
@NamedQuery(name="UserStock.findAll", query="SELECT u FROM UserStock u")
public class UserStock implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserStockPK id;

	@Column(name="BUY_IN_PRICE")
	private double buyInPrice;

	private int quantity;
	
	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="UPK")
	private User user;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="SPK")
	private Stock stock;	
	
	
	public UserStock() {
	}

	public UserStockPK getId() {
		return this.id;
	}

	public void setId(UserStockPK id) {
		this.id = id;
	}

	public double getBuyInPrice() {
		return this.buyInPrice;
	}

	public void setBuyInPrice(double buyInPrice) {
		this.buyInPrice = buyInPrice;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

}