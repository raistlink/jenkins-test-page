package NoticeBoard;

import java.util.ArrayList;

/**
 * Created by Work on 10/04/2015.
 */
public class Announcement {
    public String name;
    public String subject;
    public String comment;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Announcement(String name, String subject, String comment) {
        this.name = name;
        this.subject = subject;
        this.comment = comment;
    }
}