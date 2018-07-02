package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Message;
import domain.MessageBean;
import service.MessageService;

/**
 * Servlet implementation class Content
 */
public class GetAllMsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllMsgServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0设置编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//1设置当前页
		int currPage=Integer.parseInt(request.getParameter("currPage"));
		System.out.println("currpage="+currPage);
		int pageSize=12;//每页显示的数据数
		//2调用service 完成分页查询
		MessageBean<Message> bean=null;
		try {
			bean=new MessageService().showContentByPage(currPage,pageSize);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(bean.getList().toString());
		//3将msg放入request域中，请求转发content.jsp
		request.setAttribute("msg",bean );

		//4根据不同页面发起的请求，转发到不同的页面
		String url=request.getParameter("page");
		if(url.equals("edit")) {
			request.getRequestDispatcher("/edit.jsp").forward(request, response);
		}else if(url.equals("look")) {
			request.getRequestDispatcher("/content.jsp").forward(request, response);
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
