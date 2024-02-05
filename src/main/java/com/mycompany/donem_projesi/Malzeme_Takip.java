package com.mycompany.donem_projesi;

import java.io.IOException;

public class Malzeme_Takip {
public static void main(String[] args) throws IOException {
        System.out.println("**** Bilesikler TEST ****");
        Bilesikler b=new Bilesikler("Amonyak","NH3",50.5);
        b.setYaygın_Ad("Kirec Tası");
        b.setSistematik_Adi("Kalsiyum Karbonat");
        b.setBilesik_Formulu("CaCO3");
        b.setMiktar(-17);
        System.out.println(b.getYaygın_Ad());
        System.out.println(b.getSistematik_Adi());
        System.out.println(b.getBilesik_Formulu());
        System.out.println(b.getMiktar());
        b.Envantere_Ekle(b);
        b.Listele();
        b.Envanterden_Cıkar(b);
        b.R();
        
        System.out.println("\n\n\n**** Elementler TEST ****");
        Elementler e=new Elementler();
        e.setElement_Adi("Demir");
        e.setElement_Sembolu("Fe");
        e.setMiktar(19);
        System.out.println(e.getElement_Adi());
        System.out.println(e.getElement_Sembolu());
        System.out.println(e.getMiktar());
        e.Envantere_Ekle(e);
        e.Listele();
        e.Envanterden_Cıkar(e);
        e.R();
        
        System.out.println("\n\n\n**** Deney_Araclari TEST ****");
        Deney_Araclari da=new Deney_Araclari("Erlenmeyer","Cam", 500, 1);
        da.setAd("Beherglas");
        da.setCins("Cam");
        da.setAdet(-7);
        da.setHacim(200);
        System.out.println(da.getAd());
        System.out.println(da.getCins());
        System.out.println(da.getAdet());
        System.out.println(da.getHacim());
        da.Envantere_Ekle(da);
        da.Listele();
        da.Envanterden_Cıkar(da);
        da.R();
        
        System.out.println("\n\n\n**** Deney_Ekipmanlari TEST ****");
        Deney_Ekipmanlari de=new Deney_Ekipmanlari();
        de.setEkipman_adi("Eldiven");
        de.setAdet(17);
        System.out.println(de.getEkipman_adi());
        System.out.println(de.getAdet());
        de.Envantere_Ekle(de);
        de.Listele();
        de.Envanterden_Cıkar(de);
        de.R();
        
        System.out.println("\n\n\n**** Envanter TEST ****");
        b.Envantere_Ekle(b);
        e.Envantere_Ekle(e);
        de.Envantere_Ekle(de);
        da.Envantere_Ekle(da);
        Envanter.Envanter.Envanteri_Listele();
        Envanter.Envanter.Envanteri_Sifirla();
        Envanter.Envanter.Envanteri_Listele();
        Envanter.Envanter.Envanter_Olustur();
    }
}
