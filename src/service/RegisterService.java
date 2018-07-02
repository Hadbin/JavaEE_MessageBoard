package service;

import java.sql.SQLException;

import dao.RegisterDao;
import domain.User;

public class RegisterService {

	public int register(String username, String password) throws Exception {
		// TODO Auto-generated method stub
		return new RegisterDao().register(username,password);
	}

}
