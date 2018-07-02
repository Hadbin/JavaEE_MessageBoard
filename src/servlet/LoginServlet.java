package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.User;
import service.LoginService;
import utils.CookiesUtils;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 0设置编码
		response.setContentType("text/html;charset=utf-8");
		// 1接受用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		

		
		// 2调用LoginSerivce 判断是否登录成功
		User user = null;
		try {
			user = new LoginService().showMessage(username, password);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("网络异常，请稍后再试！");
		}
		// 3判断user是否为空
		if (user != null) {	
			String logMsg=null;//登录反馈信息
			String autologin=request.getParameter("autologin");
			HttpSession userShell=request.getSession();
			userShell.setAttribute("userShell", user.getShell());//用户权限
			//获取session对象
			 HttpSession session=request.getSession();
             session.setAttribute("USER", user);//用户
          //  if("true".equals(autologin)){
            	/*
                Cookie cookie1 = new Cookie("USERNAME", username);
                Cookie cookie2 = new Cookie("PASSWORD", password);
                cookie1.setMaxAge(24*60*60);
                cookie2.setMaxAge(24*60*60);
                response.addCookie(cookie1);
                response.addCookie(cookie2);
                System.out.println("cookie写入成功");
              */  
              //创建session
               
          //  }
		

           
           // System.out.println("sessionName="+session.getAttribute("USER").toString());
            
          //  response.sendRedirect("/JD/fristpage/search.jsp");
             /*
				// session
				//3.1创建session对象
				HttpSession lastTime=request.getSession();
				//3.2根据用户名获取session
				Object obj=lastTime.getAttribute(username);
				//3.3判断session是否为空
				if(obj==null) {
					logMsg="这是您第一次访问";
					request.getSession().setAttribute(username, lastTime);
					//记录本次登录时间
					try {
						LoginService.getLastTime(user);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("记录登录时间失败");
					}
				}else {
					logMsg=username+"欢迎回来,您上次访问时间:"+user.getLastTime();
				}
				//session.invalidate();
				*/
             String lastTime=user.getLastTime();
             if(lastTime=="" || lastTime==null) {
            	 logMsg="这是您第一次访问";
					try {
						LoginService.getLastTime(user);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("记录登录时间失败");
					}
             }else {
					logMsg="欢迎回来  "+username+" ，您上次访问时间:"+user.getLastTime();
					try {
						LoginService.getLastTime(user);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("记录登录时间失败");
					}
				}
					/* cookie 
					
						// 1.1根据用户获取知道的cookie
						PrintWriter pw = response.getWriter();
						Cookie c = CookiesUtils.getCookieByName(user.getId()+"", request.getCookies());
						// 1.2判断cookie是否为空
						if (c == null) {
							// cookie为空，提示第一次访问
							logMsg="这是您第一次访问";
						} else {
							// cookie不为空，获取value,展示上一次访问时间
							String value = c.getValue();// 获取lastTime
							long time = Long.parseLong(value);
							Date date = new Date(time);
							logMsg="您上次访问时间:" + date.toLocaleString();
						}
						// 1.3创建当前的cookie
						c = new Cookie(user.getId()+"", new Date().getTime() + "");
						// 1.4持久化cookie
						c.setMaxAge(3600);
						// 1.5设置路径
						c.setPath(request.getContextPath() + "/");// 在 MessageBoard/ 目录下
					
					
					// 1.6写回浏览器
					response.addCookie(c);
					*/
			String logMessage = "{\"shell\":\"" + user.getShell() + "\",\"username\":\"" + user.getUsername()
					+ "\",\"logMsg\":\""+logMsg+"\"}";
			response.getWriter().println(logMessage);

		} else {
			/*
			 * 重定向写在js中了 response.getWriter().println("用户名和密码不匹配,3秒之后跳转");
			 * response.setHeader("Refresh","3;URL=http://www.baidu.com");
			 */
			return ;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
