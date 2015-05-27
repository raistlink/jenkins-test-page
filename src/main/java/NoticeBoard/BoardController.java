package NoticeBoard;

import java.sql.*;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class BoardController {

    ArrayList<Announcement> announcements = new ArrayList<Announcement>();

    @RequestMapping("/webpage/")
    public ModelAndView main(HttpSession session) throws SQLException, ClassNotFoundException{

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "admin");

        String createDatabase = "CREATE DATABASE IF NOT EXISTS Announcements";
        String createTable = "CREATE TABLE IF NOT EXISTS Anuncios" +
                "(name VARCHAR(15)," +
                "subject VARCHAR(15)," +
                "comments LONGTEXT," +
                "PRIMARY KEY (name,subject))";

        Statement statement = connection.createStatement();
        statement.execute(createDatabase);
        connection.close();

        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Announcements", "root", "admin");
        statement = connection.createStatement();
        statement.execute(createTable);

        announcements.clear();

        String query = "SELECT * FROM Anuncios";
        Statement queryStatement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);

        while(rs.next()){
            String name = rs.getString("name");
            String subject = rs.getString("subject");
            String comments = rs.getString("comments");

            Announcement newAnnouncement = new Announcement(name,subject,comments);
            announcements.add(newAnnouncement);
        }

        return new ModelAndView("main").addObject("isNew", session.isNew()).addObject("announcements",announcements);
    }
    @RequestMapping("/new")
    public ModelAndView newAnnouncement(HttpSession session){
        String name = (String) session.getAttribute("username");
        return new ModelAndView("new").addObject("name", name);
    }
    @RequestMapping("/insert")
    public ModelAndView insert(HttpSession session, @RequestParam String name,@RequestParam String subject, @RequestParam String comment) throws SQLException, ClassNotFoundException {
        session.setAttribute("username", name);
        if(name != "" && subject != ""){
            Class.forName("com.mysql.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Announcements", "root", "admin");
            Statement statement = connection.createStatement();

            String insert = "INSERT INTO Anuncios VALUES ('"+name+"','"+subject+"','"+comment+"')";
            statement.execute(insert);

        }
        return new ModelAndView("insert");
    }
    @RequestMapping("/{postNumber}")
    public ModelAndView view(@PathVariable int postNumber){
        return new ModelAndView("view").addObject("announcement",announcements.get(postNumber));
    }
}
