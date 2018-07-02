package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import domain.Message;
import service.MessageService;

/**
 * Servlet implementation class DelMsgByIdServlet
 */
public class DelMsgByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelMsgByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		 * 1。可以用这个方法获取id，调用service 完成删除操作。
		 *  String id=request.getParameter("id");
		 *  
		 *  2.不过我这里我用了BeanUtils,从msg.GetId()获取id
		 */
		//封装数据
		Message msg=new Message();
		try {
			BeanUtils.populate(msg, request.getParameterMap());
			System.out.println("msg.id="+msg.getId());
			//调用service,删除留言
			new MessageService().DelMsgById(msg);
			//写回页面，提示删除成功
			request.setAttribute("result", "删除成功");
			response.sendRedirect(request.getContextPath()+"/GetAllMsg?currPage=1&page=edit");
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "删除失败");
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
