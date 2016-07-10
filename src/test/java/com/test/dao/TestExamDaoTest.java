package com.test.dao;

import org.appfuse.dao.BaseDaoTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.test.dao.core.TestExamDao;
import com.test.dao.model.TestExam;

import static org.junit.Assert.*;

public class TestExamDaoTest extends BaseDaoTestCase {

	@Autowired
	private TestExamDao testExamDao;
	
	@Test(expected = DataAccessException.class)
	public void testAddAndRemovePerson() throws Exception {
		TestExam testExam = new TestExam();
		testExam.setName("");
	 
		testExam = testExamDao.save(testExam);
	    flush();
	 
	    testExam = testExamDao.get(testExam.getId());
	 
	    assertEquals("", testExam.getName());
	    assertNotNull(testExam.getId());
	 
	    log.debug("removing question...");
	 
	    testExamDao.remove(testExam.getId());
	    flush();
	 
	    // should throw DataAccessException
	    testExamDao.get(testExam.getId());
	}
}
