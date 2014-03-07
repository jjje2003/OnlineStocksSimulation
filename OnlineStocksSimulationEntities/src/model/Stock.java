package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the stock database table.
 * 
 */
@Entity
@NamedQuery(name="Stock.findAll", query="SELECT s FROM Stock s")
public class Stock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int spk;

	private double currentprice;

	private int quantityperslot;

	private String stockid;

	private String stockname;

	//bi-directional many-to-one association to PriceHistory
	@OneToMany(mappedBy="stock")
	private List<PriceHistory> priceHistories;

	//bi-directional many-to-one association to TranStock
	@OneToMany(mappedBy="stock")
	private List<TranStock> tranStocks;
	
	//bi-directional many-to-one association to UserStocks
	@OneToMany(mappedBy="stock")
	private List<UserStock> userStocks;	

	public Stock() {
	}

	public int getSpk() {
		return this.spk;
	}

	public void setSpk(int spk) {
		this.spk = spk;
	}

	public double getCurrentprice() {
		return this.currentprice;
	}

	public void setCurrentprice(double currentprice) {
		this.currentprice = currentprice;
	}

	public int getQuantityperslot() {
		return this.quantityperslot;
	}

	public void setQuantityperslot(int quantityperslot) {
		this.quantityperslot = quantityperslot;
	}

	public String getStockid() {
		return this.stockid;
	}

	public void setStockid(String stockid) {
		this.stockid = stockid;
	}

	public String getStockname() {
		return this.stockname;
	}

	public void setStockname(String stockname) {
		this.stockname = stockname;
	}

	public List<PriceHistory> getPriceHistories() {
		return this.priceHistories;
	}

	public void setPriceHistories(List<PriceHistory> priceHistories) {
		this.priceHistories = priceHistories;
	}

	public PriceHistory addPriceHistory(PriceHistory priceHistory) {
		getPriceHistories().add(priceHistory);
		priceHistory.setStock(this);

		return priceHistory;
	}

	public PriceHistory removePriceHistory(PriceHistory priceHistory) {
		getPriceHistories().remove(priceHistory);
		priceHistory.setStock(null);

		return priceHistory;
	}

	public List<TranStock> getTranStocks() {
		return this.tranStocks;
	}

	public void setTranStocks(List<TranStock> tranStocks) {
		this.tranStocks = tranStocks;
	}

	public TranStock addTranStock(TranStock tranStock) {
		getTranStocks().add(tranStock);
		tranStock.setStock(this);

		return tranStock;
	}

	public TranStock removeTranStock(TranStock tranStock) {
		getTranStocks().remove(tranStock);
		tranStock.setStock(null);

		return tranStock;
	}

	

}