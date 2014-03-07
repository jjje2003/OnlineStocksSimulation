package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the user_stock database table.
 * 
 */
@Embeddable
public class UserStockPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int upk;

	private int spk;

	public UserStockPK() {
	}
	public int getUpk() {
		return this.upk;
	}
	public void setUpk(int upk) {
		this.upk = upk;
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
		if (!(other instanceof UserStockPK)) {
			return false;
		}
		UserStockPK castOther = (UserStockPK)other;
		return 
			(this.upk == castOther.upk)
			&& (this.spk == castOther.spk);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.upk;
		hash = hash * prime + this.spk;
		
		return hash;
	}
}