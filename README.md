<h1>webManagerServlet</h1>
<h2>Web application project focused on Servlet management.</h2>
<ul>
	<li>LinkedIn: https://www.linkedin.com/in/jpfigueredo/</li>
	<li>Instagram: https://www.instagram.com/figfig.jpg/</li>
</ul>

Sumário
<ul>
<li>O que você vai aprender</li>
<li>Pré-requisitos</li>
<li>Visão geral sobre mapeamento objeto-relacional</li>
<li>JPA</li>
<li>Criando uma aplicação simples</li>
</ul>

<p>Firstly, the project was created as a "Dynamic Web Project", on configuration only Java and Dynamic Web Module are set.</p>
<p>The Content folder created have "src/main/webapp" as the path, you can put a more mnemonic name.</p>

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
