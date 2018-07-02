package service;

import java.sql.SQLException;
import java.util.List;

import dao.MessageDao;
import domain.Message;
import domain.MessageBean;

public class MessageService {
	
	public MessageBean<Message> showContentByPage(int currPage,int pageSize) throws SQLException {
		/*
		 * //查询当前页数据 limit (currPage,pageSize)=（当前页-1）*每页显示条数 
 		ProductDao dao=new ProductDao();
		List<Product> list=dao.findProductByPage(currPage,pageSize);
		//查询总条数
		int totalCount=dao.getCount();
		return new PageBean<Product>(list,currPage,pageSize,totalCount);
		 */
		
		//查询当前页数据 limit (currPage,pageSize)=（当前页-1）*每页显示条数 
		MessageDao dao=new MessageDao();
		List<Message> list=dao.findContentByPage(currPage,pageSize);
		//查询总条数
		int totalCount=dao.getCount();
		return new MessageBean<Message>(list,currPage,pageSize,totalCount);
		
	}
	//发布留言
	public int publishMessage(String theme, String writer, String date, String content) throws SQLException {
		// TODO Auto-generated method stub
		return new MessageDao().publishMessage(theme,writer,date,content);
	}
	

	public Message getMessageById(String id) throws SQLException {
		// TODO Auto-generated method stub
		return new MessageDao().getMessageById(id);
	}
	//修改留言
	public void updateMessage(Message msg) throws SQLException {
		new MessageDao().updateMessageById(msg);
		
	}
	//删除留言
	public void DelMsgById(Message msg) throws SQLException {
		new MessageDao().DelMsgById(msg);
		
	}

}
