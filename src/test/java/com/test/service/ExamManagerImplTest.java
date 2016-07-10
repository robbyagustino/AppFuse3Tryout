package com.test.service;

import org.appfuse.service.impl.BaseManagerMockTestCase;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.test.dao.core.QuestionDao;
import com.test.dao.model.Question;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertSame;
import static org.mockito.BDDMockito.*;

public class ExamManagerImplTest extends BaseManagerMockTestCase {
	
	@InjectMocks
    private ExamManagerImpl manager;
 
    @Mock
    private QuestionDao dao;
    
    @Test
    public void testGetQuestion() {
        log.debug("testing get...");
        //given
        final Long id = 7L;
        final Question question = new Question();
        given(dao.get(id)).willReturn(question);
        //when
        Question result = manager.get(id);
        //then
        assertSame(question, result);
    }
    
    @Test
    public void testGetQuestions() {
        log.debug("testing getAll...");
        //given
        final List questions = new ArrayList();
        given(dao.getAll()).willReturn(questions);
        //when
        List result = manager.getAll();
        //then
        assertSame(questions, result);
    }
 
    @Test
    public void testSaveQuestion() {
        log.debug("testing save...");
        //given
        final Question question = new Question();
        // enter all required fields
         
        given(dao.save(question)).willReturn(question);
        //when
        manager.save(question);
        //then
        verify(dao).save(question);
    }
    
    @Test
    public void testRemoveQuestion() {
        log.debug("testing remove...");
        //given
        final Long id = -11L;
        willDoNothing().given(dao).remove(id);
        //when
        manager.remove(id);
        //then
        verify(dao).remove(id);
    }

}
