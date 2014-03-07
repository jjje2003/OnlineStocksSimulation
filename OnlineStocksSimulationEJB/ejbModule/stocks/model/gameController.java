package stocks.model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Stock;
import model.User;

/**
 * Session Bean implementation class gameController
 */
@Stateless
public class gameController implements gameControllerLocal {
	@PersistenceContext(name="OnlineStocksSimulationEntities")
	EntityManager em;
    /**
     * Default constructor. 
     */
    public gameController() {
        // TODO Auto-generated constructor stub
    }

    public User getUser(String name, String password){
    	Query q = em.createQuery("select u from User u where u.userid = ?0  AND u.userpw = ?1");
    	q.setParameter(0, name);	
    	q.setParameter( 1, password);
    	List<User> users =  q.getResultList();
    	
    	if (users.size() <= 0){
    		return null;
    	}
    	else {
    		return users.get(0);
    	}
    }

	@Override
	public List<Stock> listMarketStocks() {
		// TODO Auto-generated method stub
		Query q = em.createNamedQuery("Stock.findAll");
		List<Stock> marketStocks = q.getResultList();
		
		if (marketStocks.size() <= 0){
    		return null;
    	}
    	else {
    		return marketStocks;
    	}		
	}

	@Override
	public boolean createNewUser(User newUser) {
		// TODO Auto-generated method stub
		em.persist(newUser);
		User user = getUser(newUser.getUserid(), newUser.getUserpw());
		if (user == null)
		{
			return false;
		}
		else{
			return true;
		}
	}
}
