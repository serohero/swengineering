package swg3;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import swg3.InfoManagement.Contact;
import swg3.InfoManagement.Todolist;
import swg3.InfoManagement.newContact;

import org.junit.Before;
import org.junit.jupiter.api.*;

class InfoTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	
	@Test
	void test() {
		  int tmp;
		   Contact info = new Contact();

		   tmp = info.list_contact();
		   assertNotNull(tmp);

	
		/*newContact newcontact = new newContact("aaa", "bbb", "ccc");
		
		Contact con = new Contact();
		String name = "abc";
		assertTrue(con.detail_contact());
	*/
		
		
		
	}

	@Test
	void test2() {
		  int tmp;
		   Todolist info = new Todolist();

		   tmp = info.list_todolist();
		   assertNotNull(tmp);

	
		/*newContact newcontact = new newContact("aaa", "bbb", "ccc");
		
		Contact con = new Contact();
		String name = "abc";
		assertTrue(con.detail_contact());
	*/
		
		
		
	}

	

}
