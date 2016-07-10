package com.test.dao.core;

import org.appfuse.dao.hibernate.GenericDaoHibernate;

import com.test.dao.model.ChoiceAnswer;

public class ChoiceAnswerDaoHibernate extends
		GenericDaoHibernate<ChoiceAnswer, Long> implements ChoiceAnswerDao {

	public ChoiceAnswerDaoHibernate(Class<ChoiceAnswer> persistentClass) {
		super(persistentClass);
	}

}
