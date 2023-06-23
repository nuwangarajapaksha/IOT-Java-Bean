import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.*;

public class MyServlet extends HttpServlet {

   public void doGet(HttpServletRequest request, HttpServletResponse response) {
      Context ctx = new InitialContext();
      DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/mydb");
      // use the datasource to access the database
      // ...
   }
}
