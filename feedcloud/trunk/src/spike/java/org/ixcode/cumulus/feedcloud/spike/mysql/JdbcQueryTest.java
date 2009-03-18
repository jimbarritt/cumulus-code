package org.ixcode.cumulus.feedcloud.spike.mysql;

import org.junit.*;
import static org.mockito.Mockito.*;

import java.sql.*;

public class JdbcQueryTest {

    @Test
    public void closesStatementWhenFails() {
        Connection connection = mock(Connection.class);
        JdbcQuery query = new JdbcQuery(connection, "SELECT * FROM ATABLE;");
        
    }
}
