package com.mycompany.donem_projesi;

import Envanter.Envanter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Deney_Araclari extends Envanter implements ITekrar_Kullanilabilirlik{
    private String Ad;
    private String Cins;
    private double Hacim;
    private int Adet;
    private static int index=0;


    public Deney_Araclari() {
        System.out.println("Deney araci kaydı olusturuldu.");
    }

    public Deney_Araclari(String Ad, String Cins, double Hacim, int Adet) {
        this.Ad = Ad;
        this.Cins = Cins;
        if(0>Hacim){
            System.out.println("Hacim negatif olamaz.Hacim bilgisini tekrar duzenleyin.");
        }
        else {
            this.Hacim = Hacim;
        }
        if(0>Adet){
            System.out.println("Adet negatif olamaz.Adet bilgisini tekrar duzenleyin.");
        }
        else {
            this.Adet = Adet;
        }
    }

    public String getAd() {
        return Ad;
    }

    public void setAd(String Ad) {
        this.Ad = Ad;
    }

    public String getCins() {
        return Cins;
    }

    public void setCins(String Cins) {
        this.Cins = Cins;
    }

    public double getHacim() {
        return Hacim;
    }

    public void setHacim(double Hacim) {
        if(0>Hacim){
            System.out.println("Hacim negatif olamaz.Hacim bilgisini tekrar duzenleyin.");
        }
        else {
            this.Hacim = Hacim;
        }
    }

    public int getAdet() {
        return Adet;
    }

    public void setAdet(int Adet) {
        if(0>Adet){
            System.out.println("Adet negatif olamaz.Adet bilgisini tekrar duzenleyin.");
        }
        else {
            this.Adet = Adet;
        }
    }

    public void Envanterden_Cıkar(Deney_Araclari da) {
        Deney_Araclari_takip.remove(da);
    }

    public void Envantere_Ekle(Deney_Araclari da) throws IOException {
        Deney_Araclari_takip.add(da);
        // Deney_Araclari.Index_Guncelle();
        String str=Deney_Araclari_takip.get(index).Ad+" "+Deney_Araclari_takip.get(index).Cins+" "+Deney_Araclari_takip.get(index).Hacim+" ml "+Deney_Araclari_takip.get(index).Adet+" tane ";
        FileWriter fileWriter = new FileWriter(Envanter.f_Deney_Araclari, true);
        BufferedWriter bWriter = new BufferedWriter(fileWriter);
        bWriter.write(str);        
        bWriter.write("\n");
        bWriter.close();
        Deney_Araclari.index++;
    }
    
    public static void Index_Guncelle() throws IOException {
        Deney_Araclari.index=1+Satir_Sayisi_Hesapla(f_Deney_Araclari);
    }
     
    @Override
    public void Listele() {
        for (int i = 0; i < Deney_Araclari_takip.size();i++) { 		      
            System.out.println(Deney_Araclari_takip.get(i).Ad+" "+Deney_Araclari_takip.get(i).Cins+" "+Deney_Araclari_takip.get(i).Hacim+" ml "+Deney_Araclari_takip.get(i).Adet+" tane "); 		
        }
    }

    @Override
    public void R() {
        System.out.println("Bu Malzeme birden fazla kez kullanilabilir.");
    }
}
