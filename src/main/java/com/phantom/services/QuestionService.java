package com.phantom.services;

import java.util.ArrayList;

import com.phantom.models.Entity;
import com.phantom.models.Question;
import com.phantom.utils.Manager;

public class QuestionService {

    private static Long count = 1L;

    public Question findById(Long id) {
        return null;
    }

    public ArrayList<Question> findAll() {
        ArrayList<Question> res = new ArrayList<Question>();
        for (Entity e : Manager.getInstance().list(Question.getTable(), Question.getMapper())) {
            res.add((Question)e);
        }
        return res;
    }

    public void Create(String text, Long testId) {
        Manager.getInstance().create(Question.getTable(), ", " + "'" + text + "'" + ", " + testId, count++);
    }

    public void Save(Question test) {

    }

    public void Destroy(Question test) {

    }

	public QuestionService() {
        Question.setTable("question");
        Question.initMapper();
	}

	public static Long getCount() {
		return count;
	}

	public static void setCount(Long count) {
		QuestionService.count = count;
	}


}