package com.jsp.prc.serviceImpl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import com.jsp.prc.entity.Admin;
import com.jsp.prc.entity.Employee;
import com.jsp.prc.repository.AdminRepository;
@ExtendWith(MockitoExtension.class)
class AdminServiceImplTest extends AdminServiceImpl {

	@Mock
	AdminRepository repo;
	
	@InjectMocks
	AdminServiceImpl adminServiceImpl;
	
	static ArrayList<Admin> l1;
	static Admin a1,a2,a3,a4;

	
	@BeforeEach
	void initEachTime() {
		l1=new ArrayList<Admin>();
		a1=new Admin("121","manju","manju@gmail.com","123","9080706060");
		a2=new Admin("122","sanju","sanju@gmail.com","234","9080706061");
		a3=new Admin("123","arjun","arjun@gmail.com","345","9080706062");
		a4=new Admin("124","karan","karan@gmail.com","678","9080706063");
		Admin arr[]= {a1,a2,a3,a4};
		Arrays.asList(arr).stream().forEach(ele->l1.add((Admin) ele));
	}
	
	@Test
	void testLogin() {
		Mockito.when(repo.adminLogin("manju@gmail.com", "123")).thenReturn(a1);
		String login = adminServiceImpl.login("manju@gmail.com", "123");
		Assertions.assertEquals(login, "Admin Login Sucessfully");
	}
	
//	@Test
//	void testCreateEmployee() {
//		Mockito.when(repo.save(a1)).thenReturn(a1);
//		adminServiceImpl.createEmployee(null);
//		Assertions.assertEquals(a1.getAid(),);
//	}
//
//	@Test
//	void testEditEmployee() {
//		fail("Not yet implemented");
//	}

//	@Test
//	void testRemoveEmployee() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testFindEmpById() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testFindAllEmp() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testFindProjectById() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testFindAllProject() {
//		fail("Not yet implemented");
//	}

}
