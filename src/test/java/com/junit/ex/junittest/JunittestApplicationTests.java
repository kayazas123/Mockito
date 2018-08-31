package com.junit.ex.junittest;

import com.junit.ex.junittest.basic.StringHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JunittestApplicationTests {

	StringHelper stringHelper = new StringHelper();

	@Test
	public void contextLoads() {
	}

	@Test
	public void testTrancateAInFirst2Positions_AInFirst2Pos(){
		assertEquals("CD",stringHelper.truncateAInFirst2Positions("AACD"));
	}

	@Test
	public void test2TransactAInFirst2Positions_AInFirstPos(){
		assertEquals("CD",stringHelper.truncateAInFirst2Positions("ACD"));
	}

	@Test
	public void testAreFirst2CharsAndLast2CharsSame_ABCD(){
		assertFalse(stringHelper.areFirstAndLastTwoCharactersTheSame("ABCD"));
	}

	@Test
	public void testAreFirst2CharsAndLast2CharsSame_ABAB(){
		assertTrue(stringHelper.areFirstAndLastTwoCharactersTheSame("ABAB"));
	}

	@Test
	public void testAreFirst2CharsAndLast2CharsSame_AB(){
		assertTrue(stringHelper.areFirstAndLastTwoCharactersTheSame("AB"));
	}

	@Test
	public void testAreFirst2CharsAndLast2CharsSame_A(){
		assertFalse(stringHelper.areFirstAndLastTwoCharactersTheSame("A"));
	}



}
