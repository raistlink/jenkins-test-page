package NoticeBoard;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


import java.util.ArrayList;

import static org.junit.Assert.*;
/**
 * Created by Boots on 28/05/2015.
 */
public class generalIT{

    @Test
    public void testDatabaseSelect() throws Exception{

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Announcements", "root", "admin");

        String query = "SELECT * FROM Anuncios";
        Statement queryStatement = connection.createStatement();
        ResultSet rs = queryStatement.executeQuery(query);

        while(rs.next()){

            Announcement anno = new Announcement(rs.getString(1), rs.getString(2), rs.getString(3));
            assertEquals(anno.getName(), rs.getString(1));
            assertEquals(anno.getSubject(), rs.getString(2));
            assertEquals(anno.getComment(), rs.getString(3));
        }

        connection.close();
    }

    @Test
    public void testDatabaseInput() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Announcements", "root", "admin");
        Statement statement = connection.createStatement();

        String insert = "INSERT INTO Anuncios VALUES ('Pablo','Martinez','Quiere silencio')";
        statement.execute(insert);

        String query = "SELECT * FROM Anuncios";
        Statement queryStatement = connection.createStatement();
        ResultSet rs = queryStatement.executeQuery(query);

        rs.last();
        assertEquals(rs.getString(1), "Pablo");

        String delete = "DELETE FROM Anuncios WHERE comments = 'Quiere silencio'";
        Statement deleteStatement = connection.createStatement();
        deleteStatement.execute(delete);

        connection.close();

    }




}
