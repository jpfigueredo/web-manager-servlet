# webManagerServlet

Web application project focused on Servlet management. To understand what was done, We have to start at the beginning.

Firstly, the project was created as a "Dynamic Web Project", on configuration only Java and Dynamic Web Module are set.
The Content folder created have "src/main/webapp" as the path, which I regret using, would prefer to put WebContent, or something like that, more mnemonic.

On the Console, at "Servers", 

In this folder, the .html file is set to be called, "bem-vindo.html" is used as an example.

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
