package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tran_stock database table.
 * 
 */
@Embeddable
public class TranStockPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int tranid;

	private int spk;

	public TranStockPK() {
	}
	public int getTranid() {
		return this.tranid;
	}
	public void setTranid(int tranid) {
		this.tranid = tranid;
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
		if (!(other instanceof TranStockPK)) {
			return false;
		}
		TranStockPK castOther = (TranStockPK)other;
		return 
			(this.tranid == castOther.tranid)
			&& (this.spk == castOther.spk);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.tranid;
		hash = hash * prime + this.spk;
		
		return hash;
	}
}