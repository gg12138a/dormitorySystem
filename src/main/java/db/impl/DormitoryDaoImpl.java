package db.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import db.DbUtils;

import domain.Dormitory;
import domain.DormitoryStatus;
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

	public static int judgeDormitoryExist(String location) {
		return jdbcTemplate.queryForObject("select count(*) from dormitory where location=?", new Object[] {location},Integer.class);
	}
	
	public static List<DormitoryStatus> getAllDormitoriesStatus(){
		String sql="select dormitory.`location`,sum(if(isnull(user.`id`),0,1)) as peoplecount\r\n"
				+ "	from dormitory \r\n"
				+ "	left join user \r\n"
				+ "	on dormitory.`location`=user.`location`\r\n"
				+ "	group by dormitory.`location`;";		
		return jdbcTemplate.query(sql, new RowMapper<DormitoryStatus>() {
			public DormitoryStatus mapRow(ResultSet rs,int arg1) throws SQLException {
				DormitoryStatus d = new DormitoryStatus();
				d.setLocation(rs.getString("location"));
				d.setPeopleCounts(rs.getInt("peoplecount"));

				return d;
			}
		});
		
	}
	
	public static int getPeopleCountByApplyId(String aid) {
		String sql="SELECT COUNT(*) FROM USER AS u,apply AS a WHERE a.toLoc=u.`location` AND a.`aid`=?";
		
		return jdbcTemplate.queryForObject(sql,new Object[] {aid},Integer.class);
	}
	
}
