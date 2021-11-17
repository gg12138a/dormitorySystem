package db;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import db.impl.ApplyDaoImpl;
import db.impl.DormitoryDaoImpl;
import db.impl.UserDaoImpl;
import domain.Apply;
import domain.Dormitory;
import domain.DormitoryStatus;
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
//		User user = UserDaoImpl.getUserByUid("13");
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
	
//	@Test
//	void test() {
////		int res = UserDaoImpl.updateLocWithIdAndNewloc("13", "r516");
//		int res = UserDaoImpl.updateLocToNULLWithID("13");
//		System.out.println(res);
//	}
	

//	@Test
//	void test() {
//		List<DormitoryStatus> statusList = DormitoryStatusDaoImpl.getUsersByLocation();
//		System.out.println(statusList);
//	}
//	
//	@Test
//	void test() {
//		List<User> users = UserDaoImpl.getUsersNotIn();
//		System.out.println(users);
//	}
	
//	@Test
//	void test() {
//		int res = UserDaoImpl.updateUserLocById("12345","r517");
//		System.out.println(res);
//	}
	
	@Test
	void test() {
		List<Apply> appliesById = ApplyDaoImpl.getAppliesById("1312");
		System.out.println(appliesById);
	}
}
