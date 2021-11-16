package db.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import db.DbUtils;
import domain.AdminUser;
import domain.User;

public class AdminUserDaoImpl {
	static JdbcTemplate jdbcTemplate = new JdbcTemplate(DbUtils.getDataSource());

	public static AdminUser getAdminUserByEmailAndPassword(String email,String password) {
		String sql ="select * from adminuser where email=? and password=?";
		
		List<AdminUser> users = jdbcTemplate.query(sql, new RowMapper<AdminUser>() {
			public AdminUser mapRow(ResultSet rs,int arg1) throws SQLException {
				AdminUser u = new AdminUser();
				u.setId(rs.getInt("id"));
				u.setEmail(rs.getString("email"));
				u.setPassword(rs.getString("password"));
				u.setUsername(rs.getString("username"));
				return u;
			}
		},email,password);
	

	if(users.size()==0)
		return null;
	else
		return users.get(0);
	}
	
}
