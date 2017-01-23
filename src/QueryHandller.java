

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mongodb.DBObject;

/**
 * Servlet implementation class QueryHandller
 */
@WebServlet("/QueryHandller")
public class QueryHandller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public QueryHandller() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Query qu=new Query();
		String iden=request.getParameter("iden");
		ArrayList<DBObject> results= new ArrayList<DBObject>();
		if(iden.equals("singlequer"))
		{
			
			results = qu.runQuery(request.getParameter("selecter"),request.getParameter("filter"));
			
		}
		else if(iden.equals("multiquer"))
		{
			String[] filter = request.getParameterValues("filter");
			
			String[] selector = request.getParameterValues("myselect");	
			 results =qu.multiQuery(selector,filter);
		}
		else if(iden.equals("advquer"))
		{
			String checkval=request.getParameter("orcheck");
			/*iden
rangeselect
lfilter
rfilter
normalselect
filter
no or selected*/
			String[] normalselect=request.getParameterValues("normalselect");
			String[] filter=request.getParameterValues("filter");
			String[] rangeselect=request.getParameterValues("rangeselect");
			String[] lfilter=request.getParameterValues("lfilter");
			String[] rfilter=request.getParameterValues("rfilter");
			if(!(checkval==null))
			{
				
				results = qu.advQuery(normalselect,filter,rangeselect,lfilter,rfilter,true);
				System.out.println("or selected");
			}
			else
			{
				results = qu.advQuery(normalselect,filter,rangeselect,lfilter,rfilter,false);
				System.out.println("no or selected");
			}
		}
		HttpSession sess=request.getSession();
		sess.setAttribute("res", results);
		response.sendRedirect("results.jsp");
	
		
				
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("came here");
		
		String iden=request.getParameter("iden");
		if(iden.equals("login"))
		{
		Login l= new Login();
		 LoginBean test = l.loginValidator(request.getParameter("uname"), request.getParameter("pwd"));
		if(test.isCorrect())
		{
			
			if(test.isValidated())
			{
				response.sendRedirect("test.jsp");
			}
			else
			{
				response.sendRedirect("notvalidated.jsp");
			}
		}
		else
		{
			response.sendRedirect("error.jsp");
		}
		}
		else if(iden.equals("register"))
		{
		Login l= new Login();
		 l.register(request.getParameter("uname"), request.getParameter("pwd"));
		
			response.sendRedirect("doneaskadmin.jsp");
		
		
	}
	}
}
