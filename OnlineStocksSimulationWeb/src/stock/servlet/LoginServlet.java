package stock.servlet;

import java.io.IOException;
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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	@EJB 
	gameControllerLocal gameController;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String username = request.getParameter("userName").trim();
		String password = request.getParameter("password").trim();
		HttpSession session = request.getSession();
		String page = "";
		
		if(username.isEmpty() || password.isEmpty())
		{
			request.setAttribute("error_msg", "Please fill in all fields");
			page = "index.jsp";	
		}
		else{			
			User user = gameController.getUser(username, password);
			// Check user name and password
			if (user == null){
				request.setAttribute("error_msg", "(Your user name or password is incorrect!)");
				page = "index.jsp";
			}
			else {					
				session.setAttribute("userID", user.getUserid());
				session.setAttribute("password", user.getUserpw());			
				
				request.setAttribute("cash", user.getCash());
				
				//List onhandStocks = gameController.getUserStocks(username);
				
				page = "accountSummary.jsp";
			}			
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
