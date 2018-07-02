package dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import domain.User;
import utils.DataSourceUtils;

public class RegisterDao {

	public int register(String username, String password) throws Exception {
		System.out.println("username:" + username);
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql_1 = "SELECT * FROM USER WHERE userName=?;";// 注册用户前，检查此用户是否已经存在
		User user = qr.query(sql_1, new BeanHandler<>(User.class), username);
		if (user != null)
			return 0; // 此用户已经存在
		String sql_2 = "INSERT INTO USER(userName,passWord) VALUES(?,?);";
		return qr.update(sql_2, username, password);// 注册成功,返回1
	}

}
