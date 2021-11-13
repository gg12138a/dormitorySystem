package db.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import db.DbUtils;

import domain.Dormitory;
import domain.User;

public class DormitoryDaoImpl {
	static JdbcTemplate jdbcTemplate = new JdbcTemplate(DbUtils.getDataSource());

	
	public static Dormitory getDorByLocation(String location) {
		String sql ="select * from dormitory where location=?";
		
		List<Dormitory> dors = jdbcTemplate.query(sql, new RowMapper<Dormitory>() {
			public Dormitory mapRow(ResultSet rs,int arg1) throws SQLException {
				Dormitory dor = new Dormitory();
				dor.setLocation(rs.getString("location"));
				dor.setNum(rs.getInt("num"));
				dor.setCharge(rs.getBigDecimal("charge"));
				
				return dor;
			}
		},location);
	

	if(dors.size()==0)
		return null;
	else
		return dors.get(0);
		
	}

	
}
