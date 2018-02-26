/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv01;

class Auto {
    public static int pocetAut = 0;
    
    public static Auto[] stoAut(){
        Auto [] sto;
        sto = new Auto[100];
        for (int i=0;i<100;i++){
            sto[i] = new Auto();
        }
        System.out.println(sto[1].barva);
        return sto;
    }
    
    private int pocetKol;
    public int silaMotoru;
    public int pocetSedadel;
    public String barva;
    
    public Auto(){
        pocetAut++;
        System.out.println("Konstruktor!");
        pocetKol = 4;
        pocetSedadel = 5;
        silaMotoru = 85;
        barva = "Stribrna";
    }
    
    public Auto(int sedadel){
        this();
        System.out.println("Konstruktor2!");

        pocetSedadel = sedadel;
   }
    
    private void setPocetKol(int pocetKol){
        this.pocetKol=pocetKol;
    }
    public int getPocetKol(){
        return pocetKol;
    }
    public void nastavKolaNaCtyri(){
        setPocetKol(4);
    }
    
    @Override
    public String toString(){
        return String.format("Auto barvy %s s %d koly", barva, pocetKol);
    }
}

class NakladniAuto extends Auto  {
    public int nosnost;
    
    @Override
    public String toString(){
        return String.format("Auto barvy %s s %d koly a nosnosti %d",barva,this.getPocetKol(),nosnost);
    }
}

/**
 *
 * @author jethro
 */
public class Cv01 {
   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        Auto b;
        
        b = new Auto(43);
        
        Auto [] c;
        c = Auto.stoAut();
        {
            Auto a;
            a = new Auto();
            a.nastavKolaNaCtyri();

        }
        
        NakladniAuto na;
        na = new NakladniAuto();
        
        
        //System.out.println(a.getPocetKol());
        System.out.println(b);
        System.out.println(na);
        System.out.println(b.pocetSedadel);
        System.out.println(Auto.pocetAut);
    }

 
}
