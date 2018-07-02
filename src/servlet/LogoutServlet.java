package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.CookiesUtils;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取session对象,并且销毁
		HttpSession session=request.getSession();
		session.invalidate();
		//获取Cookies,并且销毁
		Cookie cookie1=CookiesUtils.getCookieByName("USERNAME", request.getCookies());
		Cookie cookie2=CookiesUtils.getCookieByName("PASSWORD", request.getCookies());
		if(cookie1!=null) {
			cookie1.setMaxAge(0);
			response.addCookie(cookie1);
		}
		if(cookie2!=null) {
			cookie2.setMaxAge(0);
			response.addCookie(cookie2);
		}
		System.out.println("logout");
		//请求转发
		//response.sendRedirect("/index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
