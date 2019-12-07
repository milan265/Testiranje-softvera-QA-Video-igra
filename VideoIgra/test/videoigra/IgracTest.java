package videoigra;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.stream.Stream;

public class IgracTest {
    private final static double DELTA = 0.1;
    private ArrayList<Oruzje> oruzja;
    private ArrayList<Odeca> odeca;
    private ArrayList<Magija> magije;

    @Test
    public void getNaziv(){
        Igrac igrac = new Igrac("igrac", 50.0, 75.5,35,70, Igrac.Stanje.AGRESIVNO, oruzja, odeca, magije);
        Assertions.assertEquals("igrac", igrac.getNaziv());
    }

    @Test
    public void setNaziv(){
        Igrac igrac = new Igrac("igrac", 50.0, 75.5,35,70, Igrac.Stanje.AGRESIVNO, oruzja, odeca, magije);
        igrac.setNaziv("nov naziv");
        Assertions.assertEquals("nov naziv", igrac.getNaziv());
    }

    @Test
    public void getZdravlje(){
        Igrac igrac = new Igrac("igrac", 50.0, 75.5,35,70, Igrac.Stanje.AGRESIVNO, oruzja, odeca, magije);
        Assertions.assertEquals(50.0, igrac.getZdravlje(), DELTA);
    }

    @Test
    public void setZdravlje(){
        Igrac igrac = new Igrac("igrac", 50.0, 75.5,35,70, Igrac.Stanje.AGRESIVNO, oruzja, odeca, magije);
        igrac.setZdravlje(35.2);
        Assertions.assertEquals(35.2, igrac.getZdravlje(), DELTA);
    }

    @Test
    public void getEnergija(){
        Igrac igrac = new Igrac("igrac", 50.0, 75.5,35,70, Igrac.Stanje.AGRESIVNO, oruzja, odeca, magije);
        Assertions.assertEquals(75.5, igrac.getEnergija(), DELTA);
    }

    @Test
    public void setEnergija(){
        Igrac igrac = new Igrac("igrac", 50.0, 75.5,35,70, Igrac.Stanje.AGRESIVNO, oruzja, odeca, magije);
        igrac.setEnergija(80.3);
        Assertions.assertEquals(80.3, igrac.getEnergija(), DELTA);
    }

    @Test
    public void getSnaga(){
        Igrac igrac = new Igrac("igrac", 50.0, 75.5,35,70, Igrac.Stanje.AGRESIVNO, oruzja, odeca, magije);
        Assertions.assertEquals(35, igrac.getSnaga());
    }

    @Test
    public void setSnaga(){
        Igrac igrac = new Igrac("igrac", 50.0, 75.5,35,70, Igrac.Stanje.AGRESIVNO, oruzja, odeca, magije);
        igrac.setSnaga(40);
        Assertions.assertEquals(40, igrac.getSnaga());
    }

    @Test
    public void getInteligencija(){
        Igrac igrac = new Igrac("igrac", 50.0, 75.5,35,70, Igrac.Stanje.AGRESIVNO, oruzja, odeca, magije);
        Assertions.assertEquals(70, igrac.getInteligencija());
    }

    @Test
    public void setInteligencija(){
        Igrac igrac = new Igrac("igrac", 50.0, 75.5,35,70, Igrac.Stanje.AGRESIVNO, oruzja, odeca, magije);
        igrac.setInteligencija(50);
        Assertions.assertEquals(50, igrac.getInteligencija());
    }

    @Test
    public void getStanje(){
        Igrac igrac = new Igrac("igrac", 50.0, 75.5,35,70, Igrac.Stanje.AGRESIVNO, oruzja, odeca, magije);
        Assertions.assertEquals(Igrac.Stanje.AGRESIVNO, igrac.getStanje());
    }

    @Test
    public void setStanje(){
        Igrac igrac = new Igrac("igrac", 50.0, 75.5,35,70, Igrac.Stanje.AGRESIVNO, oruzja, odeca, magije);
        igrac.setStanje(Igrac.Stanje.DEFANZIVNO);
        Assertions.assertEquals(Igrac.Stanje.DEFANZIVNO, igrac.getStanje());
    }

