/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoigra;

import java.util.ArrayList;

/**
 *
 * @author Mladen
 */
public class Igrac {
    //atributi klase
    public static enum Stanje {DEFANZIVNO, AGRESIVNO, PASIVNO};
    private String naziv;
    private double zdravlje, energija;
    private int snaga, inteligencija;
    private Stanje stanje;
    
    private ArrayList<Oruzje> oruzja;
    private ArrayList<Odeca> odeca;
    private ArrayList<Magija> magije;

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getZdravlje() {
        return zdravlje;
    }

    public void setZdravlje(double zdravlje) {
        this.zdravlje = zdravlje;
    }

    public double getEnergija() {
        return energija;
    }

    public void setEnergija(double energija) {
        this.energija = energija;
    }

    public int getSnaga() {
        return snaga;
    }

    public void setSnaga(int snaga) {
        this.snaga = snaga;
    }

    public int getInteligencija() {
        return inteligencija;
    }

    public void setInteligencija(int inteligencija) {
        this.inteligencija = inteligencija;
    }

    public Stanje getStanje() {
        return stanje;
    }

    public void setStanje(Stanje stanje) {
        this.stanje = stanje;
    }

    public ArrayList<Oruzje> getOruzja() {
        return oruzja;
    }

    public void setOruzja(ArrayList<Oruzje> oruzja) {
        this.oruzja = oruzja;
    }

    public ArrayList<Odeca> getOdeca() {
        return odeca;
    }

    public void setOdeca(ArrayList<Odeca> odeca) {
        this.odeca = odeca;
    }

    public ArrayList<Magija> getMagije() {
        return magije;
    }

    public void setMagije(ArrayList<Magija> magije) {
        this.magije = magije;
    }

    public Igrac(String naziv, double zdravlje, double energija, int snaga, int inteligencija, Stanje stanje, ArrayList<Oruzje> oruzja, ArrayList<Odeca> odeca, ArrayList<Magija> magije) {
        this.naziv = naziv;
        this.zdravlje = zdravlje;
        this.energija = energija;
        this.snaga = snaga;
        this.inteligencija = inteligencija;
        this.stanje = stanje;
        this.oruzja = oruzja;
        this.odeca = odeca;
        this.magije = magije;
    }

    @Override
    public String toString() {
        return "(" + naziv + ", " + zdravlje + "/" + energija + ", STR:" + snaga + ", INT:" + inteligencija + ")";
    }
    
    public double napadniIgraca(int index, Igrac meta){
        
        Oruzje o = oruzja.get(index);
        double stetaOruzja = o.getSteta();
        
        if(energija < 20){
            stetaOruzja = 0;
        }else{
            energija = energija - 21;
        }
        if(snaga <= o.getPotrebnaSnaga()){
            stetaOruzja /=2;
        }
        
        double steta = stetaOruzja + (snaga * 2);
        
        switch(stanje){
            case DEFANZIVNO:
                steta *= 0.8;
                break;
            case PASIVNO: 
                steta *= 1;
            case AGRESIVNO:
                steta *=1.2;
                break;
        }
        
        
        return steta;
    }
    
    public double odbraniSe(double dolaznaSteta){
        
        double steta = 0;
        
        if(dolaznaSteta <= 0){
            throw new IllegalArgumentException();
        }
        double maxTezina = snaga * 3;
        
        double tezina = 0;
        double odbrambenaVrednost = 0;
            
        
        for(Odeca od : odeca){
            tezina += od.getTezina();
            odbrambenaVrednost += od.getOdbrambenaVrednost();
        }
        
        for(Oruzje oz : oruzja){
            tezina += oz.getTezina();
        }
        
        if(tezina <= maxTezina){
            
            double k = 0;
            
            switch(stanje){
                case AGRESIVNO:
                    k = 0.3;
                    break;
                case PASIVNO:
                    k = 0.2;
                    break;
                case DEFANZIVNO:
                    k = 0.1;
                    break;
                default:
                    throw new IllegalStateException();
            }
                       
            steta = dolaznaSteta / (odbrambenaVrednost * k);
        }else{
            
            double k = 0;
            
            switch(stanje){
                case DEFANZIVNO:
                    k = 0.25;
                    break;
                case PASIVNO:
                    k = 0.15;
                    break;
                case AGRESIVNO:
                    k = 0.08;
                    break;
                default:
                    throw new IllegalStateException();
            }
            
            
            steta = (dolaznaSteta * 1.5)/ (odbrambenaVrednost * 0.9 *  k);
            
        }
        
        return steta;
    }
    
    public double upotrebiMagiju(int magija, Igrac meta){
        
        Magija m = magije.get(magija);
        double steta = 0;
        double stetaMagije = m.getSteta();
        
        if(inteligencija < m.getPotrebnaInteligencija()){
            zdravlje = zdravlje * 0.9;
            energija = 0;
        }
        
        if(energija < m.getPotrebnaEnergija()){
            double razlika = m.getPotrebnaEnergija() - energija;
            if(zdravlje > razlika){
                zdravlje = zdravlje - razlika;
                energija = 0;
            }
            else{
                stetaMagije = 0;
            }
            
        }
        
        steta = stetaMagije * (inteligencija * 0.1 + (inteligencija - m.getPotrebnaInteligencija()) + (inteligencija - meta.getInteligencija()));
       
        return steta;
    }
    
    public double odmoriSe(){
        double oporavljenaEnergija = 0;
        
        if(energija < 75){
            if(energija + 500 > 100){
                oporavljenaEnergija = 100 - energija;
            }else{
                oporavljenaEnergija = 50;
            }
        }
        
        energija += oporavljenaEnergija;
        
        return oporavljenaEnergija;
    }
    
    
    
    
       
    
}
