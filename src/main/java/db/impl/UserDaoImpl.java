package db.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import db.DbUtils;
import domain.User;

public class UserDaoImpl {
	static JdbcTemplate jdbcTemplate = new JdbcTemplate(DbUtils.getDataSource());


	public void save(User u) {
		// TODO Auto-generated method stub
		
	}


	public void delete(User u) {
		// TODO Auto-generated method stub
		
	}

	
	public void update(User u) {
		// TODO Auto-generated method stub
		
	}
	
	
	public static User getUserByEmailAndPassword(String email, String password) {
		String sql ="select * from user where email=? and password=?";
		
			List<User> users = jdbcTemplate.query(sql, new RowMapper<User>() {
				public User mapRow(ResultSet rs,int arg1) throws SQLException {
					User u = new User();
					u.setId(rs.getInt("id"));
					u.setEmail(rs.getString("email"));
					u.setPassword(rs.getString("password"));
					u.setUsername(rs.getString("username"));
					u.setLocation(rs.getString("location"));
					
					return u;
				}
			},email,password);
		
	
		if(users.size()==0)
			return null;
		else
			return users.get(0);
	}
	
	public static User getUserByUid(String id) {
		String sql ="select * from user where id=?";
		
		List<User> users = jdbcTemplate.query(sql, new RowMapper<User>() {
			public User mapRow(ResultSet rs,int arg1) throws SQLException {
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setEmail(rs.getString("email"));
				u.setPassword(rs.getString("password"));
				u.setUsername(rs.getString("username"));
				u.setLocation(rs.getString("location"));
				
				return u;
			}
		},id);
	

	if(users.size()==0)
		return null;
	else
		return users.get(0);
	}


	public static List<User> getUsersByLocation(String location) {
		String sql ="select * from user where location=?";
		
		return jdbcTemplate.query(sql, new RowMapper<User>() {
			public User mapRow(ResultSet rs,int arg1) throws SQLException {
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setEmail(rs.getString("email"));
				u.setPassword(rs.getString("password"));
				u.setUsername(rs.getString("username"));
				u.setLocation(rs.getString("location"));
				
				return u;
			}
		},location);
	}
	
	
}