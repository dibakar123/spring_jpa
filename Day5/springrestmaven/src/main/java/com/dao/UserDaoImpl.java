package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.model.User;


@Repository("userdao")
public class UserDaoImpl implements UserDao {

  @Autowired
  JdbcTemplate jdbcTemplate;

  public int register(User user) {

    String sql = "insert into myusers values(?,?,?,?,?,?,?)";

    int r= jdbcTemplate.update(sql, new Object[] { user.getUsername(), user.getPassword(), user.getFirstname(),
        user.getLastname(), user.getEmail(), user.getAddress(), user.getPhone() });
    return r;
  }

  public User getUser(String uid) {

    String sql = "select * from myusers where username=?";
    List<User> users = jdbcTemplate.query(sql, new Object[]{uid},new UserMapper());
    return users.size() > 0 ? users.get(0) : null;
  }

  public List<User> getUsers(){
  String sql = "select * from myusers";
  List<User> users = jdbcTemplate.query(sql, new UserMapper());
  return  users;
  }
  
  class UserMapper implements RowMapper<User> {
	  public User mapRow(ResultSet rs, int arg1) throws SQLException {
	    User user = new User();
	    user.setUsername(rs.getString("username"));
	    user.setFirstname(rs.getString("firstname"));
	    user.setLastname(rs.getString("lastname"));
	    user.setEmail(rs.getString("email"));
	    user.setAddress(rs.getString("address"));
	    user.setPhone(rs.getString("phone"));
	    return user;
	  }
   }
  
}

