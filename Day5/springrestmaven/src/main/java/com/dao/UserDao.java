package com.dao;

import java.util.List;

import com.model.User;

public interface UserDao {

  int register(User user);

  User getUser(String uid);
  
  public List<User> getUsers();
}