    @Test
    public void getOruzja(){
        oruzja = new ArrayList<>();
        oruzja.add(new Oruzje());
        Igrac igrac = new Igrac("igrac", 50.0, 75.5,35,70, Igrac.Stanje.AGRESIVNO, oruzja, odeca, magije);
        Assertions.assertEquals(1, igrac.getOruzja().size());
    }

    @Test
    public void setOruzja(){
        oruzja = new ArrayList<>();
        oruzja.add(new Oruzje());
        Igrac igrac = new Igrac("igrac", 50.0, 75.5,35,70, Igrac.Stanje.AGRESIVNO, oruzja, odeca, magije);
        ArrayList<Oruzje> novoOruzje = new ArrayList<>();
        novoOruzje.add(new Oruzje());
        novoOruzje.add(new Oruzje());
        igrac.setOruzja(novoOruzje);
        Assertions.assertEquals(2, igrac.getOruzja().size());
    }

    @Test
    public void getOdeca(){
        odeca = new ArrayList<>();
        odeca.add(new Odeca());
        Igrac igrac = new Igrac("igrac", 50.0, 75.5,35,70, Igrac.Stanje.AGRESIVNO, oruzja, odeca, magije);
        Assertions.assertEquals(1, igrac.getOdeca().size());
    }

    @Test
    public void setOdeca(){
        odeca = new ArrayList<>();
        odeca.add(new Odeca());
        Igrac igrac = new Igrac("igrac", 50.0, 75.5,35,70, Igrac.Stanje.AGRESIVNO, oruzja, odeca, magije);
        ArrayList<Odeca> novaOdeca = new ArrayList<>();
        novaOdeca.add(new Odeca());
        novaOdeca.add(new Odeca());
        igrac.setOdeca(novaOdeca);
        Assertions.assertEquals(2, igrac.getOdeca().size());
    }

    @Test
    public void getMagije(){
        magije = new ArrayList<>();
        magije.add(new Magija());
        Igrac igrac = new Igrac("igrac", 50.0, 75.5,35,70, Igrac.Stanje.AGRESIVNO, oruzja, odeca, magije);
        Assertions.assertEquals(1, igrac.getMagije().size());
    }

    @Test
    public void setMagije(){
        magije = new ArrayList<>();
        magije.add(new Magija());
        Igrac igrac = new Igrac("igrac", 50.0, 75.5,35,70, Igrac.Stanje.AGRESIVNO, oruzja, odeca, magije);
        ArrayList<Magija> noveMagije = new ArrayList<>();
        noveMagije.add(new Magija());
        noveMagije.add(new Magija());
        igrac.setMagije(noveMagije);
        Assertions.assertEquals(2, igrac.getMagije().size());
    }

    @Test
    public void toStringTest(){
        Igrac igrac = new Igrac("igrac", 50.0, 75.5,35,70, Igrac.Stanje.AGRESIVNO, oruzja, odeca, magije);
        String expected = "(igrac, 50.0/75.5, STR:35, INT:70)";
        Assertions.assertEquals(expected, igrac.toString());
    }

