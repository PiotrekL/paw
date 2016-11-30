package trello.dao;

import trello.model.User;

public interface UserDao {
public User getUser(String login);
public long saveUser(User user);
public String checkUser(String login);
}
