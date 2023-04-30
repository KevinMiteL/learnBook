package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDaoImpl;
import javabean.User;

/**
 * Servlet implementation class DengLu
 */
@WebServlet("/DengLu")
public class DengLu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DengLu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String xm=request.getParameter("uname");
		String mm=request.getParameter("upwd");
		User user=new User(xm,mm);

		List<User> list=null;
                UserDaoImpl dao=new UserDaoImpl();

		try {list = dao.QueryAll();

		} catch (Exception e) {e.printStackTrace();}

		int f=user.pdListUser(list);

		if(f==1){//登录成功
			request.setAttribute("uname", xm);
			RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
			rd.forward(request, response);
		}else{
			
			RequestDispatcher rd=request.getRequestDispatcher("register.jsp");//进入register.jsp,直接注册。（不是注册用户，无权登录）
			rd.forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