    private static Stream<Arguments> parametrizovanaMetodaNapadniIgraca(){
        return Stream.of(
                Arguments.of(19.9,29, Igrac.Stanje.DEFANZIVNO, 0.0, 19.9),
                Arguments.of(19.9,29, Igrac.Stanje.PASIVNO, 0.0, 19.9),
                Arguments.of(19.9,29, Igrac.Stanje.AGRESIVNO, 0.0, 19.9),

                Arguments.of(20.0,29, Igrac.Stanje.DEFANZIVNO, 0.0, 20.0),
                Arguments.of(20.0,29, Igrac.Stanje.PASIVNO, 0.0, 20.0),
                Arguments.of(20.0,29, Igrac.Stanje.AGRESIVNO, 0.0, 20.0),

                Arguments.of(20.1,29, Igrac.Stanje.DEFANZIVNO, 58.4, -0.9),
                Arguments.of(20.1,29, Igrac.Stanje.PASIVNO, 73.0, -0.9),
                Arguments.of(20.1,29, Igrac.Stanje.AGRESIVNO, 87.6, -0.9),

                Arguments.of(19.9,30, Igrac.Stanje.DEFANZIVNO, 0.0, 19.9),
                Arguments.of(19.9,30, Igrac.Stanje.PASIVNO, 0.0, 19.9),
                Arguments.of(19.9,30, Igrac.Stanje.AGRESIVNO, 0.0, 19.9),

                Arguments.of(20.0,30, Igrac.Stanje.DEFANZIVNO, 0.0, 20.0),
                Arguments.of(20.0,30, Igrac.Stanje.PASIVNO, 0.0, 20.0),
                Arguments.of(20.0,30, Igrac.Stanje.AGRESIVNO, 0.0, 20.0),

                Arguments.of(20.1,30, Igrac.Stanje.DEFANZIVNO, 72.0, -0.9),
                Arguments.of(20.1,30, Igrac.Stanje.PASIVNO, 90.0, -0.9),
                Arguments.of(20.1,30, Igrac.Stanje.AGRESIVNO, 108.0, -0.9),

                Arguments.of(19.9,31, Igrac.Stanje.DEFANZIVNO, 0.0, 19.9),
                Arguments.of(19.9,31, Igrac.Stanje.PASIVNO, 0.0, 19.9),
                Arguments.of(19.9,31, Igrac.Stanje.AGRESIVNO, 0.0, 19.9),

                Arguments.of(20.0,31, Igrac.Stanje.DEFANZIVNO, 0.0, 20.0),
                Arguments.of(20.0,31, Igrac.Stanje.PASIVNO, 0.0, 20.0),
                Arguments.of(20.0,31, Igrac.Stanje.AGRESIVNO, 0.0, 20.0),

                Arguments.of(20.1,31, Igrac.Stanje.DEFANZIVNO, 73.6, -0.9),
                Arguments.of(20.1,31, Igrac.Stanje.PASIVNO, 92.0, -0.9),
                Arguments.of(20.1,31, Igrac.Stanje.AGRESIVNO, 110.4, -0.9)
        );
    }

    private Oruzje oruzje = Mockito.mock(Oruzje.class);
    @ParameterizedTest
    @MethodSource("parametrizovanaMetodaNapadniIgraca")
    public void napadniIgraca_ShouldReturnExpectedResult(double energija, int snaga, Igrac.Stanje stanje, double expected, double novaEnergija){
        oruzja = new ArrayList<>();
        oruzja.add(oruzje);
        Mockito.when(oruzja.get(0).getSteta()).thenReturn(30.0);
        Mockito.when(oruzja.get(0).getPotrebnaSnaga()).thenReturn(30.0);
        Igrac igrac = new Igrac("igrac", 50.0, energija,snaga,70, stanje, oruzja, odeca, magije);
        Igrac meta = new Igrac("meta", 50.0, 75.5,35,70, Igrac.Stanje.DEFANZIVNO, oruzja, odeca, magije);
        Assertions.assertAll(
                ()->Assertions.assertEquals(expected,igrac.napadniIgraca(0, meta),DELTA),
                ()->Assertions.assertEquals(novaEnergija, igrac.getEnergija(), DELTA)
        );
        Mockito.verify(oruzje).getSteta();
        Mockito.verify(oruzje).getPotrebnaSnaga();
    }

