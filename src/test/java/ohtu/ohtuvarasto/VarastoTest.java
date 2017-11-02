package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    @Test
    public void otetaanEnemmanKuinOnSaldoa() {
        varasto.otaVarastosta(varasto.getSaldo()+1);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
        
    }
    @Test
    public void laitetaanEnemmanKuinOnTilaa() {
        varasto.lisaaVarastoon(varasto.getTilavuus()+1);
        assertEquals(varasto.getTilavuus(), varasto.getSaldo(), vertailuTarkkuus);
        
    }
    
    @Test
    public void otetaanNegatiivinen() {
        assertEquals(0.0, varasto.otaVarastosta(-1), vertailuTarkkuus);
    }
    
    @Test
    public void LaitetaanNegatiivinen() {
        double s = varasto.getSaldo();
        varasto.lisaaVarastoon(-1);
        assertEquals(s, varasto.getSaldo(), vertailuTarkkuus);
  
    }
    
    @Test
    public void stringToimii() {
        varasto.lisaaVarastoon(1);
        assertEquals(varasto.toString(), varasto.toString());
    }
    @Test
    public void tilavuusAlussaNolla() {
        Varasto v = new Varasto(0);
        assertEquals(0.0, v.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void luoVarastonTilavuusJaAlkusaldo() {
        Varasto v = new Varasto(10, 5);
        assertEquals(v.toString(), v.toString());
    }

    @Test
    public void luoVarastonTilavuusJaAlkusaldoNegatiivisia() {
        Varasto v = new Varasto(-10, -5);
        assertEquals(v.toString(), v.toString());
    }

    @Test
    public void tilavuusAlleNolla() {
        Varasto v = new Varasto(-1, 0);
        assertEquals(v.toString(), v.toString());
        //done
    }


}