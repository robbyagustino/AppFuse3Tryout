package com.test.dao.core;

import java.util.List;

import org.appfuse.dao.GenericDao;

import com.test.dao.model.Question;

public interface QuestionDao extends GenericDao<Question, Long> {

	public List<Question> find();

}
