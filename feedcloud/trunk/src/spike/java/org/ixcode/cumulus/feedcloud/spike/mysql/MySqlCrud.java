package org.ixcode.cumulus.feedcloud.spike.mysql;

import java.sql.*;
import java.util.*;

public class MySqlCrud {
    private String host;
    private String database;
    private String user;
    private String password;
    private Connection connection;


    public MySqlCrud(String host, String database, String user, String password) {
        this.host = host;
        this.database = database;
        this.user = user;
        this.password = password;

        checkThatMySqlDriverIsOnClasspath();
    }

    public void connect() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://" + host + "/" + database + "?user=" + user + "&password=" + password);
    }

    public void disconnect() throws SQLException {
        connection.close();
        connection = null;
    }

    public void execute(String sql) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute(sql);
        stmt.close();
    }

    public List<String> executeQuery(String sql) throws SQLException {
        return new JdbcQuery(connection, sql).execute();
    }

    private static void checkThatMySqlDriverIsOnClasspath() {
        try {
            Class.forName("org.gjt.mm.mysql.Driver").newInstance();
        }

        catch (Exception e) {
            System.err.println("Unable to load driver from the classpath. Have you added the JDBC MySQL driver?");
            e.printStackTrace();
        }
    }


}
