package com.phantom.services;

import java.util.ArrayList;

import com.phantom.models.Entity;
import com.phantom.models.Question;
import com.phantom.models.Test;
import com.phantom.utils.Manager;

public class TestService {

    /*public Test findById(Long id) {
        return (Test)Manager.getInstance().getById(id, Test.getTable(), Test.getMapper());
    }*/

    public ArrayList<Test> findAll() {
        ArrayList<Test> res = new ArrayList<Test>();
        for (Entity e : Manager.getInstance().list(Test.getTable(), Test.getMapper())) {
            res.add((Test)e);
        }
        return res;
    }

    public ArrayList<Question> getQuestions(Long id) {
        ArrayList<Question> res = new ArrayList<Question>();
        for (Entity e : Manager.getInstance().oneToManyList(id, Question.getTable(), Question.getMapper())) {
            res.add((Question)e);
        }
        return res;
    }

    public void Create(String[] questions) {
        Long key = Manager.getCount();
        Manager.getInstance().createTest();
        for (String question : questions) {
            Manager.getInstance().createQuestion(question, key);
        }
    }

    public void Edit(Long id, String[] questions) {
        for (String question : questions) {
            Manager.getInstance().updateQuestion(id, question);
        }
    }

    public void Destroy(Long id) {
        ArrayList<Question> questions = getQuestions(id);
        for (Question question : questions) {
            Manager.getInstance().delete(question.getId(), Question.getTable());
        }
        Manager.getInstance().delete(id, Test.getTable());
    }

	public TestService() {
        Test.setTable("test");
        Test.initMapper();

        Question.setTable("question");
        Question.initMapper();
	}

}