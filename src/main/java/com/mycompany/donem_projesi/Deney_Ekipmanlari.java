package com.mycompany.donem_projesi;

import Envanter.Envanter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;



public class Deney_Ekipmanlari extends Envanter implements ITekrar_Kullanilabilirlik {
    private String Ekipman_adi;
    private int Adet;
    private static int index=0;
    
    
    public Deney_Ekipmanlari() {
        System.out.println("Ekipman kaydi olusturuluyor.");
    }

    public Deney_Ekipmanlari(String Ekipman_adi, int Adet) {
        this.Ekipman_adi = Ekipman_adi;
        if(0>Adet){
            System.out.println("Adet negatif olamaz.Adet bilgisini tekrar duzenleyin.");
        }
        else {
            this.Adet = Adet;
        }
    }

    public String getEkipman_adi() {
        return Ekipman_adi;
    }

    public void setEkipman_adi(String Ekipman_adi) {
        this.Ekipman_adi = Ekipman_adi;
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

    public void Envanterden_Cıkar(Deney_Ekipmanlari de) {
        Deney_Ekipmanlari_takip.remove(de);
    }


    public void Envantere_Ekle(Deney_Ekipmanlari de) throws IOException {
        Deney_Ekipmanlari_takip.add(de);
        // Deney_Ekipmanlari.Index_Guncelle();
        String str=Deney_Ekipmanlari_takip.get(index).Ekipman_adi+" "+Deney_Ekipmanlari_takip.get(index).Adet+" tane ";
        FileWriter fileWriter = new FileWriter(Envanter.f_Deney_Ekipmanlari, true);
        BufferedWriter bWriter = new BufferedWriter(fileWriter);
        bWriter.write(str);
        bWriter.write("\n");
        bWriter.close();
        Deney_Ekipmanlari.index++;
    }
    public static void Index_Guncelle() throws IOException {
        Deney_Ekipmanlari.index=1+Satir_Sayisi_Hesapla(f_Deney_Ekipmanlari);
    }

    @Override
    public void Listele() {
        for (int i = 0; i < Deney_Ekipmanlari_takip.size();i++) { 		      
            System.out.println(Deney_Ekipmanlari_takip.get(i).Ekipman_adi+" "+Deney_Ekipmanlari_takip.get(i).Adet+" tane "); 		
        }
    }
    
        @Override
    public void R() {
        System.out.println("Bu Malzeme birden fazla kez kullanilabilir.");
    }    
}
