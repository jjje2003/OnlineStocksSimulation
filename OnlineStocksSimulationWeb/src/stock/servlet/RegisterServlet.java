package stock.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import stocks.model.gameControllerLocal;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB 
	gameControllerLocal gameController;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		String username = request.getParameter("userName").trim();
		String password = request.getParameter("password").trim();
		String confirmPsw = request.getParameter("confirmpsd").trim();
		
		HttpSession session = request.getSession();
		String page = "";
		
		if(username.isEmpty() || password.isEmpty() || confirmPsw.isEmpty())
		{
			request.setAttribute("error_msg", "Please fill in all fields");
			page = "index.jsp";	
		}
		else{
			User user = gameController.getUser(username, password);
			// Check user name and password
			if (user != null){
				request.setAttribute("error_msg", "User name is existing. Please enter another one!");
				page = "index.jsp";
			}
			else if (!(password.equals(confirmPsw))){
		
			request.setAttribute("error_msg", "Password and Confirm Password are not match");
			page = "index.jsp";
			}
			else{
				User newUser = new User();
				newUser.setUserid(username);
				newUser.setUserpw(password);
				newUser.setCash(100000);
				newUser.setStockvalue(0);
				if(gameController.createNewUser(newUser))
				{
					session.setAttribute("userID", username);
					session.setAttribute("password", password);
					request.setAttribute("cash", 100000);
					page = "accountSummary.jsp";
				}
				else{
					request.setAttribute("error_msg", "User creation did not success. Please try again!");
					page = "index.jsp";
				}
			}
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
