package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;

import pojos.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() throws ServletException {

		// user dao instance
		try {
			userDao = new UserDao();
		} catch (Exception e) {
			// To inform WC that init() has failed : re throw the exception , wrapped in
			// ServletException
			// ServletException(String errMesg,Throwable e)
			throw new ServletException("err in init of " + getClass(), e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Object error = request.getAttribute("error");
		if (error != null) {
			pw.write("error Occures");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		try {

			String email = (String) request.getParameter("name");
			String password = request.getParameter("password");
			System.out.println(email + password);
			User foundUser = userDao.authenticateUser(email, password);

			if (foundUser == null) {
				System.out.println("------------------");
				request.setAttribute("error", "User Not Found");

//				request.getRequestDispatcher("/");
				response.sendRedirect("/PracticeServletJdbc");

			} else {

//				request.setAttribute("user",foundUser.getName());
//				request.getRequestDispatcher("/HomeServlet").forward(request, response);
				HttpSession session = request.getSession();

				session.setAttribute("user", foundUser.getName());

				response.sendRedirect("HomeServlet");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception occures in @ LoginServlet => doPost method");
			e.printStackTrace();
		}

	}

}
