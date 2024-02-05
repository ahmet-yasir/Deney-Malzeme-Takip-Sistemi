package com.mycompany.donem_projesi;

import Envanter.Envanter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EnvantereEkleController implements Initializable{
    @FXML
    ComboBox cBox;
    private static int d_numara;
    @FXML
    TextField ElementAdi,ElementSembolu,ElementMiktari;
    @FXML
    TextField BilesikYayginAd,BilesikSistematikAd,BilesikFormul,BilesikMiktar;
    @FXML
    TextField MalzemeAdi,MalzemeCinsi,MalzemeHacmi,MalzemeAdeti;
    @FXML
    TextField EkipmanAdi,EkipmanAdeti;
    @FXML
    Label Bilgi,e_ad,e_sembol,e_miktar,b_ad,b_sad,b_miktar,b_formul,m_ad,m_adet,m_cins,m_hacim,ek_ad,ek_adet;
    @FXML
    Button ElementEkle,BilesikEkle,MalzemeEkle,EkipmanEkle;
    @FXML
    private void switchToAnaMenu()throws IOException {
        App.setRoot("primary");
    }
    @FXML
    private void ElementEkle()throws IOException, Exception{
        Elementler e1 =new Elementler();
        if(ElementAdi.getText()==""||ElementSembolu.getText()==""||ElementMiktari.getText()==""){
            Bilgi.setVisible(true);
            Bilgi.setText("* isaretli alanlar bos olamaz! ");
        }
        else{
            e1.setElement_Adi(ElementAdi.getText());
            e1.setElement_Sembolu(ElementSembolu.getText());
            try {
                if(Double.parseDouble(ElementMiktari.getText())<0){
                    Bilgi.setVisible(true);
                    Bilgi.setText("Geçersiz Miktar Girişi!");
                }
                else if(Malzeme_Kontrol(ElementAdi.getText())==true && d_numara==1){
                    Bilgi.setVisible(true);
                    Bilgi.setText("Element envanterde zaten var!");                    
                }
                else {
                    e1.setMiktar(Double.parseDouble(ElementMiktari.getText()));
                    e1.Envantere_Ekle(e1);
                    Bilgi.setVisible(true);
                    Bilgi.setText("Element başariyla eklendi.");
                    ElementAdi.clear();
                    ElementMiktari.clear();
                    ElementSembolu.clear();
                }
            }
            catch (NumberFormatException e) {
                Bilgi.setVisible(true);
                Bilgi.setText("Geçersiz Miktar Girişi!");
            }            
        }     
    }
    @FXML
    private void BilesikEkle()throws IOException, Exception{
        Bilesikler b1 =new Bilesikler();
        if(BilesikYayginAd.getText()==""||BilesikFormul.getText()==""||BilesikMiktar.getText()==""){
            Bilgi.setVisible(true);
            Bilgi.setText("* isaretli alanlar bos olamaz! ");
        }
        else{
            b1.setYaygın_Ad(BilesikYayginAd.getText());
            b1.setSistematik_Adi(BilesikSistematikAd.getText());
            b1.setBilesik_Formulu(BilesikFormul.getText());
            try {
                if(Double.parseDouble(BilesikMiktar.getText())<0){
                    Bilgi.setVisible(true);
                    Bilgi.setText("Geçersiz Miktar Girişi!");
                }
                else if(Malzeme_Kontrol(BilesikYayginAd.getText())==true && d_numara==2){
                    Bilgi.setVisible(true);
                    Bilgi.setText("Bileşik envanterde zaten var!");                    
                }                
                else {
                    b1.setMiktar(Double.parseDouble(BilesikMiktar.getText()));
                    b1.Envantere_Ekle(b1);
                    Bilgi.setVisible(true);
                    Bilgi.setText("Bilesik başariyla eklendi.");
                    BilesikFormul.clear();
                    BilesikMiktar.clear();
                    BilesikSistematikAd.clear();
                    BilesikYayginAd.clear();
                }
            }
            catch (NumberFormatException e) {
                Bilgi.setVisible(true);
                Bilgi.setText("Geçersiz Miktar Girişi!");
            }            
        }     
    }
    @FXML
    private void DeneyAraciEkle()throws IOException, Exception{
        Deney_Araclari da=new Deney_Araclari();
        if(MalzemeAdeti.getText()==""||MalzemeAdi.getText()==""||MalzemeCinsi.getText()==""||MalzemeHacmi.getText()==""){
            Bilgi.setVisible(true);
            Bilgi.setText("* isaretli alanlar bos olamaz! ");
        }
        else{
            da.setAd(MalzemeAdi.getText());
            da.setCins(MalzemeCinsi.getText());
            try {
                if(Double.parseDouble(MalzemeAdeti.getText())<0 || Double.parseDouble(MalzemeHacmi.getText())<0){
                    Bilgi.setVisible(true);
                    Bilgi.setText("Geçersiz adet veya hacim Girişi!");
                }
                else if(Malzeme_Kontrol(MalzemeAdi.getText())==true && d_numara==3){
                    Bilgi.setVisible(true);
                    Bilgi.setText("Malzeme envanterde zaten var!");                    
                }                
                else {
                    da.setAdet(Integer.parseInt(MalzemeAdeti.getText()));
                    da.setHacim(Double.parseDouble(MalzemeHacmi.getText()));
                    da.Envantere_Ekle(da);
                    Bilgi.setVisible(true);
                    Bilgi.setText("Malzeme başariyla eklendi.");
                    MalzemeAdeti.clear();
                    MalzemeAdi.clear();
                    MalzemeCinsi.clear();
                    MalzemeHacmi.clear();
                }
            }
            catch (NumberFormatException e) {
                Bilgi.setVisible(true);
                Bilgi.setText("Geçersiz adet veya hacim girişi!");
            }            
        }     
    }
    @FXML
    private void DeneyEkipmanEkle()throws IOException, Exception{
        Deney_Ekipmanlari de=new Deney_Ekipmanlari();
        if(EkipmanAdi.getText()==""||EkipmanAdeti.getText()==""){
            Bilgi.setVisible(true);
            Bilgi.setText("* isaretli alanlar bos olamaz! ");
        }
        else{
            de.setEkipman_adi(EkipmanAdi.getText());
            try {
                if(Integer.parseInt(EkipmanAdeti.getText())<0){
                    Bilgi.setVisible(true);
                    Bilgi.setText("Geçersiz adet girişi!");
                }
                else if(Malzeme_Kontrol(EkipmanAdi.getText())==true && d_numara==4){
                    Bilgi.setVisible(true);
                    Bilgi.setText("Ekipman envanterde zaten var!");                    
                }
                else {
                    de.setAdet(Integer.parseInt(EkipmanAdeti.getText()));
                    de.Envantere_Ekle(de);
                    Bilgi.setVisible(true);
                    Bilgi.setText("Ekipman başariyla eklendi.");
                    EkipmanAdeti.clear();
                    EkipmanAdi.clear();
                }
            }
            catch (NumberFormatException e) {
                Bilgi.setVisible(true);
                Bilgi.setText("Geçersiz adet girişi!");
            }            
        }     
    }
    private Boolean Malzeme_Kontrol(String s)throws IOException {
        int sayac1=0,sayac2=0,sayac3=0,sayac4=0;
        int Bulundu_mu=0;
        String line;
        BufferedReader bufferedReader1 = new BufferedReader(new FileReader(Envanter.f_Elementler));
        BufferedReader bufferedReader2 = new BufferedReader(new FileReader(Envanter.f_Bilesikler));
        BufferedReader bufferedReader3 = new BufferedReader(new FileReader(Envanter.f_Deney_Araclari));
        BufferedReader bufferedReader4 = new BufferedReader(new FileReader(Envanter.f_Deney_Ekipmanlari));

    
        while ((line = bufferedReader1.readLine()) != null) {            
            if(Bulundu_mu==1){
                break;
            } 
            if(line.contains(s)== true){
               Bulundu_mu=1;
               d_numara=1;
            }            
            else{
                sayac1++;
            }
        }
        while ((line = bufferedReader2.readLine()) != null) {
            if(Bulundu_mu==1){
                break;
            }            
            if(line.contains(s)== true){
                Bulundu_mu=1;;
                d_numara=2;
            }
            else{              
                sayac2++;
            }
        }        
        while ((line = bufferedReader3.readLine()) != null) {
            if(Bulundu_mu==1){
                break;
            }             
            if(line.contains(s)== true){
                Bulundu_mu=1;
                d_numara=3;
            }
            else{              
                sayac3++;
            }
          
        }        
        while ((line = bufferedReader4.readLine()) != null) {
            if(Bulundu_mu==1){
                break;
            }            
            if(line.contains(s)== true){
                Bulundu_mu=1;
                d_numara=4;
            }
            else{              
                sayac4++;
            }            
        }    
        return Bulundu_mu==1;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {      
        cBox.getItems().add("Element Ekle");
        cBox.getItems().add("Bileşik Ekle");
        cBox.getItems().add("Malzeme Ekle");
        cBox.getItems().add("Ekipman Ekle");
    }
    @FXML
    private void MenuKontrol()throws IOException{
        e_ad.setVisible(false);
        e_sembol.setVisible(false);
        e_miktar.setVisible(false);
        ElementAdi.setVisible(false);
        ElementMiktari.setVisible(false);
        ElementSembolu.setVisible(false);
        ElementEkle.setVisible(false);
        b_ad.setVisible(false);
        b_formul.setVisible(false);
        b_miktar.setVisible(false);
        b_sad.setVisible(false);
        BilesikEkle.setVisible(false);
        BilesikFormul.setVisible(false);
        BilesikYayginAd.setVisible(false);
        BilesikSistematikAd.setVisible(false);
        BilesikMiktar.setVisible(false);
        m_ad.setVisible(false);
        m_adet.setVisible(false);
        m_cins.setVisible(false);
        m_hacim.setVisible(false);
        MalzemeEkle.setVisible(false);
        MalzemeAdeti.setVisible(false);
        MalzemeCinsi.setVisible(false);
        MalzemeAdi.setVisible(false);
        MalzemeHacmi.setVisible(false);
        ek_ad.setVisible(false);
        ek_adet.setVisible(false);
        EkipmanEkle.setVisible(false);
        EkipmanAdi.setVisible(false);
        EkipmanAdeti.setVisible(false); 
        
        if(Objects.equals(cBox.getValue(), "Element Ekle")==true){
           e_ad.setVisible(true);
           e_sembol.setVisible(true);
           e_miktar.setVisible(true);
           ElementAdi.setVisible(true);
           ElementMiktari.setVisible(true);
           ElementSembolu.setVisible(true);
           ElementEkle.setVisible(true);
        }
        else if(Objects.equals(cBox.getValue(), "Bileşik Ekle")==true){
            b_ad.setVisible(true);
            b_formul.setVisible(true);
            b_miktar.setVisible(true);
            b_sad.setVisible(true);
            BilesikEkle.setVisible(true);
            BilesikFormul.setVisible(true);
            BilesikYayginAd.setVisible(true);
            BilesikSistematikAd.setVisible(true);
            BilesikMiktar.setVisible(true);
        }
        else if(Objects.equals(cBox.getValue(), "Malzeme Ekle")==true){
           m_ad.setVisible(true);
           m_adet.setVisible(true);
           m_cins.setVisible(true);
           m_hacim.setVisible(true);
           MalzemeEkle.setVisible(true);
           MalzemeAdeti.setVisible(true);
           MalzemeCinsi.setVisible(true);
           MalzemeAdi.setVisible(true);
           MalzemeHacmi.setVisible(true);        
        }
        else if(Objects.equals(cBox.getValue(), "Ekipman Ekle")==true){
            ek_ad.setVisible(true);
            ek_adet.setVisible(true);
            EkipmanEkle.setVisible(true);
            EkipmanAdi.setVisible(true);
            EkipmanAdeti.setVisible(true);   
        }
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}