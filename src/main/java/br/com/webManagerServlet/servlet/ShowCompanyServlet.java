package br.com.webManagerServlet.servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowCompanyServlet
 */
@WebServlet("/showCompany")
public class ShowCompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idParam = request.getParameter("id");
		Integer id = Integer.valueOf(idParam);
		
		Bank bank = new Bank();
		Company company = bank.findById(id);
		System.out.println(company.getName());

		request.setAttribute("company", company);
		
		RequestDispatcher rd = request.getRequestDispatcher("/formAlterCompany.jsp");
		rd.forward(request, response);
	}

}
