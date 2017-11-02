/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import reader.Reader;
import java.util.List;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author mkatri
 */
public class StatisticsTest {
    
     Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }  
    
    @Test
    public void searchPlayerNull() {
        assertEquals(null,stats.search("jokunenhanonpi"));
    }

    @Test
    public void searchPlayer() {
        assertEquals("Yzerman",stats.search("man").getName());
    }
    
    @Test
    public void ListTeam() {
        assertNotNull(stats.team("PIT"));
    }
   
    @Test
    public void ListTopScores() {
        assertNotNull(stats.topScorers(1));
    }

}
