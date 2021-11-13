package db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import domain.User;

public class DbUtils {
	private static DataSource ds; 
	
	static {
		Properties p =new Properties();
		InputStream inputStream = DbUtils.class.getResourceAsStream("druid.properties");

		try {
			p.load(inputStream );
			ds = DruidDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static DataSource getDataSource() {
		return ds;
	}
	
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
	
	public static void close(ResultSet rs,Statement stmt,Connection conn) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
	
	public static void close(Statement stmt,Connection conn) {
		close(null,stmt,conn);
	}
	
	
	public static void main(String[] args) {
		
	}
}
