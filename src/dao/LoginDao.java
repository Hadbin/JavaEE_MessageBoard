package dao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import domain.Message;
import domain.User;
import utils.DataSourceUtils;

public class LoginDao {

	public User findLogMessage(String username, String password) throws SQLException {
		//创建QueryRunner
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		//编写sql语句
		String sql="select * from user where username=? and password=?";
		//执行sql
		User user=qr.query(sql, new BeanHandler<>(User.class),username,password);
		return user;
		
	}
	//记录登录时间
	public void getLastTime(User user) throws SQLException{
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="update user set lastTime=? where username=?";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String date=df.format(new Date());// new Date()为获取当前系统时间
		System.out.println(date);
		qr.update(sql, date,user.getUsername());
	}
	/*
	//记录登录时间
		public void updateMessageById(User user) throws SQLException {
			String lastTime=user.getLastTime();//获取原登录时间
			QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
			String sql="update content set theme=? , date=?,reply=?,edit=? where id=?";
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			String date=df.format(new Date());// new Date()为获取当前系统时间
			System.out.println(date);
			qr.update(sql, msg_theme.getTheme()+"[已解决]",date,msg.getReply(),0,msg.getId());
			
		}
		*/

}
