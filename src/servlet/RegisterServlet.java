package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import service.RegisterService;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		//1获取用户名和密码
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		//2调用service,将用户名和密码存入数据库
		int result=-1;
		String RegisterMsg="{\"result\":\"注册失败\"}";
		try {
			result=new RegisterService().register(username,password);
			if(result==0) {//此用户名已存在
				RegisterMsg= "{\"result\":\"此用户名已被注册,请重新输入新的用户名\"}";//此用户名已被注册
			}else if(result==1) {
				RegisterMsg= "{\"result\":\"注册成功\"}";
			}
			System.out.println(RegisterMsg);
			response.getWriter().println(RegisterMsg);
		}catch(Exception e) {
			e.printStackTrace();
		}
		//3跳转登录页面
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
