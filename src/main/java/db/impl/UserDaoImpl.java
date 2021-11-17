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
	
	public static List<User> getUsersNotIn(){
		String sql ="select * from user where isnull(location)";
		
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
		});
	}
	
	public static int updateLocWithIdAndNewloc(String id,String newloc) {
//		int count =jdbcTemplate.queryForObject("select count(*) from dormitory where location=?", new Object[] {newloc},Integer.class);
		int count=DormitoryDaoImpl.judgeDormitoryExist(newloc);
		if(count==0)
			return 0;
		
		List<User> users = getUsersByLocation(newloc);
		if(users.size()>=4)
			return -1;
		
		
		String sql="UPDATE user SET location = ? WHERE id = ?";
		return jdbcTemplate.update(sql,new Object[] {newloc,id});
	}
	
	public static int updateLocToNULLWithID(String id) {
		String sql="UPDATE USER SET location=NULL WHERE id=?";
		return jdbcTemplate.update(sql,new Object[] {id});
	}
	
	public static int updateUserLocById(String id,String loc) {
		String sql="UPDATE USER SET location=? WHERE id=?";
		return jdbcTemplate.update(sql,new Object[] {loc,id});
	}
	
	public static String getLocById(String id) {
		return jdbcTemplate.queryForObject("select location from user where id=?",new Object[] {id},String.class);
	}
	
	public static int updateUserLocByAid(String aid) {
		String sql="UPDATE USER SET location=(SELECT toLoc FROM apply WHERE aid=?) WHERE id=(SELECT uid FROM apply WHERE aid=?)";
		return jdbcTemplate.update(sql,new Object[] {aid,aid});
	}
}
