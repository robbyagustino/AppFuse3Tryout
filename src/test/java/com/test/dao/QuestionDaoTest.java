package com.test.dao;

import java.util.List;

import org.appfuse.dao.BaseDaoTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.test.dao.core.QuestionDao;
import com.test.dao.model.Question;

import static org.junit.Assert.*;

public class QuestionDaoTest extends BaseDaoTestCase {
	
	 @Autowired
	 private QuestionDao questionDao;
	
	@Test
	public void testFindQuestion() throws Exception {
	    List<Question> questions = questionDao.find();
	    assertTrue(questions.size() > 0);
	}
	
	@Test(expected = DataAccessException.class)
	public void testAddAndRemovePerson() throws Exception {
		Question question = new Question();
		question.setTitle("");
		question.setDescription("");
	 
		question = questionDao.save(question);
	    flush();
	 
	    question = questionDao.get(question.getId());
	 
	    assertEquals("", question.getDescription());
	    assertNotNull(question.getId());
	 
	    log.debug("removing question...");
	 
	    questionDao.remove(question.getId());
	    flush();
	 
	    // should throw DataAccessException
	    questionDao.get(question.getId());
	}
	

}