    private static Stream<Arguments> parametrizovanaMetodaOdbraniSe(){
        return Stream.of(
                Arguments.of(29.9, 20.0, Igrac.Stanje.DEFANZIVNO, 5.0),
                Arguments.of(29.9, 20.0, Igrac.Stanje.PASIVNO, 7.5),
                Arguments.of(29.9, 20.0, Igrac.Stanje.AGRESIVNO, 15.0),

                Arguments.of(30.0, 20.0,Igrac.Stanje.DEFANZIVNO, 5.0),
                Arguments.of(30.0, 20.0,Igrac.Stanje.PASIVNO, 7.5),
                Arguments.of(30.0, 20.0,Igrac.Stanje.AGRESIVNO, 15.0),

                Arguments.of(30.1, 20.0,Igrac.Stanje.DEFANZIVNO, 10.0),
                Arguments.of(30.1, 20.0,Igrac.Stanje.PASIVNO, 16.67),
                Arguments.of(30.1, 20.0,Igrac.Stanje.AGRESIVNO, 31.25)
        );
    }

    private Oruzje oruzje1= Mockito.mock(Oruzje.class);
    private Oruzje oruzje2= Mockito.mock(Oruzje.class);
    private Odeca odelo1 = Mockito.mock(Odeca.class);
    private Odeca odelo2 = Mockito.mock(Odeca.class);

    @ParameterizedTest
    @MethodSource("parametrizovanaMetodaOdbraniSe")
    public void odbraniSe_ShouldReturnExpectedResult(double tezina1, double tezina2, Igrac.Stanje stanje, double expected ){
        oruzja = new ArrayList<>();
        oruzja.add(oruzje1);
        oruzja.add(oruzje2);
        Mockito.when(oruzja.get(0).getTezina()).thenReturn(6.0);
        Mockito.when(oruzja.get(1).getTezina()).thenReturn(4.0);
        odeca = new ArrayList<>();
        odeca.add(odelo1);
        Mockito.when(odeca.get(0).getTezina()).thenReturn(tezina1);
        Mockito.when(odeca.get(0).getOdbrambenaVrednost()).thenReturn(15.0);
        odeca.add(odelo2);
        Mockito.when(odeca.get(1).getTezina()).thenReturn(tezina2);
        Mockito.when(odeca.get(1).getOdbrambenaVrednost()).thenReturn(5.0);
        Igrac igrac = new Igrac("igrac", 50.0, 75.5,20,70, stanje, oruzja, odeca, magije);
        Assertions.assertEquals(expected,igrac.odbraniSe(30.0),DELTA);
        Mockito.verify(oruzje1).getTezina();
        Mockito.verify(oruzje2).getTezina();
        Mockito.verify(odelo1).getTezina();
        Mockito.verify(odelo1).getOdbrambenaVrednost();
        Mockito.verify(odelo2).getTezina();
        Mockito.verify(odelo2).getOdbrambenaVrednost();
    }

