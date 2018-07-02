package dao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import domain.Message;
import utils.DataSourceUtils;

public class MessageDao {


/*
 * 		 (了解)ArrayHandler, 将查询结果的第一条记录封装成数组,返回
		 (了解)ArrayListHandler, 将查询结果的每一条记录封装成数组,将每一个数组放入list中返回
		 ★★BeanHandler, 将查询结果的第一条记录封装成指定的bean对象,返回
		 ★★BeanListHandler, 将查询结果的每一条记录封装成指定的bean对象,将每一个bean对象放入list中 返回.
		 (了解)ColumnListHandler, 将查询结果的指定一列放入list中返回 
		 (了解)MapHandler, 将查询结果的第一条记录封装成map,字段名作为key,值为value 返回
		 ★MapListHandler, 将查询结果的每一条记录封装map集合,将每一个map集合放入list中返回
		 ★ScalarHandler,针对于聚合函数 例如:count(*) 返回的是一个Long值
 */

	/**
	 * 展示分页商品
	 * @param currPage 当前页面的码数
	 * @param pageSize 每页显示的页数
	 * @return
	 * @throws SQLException 
	 */
	public List<Message> findContentByPage (int currPage,int pageSize) throws SQLException{
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from content order by date desc limit ?,?;";
		return qr.query(sql, new BeanListHandler<>(Message.class),(currPage-1)*pageSize,pageSize);
	}

	/**
	 * 查询总条数
	 * @return
	 * @throws SQLException 
	 */
	/*
	 * long是数据类型，而Long是基本数据类型的对象包装器
	 * Long在lang包中，使用时无需用import导入
	 * Long是将long型的量当作对象来处理，它必须以long型的量作为参数。
	 * 
	 * calarHandler,针对于聚合函数 例如:count(*) 返回的是一个object对象
	 */
	public int getCount() throws SQLException {
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select count(*) from content";
		return ((Long)qr.query(sql, new ScalarHandler())).intValue();
	}
	//发布留言
	public int publishMessage(String theme, String writer, String date, String content) throws SQLException {
		//创建QueryRunner
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="insert into content(theme,writer,date,content) values(?,?,?,?)";
		//执行sql
		//int i=qr.update(sql, theme,writer,date,content);
		//System.out.println("i="+i);
		return qr.update(sql, theme,writer,date,content);
	}
	
	//根据id获取某条留言的全部内容
	public Message getMessageById(String id) throws SQLException {
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from content where id=?";
		return qr.query(sql, new BeanHandler<>(Message.class),id);
	}
	//修改留言
	public void updateMessageById(Message msg) throws SQLException {
		Message msg_theme=getMessageById(msg.getId());//获取留言的原主题
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="update content set theme=? , date=?,reply=?,edit=? where id=?";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String date=df.format(new Date());// new Date()为获取当前系统时间
		System.out.println(date);
		qr.update(sql, msg_theme.getTheme()+"[已解决]",date,msg.getReply(),0,msg.getId());
		
	}
	//删除留言
	public void DelMsgById(Message msg) throws SQLException {
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="DELETE FROM content WHERE id=?";
		qr.update(sql, msg.getId());
		System.out.println("删除成功");
	}

}
