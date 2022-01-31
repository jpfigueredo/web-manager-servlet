package br.com.webManagerServlet.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/alterCompany")
public class AlterCompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Altering company");
		
		/* Read both parameters coming from browser */
		String companyName = request.getParameter("name");
		String companyOpeningDate = request.getParameter("date");
		String idParam = request.getParameter("id");
		Integer id = Integer.valueOf(idParam);

		Date openingDate = null;
		try {
			/* Parse information */
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			openingDate = sdf.parse(companyOpeningDate);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		System.out.println(id);
		
		Bank bank = new Bank();
		Company company = bank.findById(id);
		company.setName(companyName);
		company.setOpeningDate(openingDate);
		
		response.sendRedirect("companiesList");
		
	}

}
