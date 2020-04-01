package com.phantom.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
public interface Mapper<R> {

    R map(ResultSet resultSet) throws SQLException;
}