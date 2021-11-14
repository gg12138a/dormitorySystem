package db;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import db.impl.DormitoryDaoImpl;
import db.impl.UserDaoImpl;
import domain.Dormitory;
import domain.User;

class DbTest {

//	@Test
//	void test() {
//		User user = UserDaoImpl.getUserByEmailAndPassword("b@b,com", "b");
//		System.out.println(user);
//	
//	}
	
	
//	@Test
//	void test1() {
//		User user = UserDaoImpl.getUserByUid(13);
//		System.out.println(user);
//	}
//	

	
//	@Test
//	void test() {
//		Dormitory dor = DormitoryDaoImpl.getDorByLocation("r516");
//		System.out.println(dor);
//	}
	
	
//	@Test
//	void test() {
//		List<User> users = UserDaoImpl.getUsersByLocation("ac");
//		
//		for(User u:users) {
//			System.out.println(u);
//		}
//		
//		
//	}
	
	@Test
	void test() {
		int res = UserDaoImpl.updateLocWithIdAndNewloc("13", "r517");
		System.out.println(res);
	}
}
