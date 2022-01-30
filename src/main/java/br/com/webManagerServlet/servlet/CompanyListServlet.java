package br.com.webManagerServlet.servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/companiesList")
public class CompanyListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Banco banco = new Banco();
		List<Company> list = banco.getCompanyList();

		/* Add list to request */
		request.setAttribute("companies", list);
		/* Dispatch attached to request*/
		RequestDispatcher rd = request.getRequestDispatcher("/companiesList.jsp");
		rd.forward(request, response);
		
//		response.sendRedirect(...);
	}

}
