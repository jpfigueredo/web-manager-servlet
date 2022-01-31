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
As always, before start coding, some configuration is needed.

Firstly, the project was created as a "Dynamic Web Project", on configuration only Java and Dynamic Web Module are set.
The Content folder created have "src/main/webapp" as the path, you can put a more mnemonic name.

<p>On the Console, at "Servers"</p>

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
