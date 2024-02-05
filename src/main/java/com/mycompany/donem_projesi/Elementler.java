package com.mycompany.donem_projesi;

import Envanter.Envanter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;



public class Elementler extends Envanter implements ITekrar_Kullanilabilirlik {
    private String Element_Adi;
    private String Element_Sembolu;
    private double Miktar;
    private static int index=0;
    

    public Elementler() {
        System.out.println("Element kaydı olusturuldu.");
    }

    public Elementler(String Element_Adi, String Element_Sembolu, int Miktar) {
        this.Element_Adi = Element_Adi;
        this.Element_Sembolu = Element_Sembolu;
        if(0>Miktar){
            System.out.println("Miktar negatif olamaz.Element miktarini tekrar düzenleyin.");
        }
        else {
            this.Miktar = Miktar;
        }
    }

    public String getElement_Adi() {
        return Element_Adi;
    }

    public void setElement_Adi(String Element_Adi) {
        this.Element_Adi = Element_Adi;
    }

    public String getElement_Sembolu() {
        return Element_Sembolu;
    }

    public void setElement_Sembolu(String Element_Sembolu) {
        this.Element_Sembolu = Element_Sembolu;
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

    public void Envanterden_Cıkar(Elementler e) {
        Element_takip.remove(e);
    }

    public void Envantere_Ekle(Elementler e) throws IOException {
        Element_takip.add(e);
        //Elementler.Index_Guncelle();
        String str = Element_takip.get(Elementler.index).Element_Adi+" "+Element_takip.get(Elementler.index).Element_Sembolu+" "+Element_takip.get(Elementler.index).Miktar+" gr-ml";
        FileWriter fileWriter = new FileWriter(Envanter.f_Elementler, true);
        BufferedWriter bWriter = new BufferedWriter(fileWriter);
        bWriter.write(str);
        bWriter.write("\n");
        bWriter.close();
        Elementler.index++;
    }
    
    public static void Index_Guncelle() throws IOException {
        Elementler.index=1+Satir_Sayisi_Hesapla(f_Elementler);
    }    

    @Override
    public void Listele() {
        for (int i = 0; i < Element_takip.size();i++) { 		      
            System.out.println(Element_takip.get(i).Element_Adi+" ("+Element_takip.get(i).Element_Sembolu+") "+Element_takip.get(i).Miktar+" gr");
        }
    }

    @Override
    public void R() {
        System.out.println("Bu Malzeme sadece bir kez kullanilabilir.");
    }
    
}
