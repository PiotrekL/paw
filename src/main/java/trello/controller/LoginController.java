package trello.controller;

import trello.dao.UserDao;
import trello.dao.implementation.HibernateUserDao;
import trello.model.User;
import trello.utils.SecureUtil;

public class LoginController {

	
	
public boolean authenticateUser(String login, String password){
	UserDao userDao= new HibernateUserDao();
	String pass= userDao.checkUser(login);
	if(pass==null) return false;
	else if(!pass.equals(SecureUtil.getHash(password))) return false;
	else return true;
}
	
}
