package NoticeBoard;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Boots on 28/05/2015.
 */
public class AnnouncementTest {

    @Test
    public void testConstructor() throws Exception{
        String testString1 = "Pablo";
        String testString2 = "Martinez";
        String testString3 = "Hola";

        Announcement anno = new Announcement(testString1,testString2,testString3);

        assertEquals(testString1,anno.getName());
        assertEquals(testString2,anno.getSubject());
        assertEquals(testString3,anno.getComment());
    }

    @Test
    public void testSetSubject() throws Exception {
        String testString = "Hola";
        Announcement anno = new Announcement("Pedro", "Comida", "Tengo Hambre");

        anno.setSubject(testString);
        assertEquals(testString,anno.getSubject());
    }

    @Test
    public void testSetName() throws Exception {
        String testString = "Hola";
        Announcement anno = new Announcement("Pedro", "Comida", "Tengo Hambre");

        anno.setName(testString);
        assertEquals(testString,anno.getName());
    }

    @Test
    public void testSetComment() throws Exception {
        String testString = "Hola";
        Announcement anno = new Announcement("Pedro", "Comida", "Tengo Hambre");

        anno.setComment(testString);
        assertEquals(testString,anno.getComment());
    }
}