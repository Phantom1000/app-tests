package com.phantom.models;

import java.io.Serializable;
import java.util.Objects;

import com.phantom.utils.Mapper;

public class Test extends Entity implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static Mapper<Entity> mapper;
	private static String table;

    private Long id;

	public Long getId() {
		return id;
    }
    
	public void setId(Long id) {
		this.id = id;
    }

	public Test() {
		
	}

	public Test(Long id) {
		this.id = id;
	}
    
    @Override
	public boolean equals(Object obj) {	
		if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Test test = (Test) obj;
        return Objects.equals(id, test.id);
    }
    
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public static void initMapper() {
		Test.setMapper(resultSet -> {
			long id = resultSet.getLong("id");

			Test test = new Test(id);

			return test;
		});
	}

	public static Mapper<Entity> getMapper() {
		return mapper;
	}

	public static void setMapper(Mapper<Entity> mapper) {
		Test.mapper = mapper;
	}

	public static String getTable() {
		return table;
	}

	public static void setTable(String table) {
		Test.table = table;
	}
	
}