package org.ixcode.cumulus.feedcloud.spike.mysql;

import org.junit.*;
import static org.junit.Assert.assertEquals;

import java.util.*;

public class MySqlCrudTest {

    @Test
      public void canDoCrudStuff() throws Exception {
          MySqlCrud mySqlCrud = new MySqlCrud("localhost", "cumulusdb", "cumulusapp", "cumulus");

          mySqlCrud.connect();

          try {
              mySqlCrud.execute("create table TEST (id INT, name VARCHAR(50));");

              mySqlCrud.execute("insert into TEST (id, name) VALUES(666, 'louis cypher');");

              List<String> rows = mySqlCrud.executeQuery("select * from TEST;");
              assertEquals("rows", 1, rows.size());
              assertEquals("666|louis cypher", rows.get(0));

              mySqlCrud.execute("delete from TEST;");

              rows = mySqlCrud.executeQuery("select * from TEST;");
              assertEquals("rows", 0, rows.size());

          } finally {
              try {
                  mySqlCrud.execute("DROP TABLE TEST;");
              } finally {
                  mySqlCrud.disconnect();
              }
          }
      }

}
