package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import dao.UserDaoImpl;
import javabean.User;

/**
 * Servlet implementation class YanZheng
 */
@WebServlet("/YanZheng")
public class YanZheng extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public YanZheng() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String xm = request.getParameter("uname");
		String mm = request.getParameter("upwd");
		User user = new User(xm, mm);
		
		//Log4j
		Logger onelogger=Logger.getLogger("onelogger");
		String path = getServletContext().getRealPath("WEB-INF/log4j.properties");
		PropertyConfigurator.configure(path);
		onelogger.info("提交的信息为："+xm+" 密码："+mm);

		List<User> list = null;
		UserDaoImpl dao = new UserDaoImpl();

		//查询用户
		list = dao.QueryAll();
		
		//判断用户是否已经注册
		int f = user.pdListUser(list);

		if (f == 1) {
			RequestDispatcher rd = request.getRequestDispatcher("info.jsp");
			rd.forward(request, response);
		} else {
			
			//注册用户
			int num = dao.add(user);
			
			if(num >0) {//注册成功
				RequestDispatcher rd = request.getRequestDispatcher("sucess.jsp");
				rd.forward(request, response);			
			}else
			{//注册失败
				response.setContentType("text/html;charset=UTF-8");
				response.getWriter().append("注册失败!");
			}

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
