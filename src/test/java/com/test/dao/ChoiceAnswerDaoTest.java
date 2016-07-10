package com.test.dao;

import org.appfuse.dao.BaseDaoTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.test.dao.core.ChoiceAnswerDao;
import com.test.dao.model.ChoiceAnswer;

import static org.junit.Assert.*;

public class ChoiceAnswerDaoTest extends BaseDaoTestCase {
	
	@Autowired
	private ChoiceAnswerDao choiceAnswerDao;
	
	@Test(expected = DataAccessException.class)
	public void testAddAndRemovePerson() throws Exception {
		ChoiceAnswer choiceAnswer = new ChoiceAnswer();
		choiceAnswer.setAnswerText("");
	 
		choiceAnswer = choiceAnswerDao.save(choiceAnswer);
	    flush();
	 
	    choiceAnswer = choiceAnswerDao.get(choiceAnswer.getId());
	 
	    assertEquals("", choiceAnswer.getAnswerText());
	    assertNotNull(choiceAnswer.getId());
	 
	    log.debug("removing question...");
	 
	    choiceAnswerDao.remove(choiceAnswer.getId());
	    flush();
	 
	    // should throw DataAccessException
	    choiceAnswerDao.get(choiceAnswer.getId());
	}
}
