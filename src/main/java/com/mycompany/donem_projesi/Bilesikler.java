package com.mycompany.donem_projesi;

import Envanter.Envanter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;



public class Bilesikler extends Envanter implements ITekrar_Kullanilabilirlik{
    private String Yaygın_Ad;
    private String Sistematik_Adi;
    private String Bilesik_Formulu;
    private double Miktar;
    private static int index=0;
    

    public Bilesikler() {
        System.out.println("Bilesik kaydı olusturuldu.");
    }

    public Bilesikler(String Yaygın_Ad, String Bilesik_Formulu, double Miktar) {
        this.Yaygın_Ad = Yaygın_Ad;
        this.Bilesik_Formulu = Bilesik_Formulu;
        if(0>Miktar){
            System.out.println("Miktar negatif olamaz.Element miktarini tekrar düzenleyin.");
        }
        else {
            this.Miktar = Miktar;
        }
    }

    public Bilesikler(String Yaygın_Ad, String Sistematik_Adi, String Bilesik_Formulu, double Miktar) {
        this.Yaygın_Ad = Yaygın_Ad;
        this.Sistematik_Adi = Sistematik_Adi;
        this.Bilesik_Formulu = Bilesik_Formulu;
        if(0>Miktar){
            System.out.println("Miktar negatif olamaz.Element miktarini tekrar düzenleyin.");
        }
        else {
            this.Miktar = Miktar;
        }
    }
    
    public String getYaygın_Ad() {
        return Yaygın_Ad;
    }

    public void setYaygın_Ad(String Yaygın_Ad) {
        this.Yaygın_Ad = Yaygın_Ad;
    }

    public String getSistematik_Adi() {
        return Sistematik_Adi;
    }

    public void setSistematik_Adi(String Sistematik_Adi) {
        this.Sistematik_Adi = Sistematik_Adi;
    }

    public String getBilesik_Formulu() {
        return Bilesik_Formulu;
    }

    public void setBilesik_Formulu(String Bilesik_Formulu) {
        this.Bilesik_Formulu = Bilesik_Formulu;
    }

    public double getMiktar() {
        return Miktar;
    }

    public void setMiktar(double Miktar) {
        if(0>Miktar){
            System.out.println("Miktar negatif olamaz.Element miktarini tekrar düzenleyin.");
        }
        else {
            this.Miktar = Miktar;
        }
    }

    public void Envanterden_Cıkar(Bilesikler b) {
        Bilesik_takip.remove(b);
    }

    public void Envantere_Ekle(Bilesikler b) throws IOException {
        Bilesik_takip.add(b);
        // Bilesikler.Index_Guncelle();
        String str=Bilesik_takip.get(index).Yaygın_Ad+" "+Bilesik_takip.get(index).Bilesik_Formulu+" "+Bilesik_takip.get(index).Miktar+" ml-gr";
        FileWriter fileWriter = new FileWriter(Envanter.f_Bilesikler, true);
        BufferedWriter bWriter = new BufferedWriter(fileWriter);
        bWriter.write(str);        
        bWriter.write("\n");
        bWriter.close();
        Bilesikler.index++;
    }
    
    public static void Index_Guncelle() throws IOException {
        Bilesikler.index=1+Satir_Sayisi_Hesapla(f_Bilesikler);
    }
    
    @Override
    public void Listele() {
        for (int i = 0; i < Bilesik_takip.size();i++) { 		      
            System.out.println(Bilesik_takip.get(i).Sistematik_Adi+" ("+Bilesik_takip.get(i).Bilesik_Formulu+") "+Bilesik_takip.get(i).Miktar+" ml/gr"); 		
        }
    }

    @Override
    public void R() {
        System.out.println("Bu Malzeme sadece bir kez kullanilabilir.");
    }





    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
