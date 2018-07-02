package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import domain.Message;
import service.MessageService;

/**
 * Servlet implementation class EditByIdServlet
 */
public class EditByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//1封装数据
		Message msg=new Message();
		try {
			BeanUtils.populate(msg, request.getParameterMap());
			System.out.println("修改"+msg.toString());
			//2调用service ，完成留言修改
			new MessageService().updateMessage(msg);
			
			//3页面重定向,跳转到查看留言
			//response.sendRedirect(request.getContextPath()+"/GetMsgById?id="+msg.getId()+"&page=look");
			//页面的左边，应该要跳转到修改留言的页面
			String editMessage="{\"msg\":\"回复成功\"}";
			response.getWriter().println(editMessage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("result", "回复留言失败");
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
