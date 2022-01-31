# webManagerServlet

**Web application project focused on Servlet management.**

- [LinkedIn: https://www.linkedin.com/in/jpfigueredo/](#LinkedIn)
- [Instagram: https://www.instagram.com/figfig.jpg/](#instagram)

## Sumário

- [Configuring Tomcat Server](#Configuring-Tomcat-Server)
- [Trabalhando com POST e GET](#Trabalhando-com-POST-e-GET)
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

With the project created and the server set up, its time to connect them.
**Righ-Click** Tomcat Server at **Servers** tab, press **Add and Remove...**, select the project and **Finish**. Now, the server can be started by clicking on 


```java

@WebServlet(urlPatterns = "/index")
public class IndexServlet extends HttpServlet {

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
