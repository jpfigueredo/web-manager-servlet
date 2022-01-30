package br.com.webManagerServlet.servlet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Company> companyList = new ArrayList<>();
	private static Integer primaryKey = 1;

	static {
		Company companyC1 = new Company();
		companyC1.setId(primaryKey++);
		companyC1.setName("Google");
		Company companyC2 = new Company();
		companyC2.setName("Microsoft");
		companyC2.setId(primaryKey++);
		companyList.add(companyC1);
		companyList.add(companyC2);
	}

	public void adiciona(Company company) {
		company.setId(Banco.primaryKey++);
		Banco.companyList.add(company);
	}

	public static List<Company> getCompanyList() {
		return Banco.companyList;
	}

	public void removeCompany(Integer id) {
		/* Traditional method */
		Iterator<Company> it = companyList.iterator();
		while (it.hasNext()) {
			Company company = it.next();
			if (company.getId() == id) {
				it.remove();
			}
		}

	}

	public Company findById(Integer id) {
		for (Company company : companyList) {
			if(company.getId() == id) {
				return company;
			}
		}
		return null;
	}

}
