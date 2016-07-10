package com.test.dao.core;

import org.appfuse.dao.hibernate.GenericDaoHibernate;

import com.test.dao.model.TestExam;

public class TestExamDaoHibernate extends GenericDaoHibernate<TestExam, Long>
		implements TestExamDao {

	public TestExamDaoHibernate(Class<TestExam> persistentClass) {
		super(persistentClass);
	}

}
