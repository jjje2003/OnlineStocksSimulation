package stock.servlet;



import java.io.IOException;
import java.util.*;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stocks.model.gameControllerLocal;

/**
 * Servlet implementation class SellStockServlet
 */
@WebServlet("/SellStockServlet")
public class SellStockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB 
	gameControllerLocal gameController; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellStockServlet() {
        super();
        // TODO Auto-generated constructor stub
    }	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		double different = 0;		
		String option = request.getParameter("option").toLowerCase().trim();
		String page = "";
		if (option.equals("sell now")){
			page = "confirmation.jsp";
			
			
		}else if (option.equals("cancel")){
			page = "marketStocks.jsp";
			
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