    @Test
    public void odbraniSe_ShouldThrowAnIllegalArgumentException_IfStetaIsMinus1(){
        Igrac igrac = new Igrac("igrac", 50.0, 75.5,35,70, Igrac.Stanje.DEFANZIVNO, oruzja, odeca, magije);
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            igrac.odbraniSe(-1);
        });
    }

    @Test
    public void odbraniSe_ShouldThrowAnIllegalArgumentException_IfStetaIs0(){
        oruzja = new ArrayList<>();
        oruzja.add(oruzje);
        Mockito.when(oruzja.get(0).getTezina()).thenReturn(10.0);
        odeca = new ArrayList<>();
        odeca.add(odelo1);
        Mockito.when(odeca.get(0).getTezina()).thenReturn(20.0);
        Mockito.when(odeca.get(0).getOdbrambenaVrednost()).thenReturn(20.0);
        Igrac igrac = new Igrac("igrac", 50.0, 75.5,35,70, Igrac.Stanje.DEFANZIVNO, oruzja, odeca, magije);
        Assertions.assertDoesNotThrow(()->{
            igrac.odbraniSe(0);
        });
    }
    @Test
    public void odbraniSe_ShouldThrowAnIllegalArgumentException_IfStetaIs1(){
        oruzja = new ArrayList<>();
        oruzja.add(oruzje);
        Mockito.when(oruzja.get(0).getTezina()).thenReturn(10.0);
        odeca = new ArrayList<>();
        odeca.add(odelo1);
        Mockito.when(odeca.get(0).getTezina()).thenReturn(20.0);
        Mockito.when(odeca.get(0).getOdbrambenaVrednost()).thenReturn(20.0);
        Igrac igrac = new Igrac("igrac", 50.0, 75.5,35,70, Igrac.Stanje.DEFANZIVNO, oruzja, odeca, magije);
        Assertions.assertDoesNotThrow(()->{
            igrac.odbraniSe(1);
        });
    }

    private static Stream<Arguments> parametrizovanaMetodaUpotrebiMagiju(){
        return Stream.of(
                Arguments.of(60.0,64.9,89,0.0, 0.0, 0.0),
                Arguments.of(90.0,64.9,89,807.0, 0.0, 16.0),

                Arguments.of(64.9,64.9,90,0.0, 0.0, 0.0),
                Arguments.of(65.0,64.9,90,870.0, 0.0, 0.0),
                Arguments.of(65.1,64.9,90,870.0, 0.0, 0.1),

                Arguments.of(64.9,64.9,91,0.0, 0.0, 0.0),
                Arguments.of(65.0,64.9,91,933.0, 0.0, 0.0),
                Arguments.of(65.1,64.9,91,933.0, 0.0, 0.1),

                Arguments.of(65.0,65.0,90,870.0, 0.0, 65.0),
                Arguments.of(65.0,65.1,90,870.0, 0.1, 65.0)
        );
    }

    private Magija magija = Mockito.mock(Magija.class);
    @ParameterizedTest
    @MethodSource("parametrizovanaMetodaUpotrebiMagiju")
    public void upotrebiMagiju_ShouldReturnExpectedResult(double zdravlje, double energija, int inteligencija, double expected, double novaEnergija, double novoZdravlje){
        magije = new ArrayList<>();
        magije.add(magija);
        Mockito.when(magije.get(0).getPotrebnaEnergija()).thenReturn(65.0);
        Mockito.when(magije.get(0).getPotrebnaInteligencija()).thenReturn(90.0);
        Mockito.when(magije.get(0).getSteta()).thenReturn(30.0);
        Igrac igrac = new Igrac("igrac", zdravlje, energija,50,inteligencija, Igrac.Stanje.DEFANZIVNO, oruzja, odeca, magije);
        Igrac meta = new Igrac("meta", 50.0, 75.5,35,70, Igrac.Stanje.DEFANZIVNO, oruzja, odeca, magije);
        Assertions.assertAll(
                () -> Assertions.assertEquals(expected, igrac.upotrebiMagiju(0, meta), DELTA),
                () -> Assertions.assertEquals(novaEnergija,igrac.getEnergija(),DELTA),
                () -> Assertions.assertEquals(novoZdravlje,igrac.getZdravlje(),DELTA)
        );

        Mockito.verify(magija, Mockito.atLeast(1)).getPotrebnaEnergija();
        Mockito.verify(magija, Mockito.atLeast(1)).getPotrebnaInteligencija();
        Mockito.verify(magija).getSteta();
    }

    private static Stream<Arguments> parametrizovanaMetodaOdmoriSe(){
        return Stream.of(
                Arguments.of(49.9, 50.0, 99.9),
                Arguments.of(50.0, 50.0, 100.0),
                Arguments.of(50.1, 49.9, 100.0),
                Arguments.of(74.9, 25.1, 100.0),
                Arguments.of(75.0, 25.0, 100.0),
                Arguments.of(75.1, 0.0, 75.1)
        );
    }

    @ParameterizedTest
    @MethodSource("parametrizovanaMetodaOdmoriSe")
    public void odmoriSe_ShouldReturnExpectedResult(double energija, double expected, double novaEnergija){
        Igrac igrac = new Igrac("igrac", 50.0, energija,35,70, Igrac.Stanje.DEFANZIVNO, oruzja, odeca, magije);
        Assertions.assertAll(
                ()->Assertions.assertEquals(expected, igrac.odmoriSe(), DELTA),
                ()->Assertions.assertEquals(novaEnergija, igrac.getEnergija(), DELTA)
        );

    }

}
