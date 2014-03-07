package stocks.model;

import java.util.List;

import javax.ejb.Local;

import model.*;


@Local
public interface gameControllerLocal {
	public User getUser(String name, String password);
	public List<Stock> listMarketStocks();
	public boolean createNewUser(User newUser);
}
