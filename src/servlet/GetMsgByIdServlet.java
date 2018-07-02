package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Message;
import service.MessageService;

/**
 * Servlet implementation class GetMsgByIdServlet
 */
public class GetMsgByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetMsgByIdServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 0 设置编码

		// 1 获取留言内容id
		String id = request.getParameter("id");
		// 2调用service ，通过id获取留言 返回message
		Message msg = null;
		try {
			msg = new MessageService().getMessageById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(msg.toString());
		// 3将message放入request域中，请求转发到function_update.jsp中
		request.setAttribute("bean", msg);
		//4根据不同页面发起的请求，转发到不同的页面
		String url=request.getParameter("page");
		if(url.equals("update")) {
			request.getRequestDispatcher("/function_update.jsp").forward(request, response);
		}else if(url.equals("look")) {
			request.getRequestDispatcher("/function_look.jsp").forward(request, response);
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
