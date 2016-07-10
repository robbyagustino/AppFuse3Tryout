package com.test.dao.core;

import java.util.List;
import java.util.Map;

import org.appfuse.dao.SearchException;
import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

import com.test.dao.model.Question;

@Repository("questionDao")
public class QuestionDaoHibernate extends GenericDaoHibernate<Question, Long>
		implements QuestionDao {
	
	

	public QuestionDaoHibernate(Class<Question> persistentClass) {
		super(persistentClass);
	}


	@Override
	public List<Question> find() {
		return getAll();
	}

}
