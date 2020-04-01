package com.phantom.models;

import java.io.Serializable;
import java.util.Objects;

import com.phantom.utils.Mapper;

public class Question extends Entity implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static Mapper<Entity> mapper;
	private static String table;

    private Long id;
    private String text;
	private Long testId;
	

	public Long getId() {
		return id;
    }
    
	public void setId(Long id) {
		this.id = id;
    }
    
	public String getText() {
		return text;
    }
    
	public void setText(String text) {
		this.text = text;
    }

    public Long getTestId() {
		return testId;
    }
    
	public void setTestId(Long testId) {
		this.testId = testId;
	}
    
	public Question() {

    }
    
	public Question(Long id, String text, Long testId) {
		this.id = id;
        this.text = text;
		this.testId = testId;
    }
    
	@Override
	public boolean equals(Object obj) {	
		if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Question quest = (Question) obj;
        return Objects.equals(id, quest.id);
    }
    
	@Override
	public int hashCode() {
		return Objects.hash(id);
    }
    
	@Override
	public String toString() {	
		return text;
    }

	public static void initMapper() {
		Question.setMapper(resultSet -> {
			long id = resultSet.getLong("id");
			String text = resultSet.getString("text");
			Long testId = resultSet.getLong("test_id");

			Question question = new Question(id, text, testId);

			return question;
		});
	}

	public static Mapper<Entity> getMapper() {
		return mapper;
	}

	public static void setMapper(Mapper<Entity> mapper) {
		Question.mapper = mapper;
	}

	public static String getTable() {
		return table;
	}

	public static void setTable(String table) {
		Question.table = table;
	}

	/*public static void setMapper(Mapper<Question> mapper) {
		Question.mapper = mapper;
	}*/
}