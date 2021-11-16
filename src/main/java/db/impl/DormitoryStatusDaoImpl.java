package db.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import db.DbUtils;
import domain.DormitoryStatus;
import domain.User;


public class DormitoryStatusDaoImpl {
	
	static JdbcTemplate jdbcTemplate = new JdbcTemplate(DbUtils.getDataSource());

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
}
