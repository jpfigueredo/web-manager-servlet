# webManagerServlet

**Web application project focused on Servlet management.**

## Social Midias

- https://www.linkedin.com/in/jpfigueredo/
- https://www.instagram.com/figfig.jpg/

## What you should know beforehand
- Java programming
- Oriented Object Programming
- Network -> HTTP Protocols/Request/Response
- SQL knowledge(CRUD)


## Summary

- [Configuring Tomcat Server](#Configuring-Tomcat-Server)
- [Understanding Servlets](#Understanding-Servlets)
- [Working with GET and POST](#Working-with-GET-and-POST)
- [Definindo o nosso modelo](#Definindo-o-nosso-modelo)
- [Páginas dinâmicas com JSP](#Páginas-dinâmicas-com-JSP)
- [JSTL e Expression Language](#JSTL-e-Expression-Language)
- [Redirecionando o fluxo](#Redirecionando-o-fluxo)
- [Completando o CRUD](#Completando-o-CRUD)
- [Deploy da aplicação](#Deploy-da-aplicação)


## Configuring Tomcat Server

As always, before start coding, some configuration is needed. In this project, Tomcat Server is the chosen option. The latest version was used. Currently, **apache-tomcat-10.0.16** is the latest one.  

After downloading and installing Apache Tomcat at the folder of choice, the configuration can be started. 
For starters, open Eclipse, or STS, go to Window -> Show view -> Servers

![image](https://user-images.githubusercontent.com/63759223/151827750-0ffd9431-6c59-4c1c-88e0-838e6635d178.png)

Now, on the console, a tab called **Servers** should appear. If there is no Servers configured, this message should appear.

![image](https://user-images.githubusercontent.com/63759223/151827997-7e6b9ce3-a257-4905-b9ad-543878fc536e.png)

Upon clicking on the "link message", a "New Server" tab should pop-out. For this project **Tomcat 10.0 Server** was chosen. 

**ATENTION:** *The server must be on the same version as the Tomcat installed.*

Hit **next**. 

Now the name and the directory path that was chosen for the Tomcat that was installed previously should be inputed. Choose the jre of preference, for the project, Java version "17" 2021-09-14 LTS and Java(TM) SE Runtime Environment (build 17+35-LTS-2724) was used.

![image](https://user-images.githubusercontent.com/63759223/151829122-60401cf0-e5b0-498a-9652-55a4c3683998.png)

On STS 4.4.13.0, the pop-up that should show is this one:

![image](https://user-images.githubusercontent.com/63759223/151831464-4f1232be-88a1-4880-bc18-be8d4375d1c4.png)

Hit **next**.

![image](https://user-images.githubusercontent.com/63759223/151831717-1b7867d1-d99e-46ed-97c5-c1093e0fdb51.png)

Add the project of choice and hit **Finish**.
**NOTE:** *If there is no project, just hit finish and the Server will be set up.*

Now, the server is set up. So, firstly, the project is created as follows **File -> New -> Dynamic Web Project**, set the name as wanted, the **Target runtime** should be the same as the server, on configuration only Java and Dynamic Web Module should be set.

![image](https://user-images.githubusercontent.com/63759223/151833093-c2371ea9-aaac-47e4-b527-b95621eaaf32.png)

The option **Finish >** will set everything just fine, but, **Next >** hit **Next >** twice, on **Content Directory**, the content directory created is "src/main/webapp", as the path, "WebContent" or "WebApp" can be set for a more mnemonic name.
Now, check the box to create a web.xml file and, now its done, hit **Finish >**.

**Note:** *web.xml is optional, it'll be used to demonstrate how to manually write annotations*

With the project created and the server set up, its time to connect them.
**Righ-Click** Tomcat Server at **Servers** tab, press **Add and Remove...**, select the project and **Finish**. Now, the server can be started by clicking on **Start the server** or **Ctrl+Alt+R**.

Next step is to create a file on **src/main/java/webapp** the file welcome.html will be created, as the following image shows

![image](https://user-images.githubusercontent.com/63759223/151847400-5b805f19-0638-4646-b526-fe56f21bc16b.png)
 
 go **File -> New -> File**, input file name and select the said directory, as shown below.
 
![image](https://user-images.githubusercontent.com/63759223/151847630-7a7a8df6-2b92-4d7e-8b72-f51f947040c5.png)

Input some text on the .html file for test purposes, here's an example:
```java
<html>

<body>
	Welcome!
</body>

</html>
```

Now, start Tomcat Server, at the browser's url, input http://localhost:8080/{PROJECT NAME}/ and the following image will be shown.

![image](https://user-images.githubusercontent.com/63759223/151849864-0fafc9b9-810f-4cad-ac3c-242020e4cc78.png)

Thats it for Configuration and connection with Tomcat server. 

## Understanding Servlets

Go to **File -> New -> Servlet**, the image below will appear. The Servlet will be on the same folder as the models, the class name will be **IndexServlet.java**.

![image](https://user-images.githubusercontent.com/63759223/151850893-2c8985f1-1e87-4d8f-b351-8489124ad864.png)

Now, hit **next**.

Here, the only thing that will be changed is the **URL mappings**, **Right-Click** the **/{ProjectName}** and, by default, the first letter should be lower cased, so **/{projectName}**.

![image](https://user-images.githubusercontent.com/63759223/151850926-1c0c88c0-5ae8-407a-8c1b-db47712998a9.png)

Hit **next**.

Here, by default, the **Inherited abstract methods doGet and doPost** are selected, uncheck and check **service**. The **service method** will apply both **doGet and doPost**.

![image](https://user-images.githubusercontent.com/63759223/151850958-2f9a9363-0b3b-49bd-a3ec-b14323e81108.png)

Hit **Finish**.

Remove the constructor and comments and it should look like this.

```java
package br.com.webManagerServlet.servlet;

@WebServlet(urlPatterns = "/index")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("IndexServlet servlet is beeing called.");
	}
}
```


## Working with GET and POST

In Java Springboot 
- **GET is responsible for accessing data** and 
- **POST is responsible for Altering and Registering** data.
The methods **doGet** and **doPost** are setup like the **service** method, but both only accept the respective request/response.

```java
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Congratulations, you have a Servlet running.");
		out.println("</body>");
		out.println("</html>");

		System.out.println("O servlet foi IndexServlet chamado.");
	}
}
```

As seen above, the **service** method receives two parameters **HttpServletRequest , HttpServletResponse **, those methods are responsible for the real Request and Response at the HTTP protocol, that will be talking with the server. So, next step is to define a **URL Pattern**, this will be the path set to the servlet.

So, an annotation is created for the **service method**, to define a path, which is **@WebServlet(urlPatterns = "/index")**.
Secondly, for testing purposes, a **PrintWriter out = response.getWriter();** is defined. As seen, it is a method from the response, or HttpServletResponse, parameter, so, as known, response deals with sending information along the HTTP Protocol, and thats whats going to be done.

Now, if the url:"localhost:8080/{projectName}/index" is set to run, the **RESPONSE** will be:

```java
<html>
<body>
Congratulations, you have a Servlet running.
</body>
</html>
```

It can be seen at the source code. 

Congrats, the Servlet is running!

## Defining models

At this point, it is needed to define a model for the project, so that it can be continued. The focus of this project is **Servlets** and not **Database**, so a in-memory database will be created further on, and, for that reason, a simple relation will be created and used.
It is shown below.

![image](https://user-images.githubusercontent.com/63759223/151866578-d0a741a9-1135-45c5-8ec8-b2fc93af69e6.png)

At this point, it should be known how to present a simple 1:N relation at a model level.

```java
import java.util.Date;

public class Company {

	private Integer id;
	private String name;
	private Date openingDate = new Date();
 
	CTRL+3, getters and setters for all.
}
```

Now, before going into the Bank.class, it is understood that, for not having a lib bank, like JPA, somethings are different than normal, like the **static{}**. It is used to insert data as the model is executed, so that **companyC1 and companyC2** can be shown at the page that calls for the bank model.

```java
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bank {

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

	public void adds(Company company) {
		company.setId(Bank.primaryKey++);
		Bank.companyList.add(company);
	}

	public static List<Company> getCompanyList() {
		return Bank.companyList;
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

```


## Páginas dinâmicas com JSP
## JSTL e Expression Language
## Redirecionando o fluxo
## Completando o CRUD
## Deploy da aplicação


