package org.ixcode.cumulus.feedcloud.spike.mysql;

import java.sql.*;
import java.util.*;

public class JdbcQuery {
    private Connection connection;
    private String sql;

    public JdbcQuery(Connection connection, String sql) {
        this.connection = connection;
        this.sql = sql;
    }

    public List<String> execute() throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);

        try {
            return convertResultSetToStringRows(resultSet);
        } finally {
            resultSet.close();
            stmt.close();
        }
    }

    private static List<String> convertResultSetToStringRows(ResultSet resultSet) throws SQLException {
        int columnCount = resultSet.getMetaData().getColumnCount();

        List<String> rows = new ArrayList<String>();
        while (resultSet.next()) {
            rows.add(rowAsString(resultSet, columnCount));
        }
        return rows;
    }

    private static String rowAsString(ResultSet resultSet, int columnCount) throws SQLException {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i <= columnCount; i++) {
            stringBuilder.append(resultSet.getString(i));
            if (i < columnCount) {
                stringBuilder.append("|");
            }
        }

        return stringBuilder.toString();
    }

}
