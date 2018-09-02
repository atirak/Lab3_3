import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class oxTest {

    @Test
    public void shouldCreateOXObjectCorrectly() {
        ox ox = new ox();
        // " 012\n0---\n1---\n2---\n"
        assertEquals(" 012\n0---\n1---\n2---\n",ox.getTableString());
        assertEquals("X", ox.getCurrentPlayer());
        assertEquals(0, ox.getScoreO());
        assertEquals(0, ox.getScoreX());
        assertEquals(0, ox.getScoreDraw());
    }
    @Test
    public void put() {
        ox ox = new ox();
        ox.put(1,1);
        assertEquals(" 012\n0---\n1-X-\n2---\n" ,ox.getTableString() );
        ox.put(0,0);
        assertEquals(" 012\n0X--\n1-X-\n2---\n" ,ox.getTableString() );
        ox.put(2,1);
        assertEquals(" 012\n0X--\n1-XX\n2---\n" ,ox.getTableString() );

        ox.switchPlayer();
        ox.put(0,2);
        assertEquals(" 012\n0X--\n1-XX\n2O--\n" ,ox.getTableString() );
        assertEquals(false,ox.put(0,2));

    }
    @Test
    public void switchPlayer(){
        ox ox = new ox();
        ox.switchPlayer();
        assertEquals("O" ,ox.getCurrentPlayer());

    }
    @Test
    public void checkWinCol(){
        ox ox = new ox();
        ox.put(0,0);
        ox.put(0,1);
        ox.put(0,2);
        assertTrue(ox.checkWin(0,0));
        assertTrue(ox.checkWin(0,1));
        assertTrue(ox.checkWin(0,2));

    }
    @Test
    public void checkWinRow(){
        ox ox = new ox();
        ox.put(0,0);
        ox.put(1,0);
        ox.put(2,0);
        assertTrue(ox.checkWin(0,0));
        assertTrue(ox.checkWin(1,0));
        assertTrue(ox.checkWin(2,0));

    }
    @Test
    public void checkES(){
        ox ox = new ox();
        ox.put(0,0);
        ox.put(1,1);
        ox.put(2,2);
        assertTrue(ox.checkWin(0,0));
        assertTrue(ox.checkWin(1,1));
        assertTrue(ox.checkWin(2,2));

    }
    @Test
    public void checkSS(){
        ox ox = new ox();
        ox.put(2,0);
        ox.put(1,1);
        ox.put(0,2);
        assertTrue(ox.checkWin(2,0));
        assertTrue(ox.checkWin(1,1));
        assertTrue(ox.checkWin(0,2));

    }
    @Test
    public void reset(){
        ox ox = new ox();
        ox.put(1,1);
        assertEquals(" 012\n0---\n1-X-\n2---\n" ,ox.getTableString() );
        ox.reset();
        assertEquals(" 012\n0---\n1---\n2---\n" ,ox.getTableString() );
    }
    @Test
    public void getScore(){
        ox ox = new ox();
        ox.put(2,0);
        ox.put(1,1);
        ox.put(0,2);

        assertEquals(1 ,ox.getScoreX());
    }
    @Test
    public void getDraw(){
        ox ox = new ox();
        ox.put(0,0);
        ox.put(0,1);
        ox.put(0,2);
        assertFalse(ox.isDraw());
        ox.put(1,0);
        ox.put(1,1);
        ox.put(1,2);
        assertFalse(ox.isDraw());
        ox.put(2,0);
        ox.put(2,1);
        ox.put(2,2);
        assertTrue(ox.isDraw());
    }
}