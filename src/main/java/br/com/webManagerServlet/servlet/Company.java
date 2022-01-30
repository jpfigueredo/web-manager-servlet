package br.com.webManagerServlet.servlet;

import java.util.Date;

public class Company {

	private Integer id;
	private String name;
	private Date openingDate = new Date();
 
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}
}
