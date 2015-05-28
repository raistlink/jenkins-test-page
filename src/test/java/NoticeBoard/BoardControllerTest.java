package NoticeBoard;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Boots on 28/05/2015.
 */
public class BoardControllerTest {

    @Test
    public void testMain() throws Exception {
        Announcement anno = new Announcement("Pedro", "Comida", "Tengo Hambre");
        Announcement anno2 = new Announcement("Pedro2", "Comida2", "Tengo Hambre2");

        ArrayList<Announcement> anuncios = new ArrayList<Announcement>();
        anuncios.add(anno);
        anuncios.add(anno2);

        assertEquals(anno.getName(), anuncios.get(0).getName());
        assertEquals(anno2.getName(), anuncios.get(1).getName());
    }

}