package db.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import db.DbUtils;
import domain.Apply;
import domain.Dormitory;

public class ApplyDaoImpl {
	static JdbcTemplate jdbcTemplate = new JdbcTemplate(DbUtils.getDataSource());

	public static int insertApply(String uid,String fLoc,String tLoc) {
		String sql="insert into apply(uid,fromLoc,toLoc,generateTime) values(?,?,?,NOW())";
		
		return jdbcTemplate.update(sql,new Object[] {uid,fLoc,tLoc});
	}
	
	
	public static List<Apply>getAppliesById(String uid){
		
		String sql ="select * from apply where uid=?";
		
		return jdbcTemplate.query(sql, new RowMapper<Apply>() {
			public Apply mapRow(ResultSet rs,int arg1) throws SQLException {
				Apply apply = new Apply();
				apply.setAid(rs.getInt("aid"));
				apply.setUid(rs.getString("uid"));
				apply.setFromLoc(rs.getString("fromLoc"));
				apply.setToLoc(rs.getString("toLoc"));
				apply.setReviewed(rs.getBoolean("reviewed"));
				apply.setPassed(rs.getBoolean("passed"));
				apply.setGenerateTime(rs.getString("generateTime"));
				apply.setReviewedTime(rs.getString("reviewedTime"));
				return apply;
			}
		},uid);
	}
}
