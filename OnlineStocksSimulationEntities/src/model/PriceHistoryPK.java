package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the price_history database table.
 * 
 */
@Embeddable
public class PriceHistoryPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATE_TIME")
	private java.util.Date dateTime;

	private int spk;

	public PriceHistoryPK() {
	}
	public java.util.Date getDateTime() {
		return this.dateTime;
	}
	public void setDateTime(java.util.Date dateTime) {
		this.dateTime = dateTime;
	}
	public int getSpk() {
		return this.spk;
	}
	public void setSpk(int spk) {
		this.spk = spk;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PriceHistoryPK)) {
			return false;
		}
		PriceHistoryPK castOther = (PriceHistoryPK)other;
		return 
			this.dateTime.equals(castOther.dateTime)
			&& (this.spk == castOther.spk);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.dateTime.hashCode();
		hash = hash * prime + this.spk;
		
		return hash;
	}
}