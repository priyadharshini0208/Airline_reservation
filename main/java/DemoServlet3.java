import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DemoServlet3 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public DemoServlet3() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String from = request.getParameter("from");
        String to = request.getParameter("to");
        String date = request.getParameter("date");
        Hello2 obj1 = new Hello2(from,to,date);
	    if(obj1.retrieve()) {
	    	RequestDispatcher requ = request.getRequestDispatcher("Form.html");
		    requ.forward(request, response);
	    }
	    else {
	    	response.getWriter().println("Flight is not available!!!");
	    }
        
    }
}


