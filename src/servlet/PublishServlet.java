package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.User;
import service.MessageService;

/**
 * Servlet implementation class PublishServlet
 */
public class PublishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublishServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0设置编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//接受参数
		String theme=request.getParameter("theme");
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("USER");
		String writer=user.getUsername();
		String date=request.getParameter("date");
		String content=request.getParameter("content");
		System.out.println("theme="+theme+"  "+"writer="+writer+"  "+"date="+date+"  "+"content="+content);
		//调用service，完成发布留言
		int result=0;
		try {
			result=new MessageService().publishMessage(theme,writer,date,content);
			System.out.println("result="+result);
		}catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("网络异常，请稍后再试！");
		}
		//判断是否添加成功
		if(result>=1) {
			String pubMessage="{\"msg\":\"添加成功\"}";
			response.getWriter().println(pubMessage);
		}else {
			
			String pubMessage="{\"msg\":\"添加失败，请检查网络连接\"}";
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
