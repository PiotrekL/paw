package trello.dao;

import trello.model.User;

public interface UserDao {
public User getUser(String login);
public void saveUser(User user);
}
