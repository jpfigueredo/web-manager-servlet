package br.com.webManagerServlet.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/removeCompany")
public class RemoveCompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idParam = request.getParameter("id");
		Integer id = Integer.valueOf(idParam);
		System.out.println(id);

		Banco banco = new Banco();
		banco.removeCompany(id);
		response.sendRedirect("companiesList");

	}

}
