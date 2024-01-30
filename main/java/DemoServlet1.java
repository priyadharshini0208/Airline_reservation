import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class DemoServlet1
 */
public class DemoServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    String email = request.getParameter("email");
		    String password = request.getParameter("password");
		    Hello1 obj1 = new Hello1(email, password);
		    if(obj1.retrieve()) {
		    	RequestDispatcher requ = request.getRequestDispatcher("detail.html");
			    requ.forward(request, response);
		    }
		    else {
		    	response.getWriter().println("Login Failed. Please register first!!!");
		    }

		    // Instead of writing to the response here, you can set attributes in the request
		    // to pass data to the next resource (Form.html)
		}

	}

