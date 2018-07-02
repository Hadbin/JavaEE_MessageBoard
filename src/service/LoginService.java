package service;

import java.sql.SQLException;

import dao.LoginDao;
import domain.User;

public class LoginService {
	public User showMessage(String username, String password) throws SQLException {
		//调用dao
		LoginDao dao =new LoginDao();
		
		return dao.findLogMessage(username,password);
	}
	public static void getLastTime(User user) throws SQLException{
		LoginDao dao =new LoginDao();
		dao.getLastTime(user);
	}
}
