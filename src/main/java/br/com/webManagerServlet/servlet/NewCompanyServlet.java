package br.com.webManagerServlet.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/newCompany")
public class NewCompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Registering new company");

		/* .getParameter always return a String */
		String companyName = request.getParameter("name");
		String companyOpeningDate = request.getParameter("date");
		
//		Reading and Parsing
		Date openingDate = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			openingDate = sdf.parse(companyOpeningDate);
		} catch (ParseException e) {
			throw new ServletException(e);
		}

		Company company = new Company();
		company.setName(companyName);
		company.setOpeningDate(openingDate);
		
		Banco banco = new Banco();
		banco.adiciona(company);

        request.setAttribute("company", company.getName());

        //redirecionando pelo navegador
        response.sendRedirect("companiesList");
	}

}
