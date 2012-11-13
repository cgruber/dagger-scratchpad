import blah.Foo;
import dagger.ObjectGraph;
import dagger.web.servlets.WebObjectGraph;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "myServlet", urlPatterns = "/myUrl")
public class FooServlet extends HttpServlet {

  @Inject Foo foo;

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException {

    ObjectGraph graph = WebObjectGraph.get(req);
    graph.inject(this);

    res.setContentType("text/html");

    PrintWriter out = res.getWriter();

    // Writing response to display on page
    out.write("<html><head><title>Test</title></head>");
    out.write("<body>");
    out.write("<h2>@WebServlet Annotation Example</h2>");
    out.write("<h3>");
    out.write(foo.bar());
    out.write("</h3>");
    out.write("<p>This is page is displayed by the servlet having @WebServlet annotataion</p>");
    out.write("</body>");
    out.write("</html>");
  }
}
