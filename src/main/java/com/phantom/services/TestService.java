package com.phantom.services;

import java.util.ArrayList;

import com.phantom.models.Entity;
import com.phantom.models.Question;
import com.phantom.models.Test;
import com.phantom.utils.Manager;

public class TestService {

    private static Long count = 1L;
    private final QuestionService questionService;

    public Test findById(Long id) {
        return (Test)Manager.getInstance().getById(id, Test.getTable(), Test.getMapper());
    }

    public ArrayList<Test> findAll() {
        final ArrayList<Test> res = new ArrayList<Test>();
        for (final Entity e : Manager.getInstance().list(Test.getTable(), Test.getMapper())) {
            res.add((Test)e);
        }
        return res;
    }

    public ArrayList<Question> getQuestions(final Long id) {
        final ArrayList<Question> res = new ArrayList<Question>();
        for (final Entity e : Manager.getInstance().oneToManyList(id, Question.getTable(), Question.getMapper())) {
            res.add((Question)e);
        }
        return res;
    }

    public void Create(final String[] questions) {
        Manager.getInstance().create(Test.getTable(), "", count++);
        for (String question : questions) {
            questionService.Create(question, count - 1);
            //Manager.getInstance().create(Question.getTable(), ", " + "'" + question + "'" + ", " + count.toString(), count++);
        }
    }

    public void Edit(final Long id, final String[] questions) {
        for (final String question : questions) {
            Manager.getInstance().updateQuestion(id, question);
        }
    }

    public void Destroy(final Long id) {
        final ArrayList<Question> questions = getQuestions(id);
        for (final Question question : questions) {
            Manager.getInstance().delete(question.getId(), Question.getTable());
        }
        Manager.getInstance().delete(id, Test.getTable());
    }

	public TestService() {
        Test.setTable("test");
        Test.initMapper();
        questionService = new QuestionService();
    }


}