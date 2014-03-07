package stock.servlet;


import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import stocks.model.gameControllerLocal;
import model.*;


/**
 * Servlet implementation class OptionServlet
 */
@WebServlet("/OptionServlet")
public class OptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB 
	gameControllerLocal gameController;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String userName = (String)session.getAttribute("userID");
		String option = request.getParameter("option").toLowerCase().trim();
		String page = "";
		if (option.equals("market list")){			
			List<Stock> stockList = gameController.listMarketStocks();
			request.setAttribute("marketStocks", stockList);			
			page = "marketStocks.jsp";
			
		}else if (option.equals("buy")){			
			List<Stock> stockList = gameController.listMarketStocks();
			request.setAttribute("marketStocks", stockList);		
			page = "buyStocks.jsp";
			
		}else if (option.equals("sell")){
			
			page = "sellStock.jsp";			
			//List onhandStocks = gameController.listUserStocks(user.getUserid());
			/*if(onhandStocks == null){
				request.setAttribute("errorMsg", "No stock on hand to sell!");
				request.setAttribute("disable", "disabled");
			}
			else{				
				request.setAttribute("onhandStocks", onhandStocks);
				request.setAttribute("msg", "Please select the quantity of each stock item you want to sell, and then click Sell Now.");
				
			}*/
			
		}else if (option.equals("my account")){
			page = "accountSummary.jsp";
			
			/*List onhandStocks = gamecontroller.listUserStocks();
			if(onhandStocks == null){
				request.setAttribute("msg", "Your account is empty!");
			}
			else{
				request.setAttribute("onhandStocks", onhandStocks);
			}	*/		
			
		}else if (option.equals("logout")){
			page = "index.jsp";			
			session.invalidate();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
