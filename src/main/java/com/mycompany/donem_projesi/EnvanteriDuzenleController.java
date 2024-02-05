
package com.mycompany.donem_projesi;

import Envanter.Envanter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class EnvanteriDuzenleController  {
    
    private static int Satir=0,index=0;
    
    @FXML
    Button Guncelle;
    @FXML
    TextField MalzemeBul,yeni_Sayi,MalzemeBilgi;
    @FXML
    Label Bilgi;
    
    @FXML
    private void switchToAnaMenu()throws IOException {
        App.setRoot("primary");
    }
    @FXML
    private void MalzemeBul()throws IOException {
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
            if(line.contains(MalzemeBul.getText())== true){
               Guncelle.setVisible(true);
               yeni_Sayi.setVisible(true);
               MalzemeBilgi.setVisible(true);
               MalzemeBilgi.setText(line);
               EnvanteriDuzenleController.Satir=sayac1;
               EnvanteriDuzenleController.index=1;
               Bulundu_mu=1;
            }            
            else{
                sayac1++;
            }
        }
        while ((line = bufferedReader2.readLine()) != null) {
            if(Bulundu_mu==1){
                break;
            }            
            if(line.contains(MalzemeBul.getText())== true){
                Guncelle.setVisible(true);
                yeni_Sayi.setVisible(true);
                MalzemeBilgi.setVisible(true);
                MalzemeBilgi.setText(line);
                EnvanteriDuzenleController.Satir=sayac2;
                EnvanteriDuzenleController.index=2;
                Bulundu_mu=1;
            }
            else{              
                sayac2++;
            }

        }        
        while ((line = bufferedReader3.readLine()) != null) {
            if(Bulundu_mu==1){
                break;
            }             
            if(line.contains(MalzemeBul.getText())== true){
                Guncelle.setVisible(true);
                yeni_Sayi.setVisible(true);
                MalzemeBilgi.setVisible(true);
                MalzemeBilgi.setText(line);
                EnvanteriDuzenleController.Satir=sayac3;
                EnvanteriDuzenleController.index=3;
                Bulundu_mu=1;
            }
            else{              
                sayac3++;
            }
          
        }        
        while ((line = bufferedReader4.readLine()) != null) {
            if(Bulundu_mu==1){
                break;
            }            
            if(line.contains(MalzemeBul.getText())== true){
                Guncelle.setVisible(true);
                yeni_Sayi.setVisible(true);
                MalzemeBilgi.setVisible(true);
                MalzemeBilgi.setText(line);
                EnvanteriDuzenleController.Satir=sayac4;
                EnvanteriDuzenleController.index=4;
                Bulundu_mu=1;
            }
            else{              
                sayac4++;
            }
            
        }    
        if (Bulundu_mu==0){
            Bilgi.setText("Malzeme bulunamadı.");
            Bilgi.setVisible(true);
            MalzemeBilgi.setText("");
            MalzemeBilgi.setVisible(false);
            Guncelle.setVisible(false);
            yeni_Sayi.setVisible(false);
        }
    }
    @FXML
    private void EnvanterdenSil()throws IOException {
        int sayac=0;        
        BufferedReader bufferedReader1 = new BufferedReader(new FileReader(Envanter.f_Elementler));
        BufferedReader bufferedReader2 = new BufferedReader(new FileReader(Envanter.f_Bilesikler));
        BufferedReader bufferedReader3 = new BufferedReader(new FileReader(Envanter.f_Deney_Araclari));
        BufferedReader bufferedReader4 = new BufferedReader(new FileReader(Envanter.f_Deney_Ekipmanlari));
        String str="";
        if(EnvanteriDuzenleController.index==1){
            String[] line=new String[Envanter.Satir_Sayisi_Hesapla(Envanter.f_Elementler)+1];            
            str="";
            while ((line[sayac] = bufferedReader1.readLine()) != null) {
                sayac++;
            }
            sayac=0;
            while (sayac<=Envanter.Satir_Sayisi_Hesapla(Envanter.f_Elementler)){
                if(sayac!=Satir){
                    if(line[sayac]!=null){
                        str+=line[sayac]+"\n";   
                    }
                    sayac++;
                }
                else {
                    sayac++;
                }            
            }
            FileWriter fileWriter = new FileWriter(Envanter.f_Elementler);
            BufferedWriter bWriter = new BufferedWriter(fileWriter);
            bWriter.write(str);
            //bWriter.write("\n");
            bWriter.close();
            Bilgi.setVisible(true);
            Bilgi.setText("Element başarıyla silindi!");
        }            
        else if(EnvanteriDuzenleController.index==2){
            String[] line2=new String[Envanter.Satir_Sayisi_Hesapla(Envanter.f_Bilesikler)+1];            
            sayac=0;
            str="";
            while ((line2[sayac] = bufferedReader2.readLine()) != null) {               
                sayac++;
            }
            sayac=0;
            while (sayac<=Envanter.Satir_Sayisi_Hesapla(Envanter.f_Bilesikler)){
                if(sayac!=Satir){
                    if(line2[sayac]!=null){
                        str+=line2[sayac]+"\n";   
                    }                     
                    sayac++;
                }
                else {
                    sayac++;
                }    
            }
            FileWriter fileWriter = new FileWriter(Envanter.f_Bilesikler);
            BufferedWriter bWriter = new BufferedWriter(fileWriter);
            bWriter.write(str);
            //bWriter.write("\n");
            bWriter.close();
                        Bilgi.setVisible(true);
            Bilgi.setText("Bileşik başarıyla silindi!");
        }
        else if(EnvanteriDuzenleController.index==3){
            String[] line3=new String[Envanter.Satir_Sayisi_Hesapla(Envanter.f_Deney_Araclari)+1];            
            sayac=0;
            str="";            
            while ((line3[sayac] = bufferedReader3.readLine()) != null) {
                sayac++;
            }
            sayac=0;
            while (sayac<Envanter.Satir_Sayisi_Hesapla(Envanter.f_Deney_Araclari)){
                if(sayac!=Satir){
                    if(line3[sayac]!=null){
                        str+=line3[sayac]+"\n";   
                    }                   
                    sayac++;
                }
                else {
                    sayac++;
                }    
            }
        FileWriter fileWriter = new FileWriter(Envanter.f_Deney_Araclari);
        BufferedWriter bWriter = new BufferedWriter(fileWriter);
        bWriter.write(str);
        //bWriter.write("\n");
        bWriter.close();
        Bilgi.setVisible(true);
        Bilgi.setText("Malzeme başarıyla silindi!");
    }
        else if(EnvanteriDuzenleController.index==4){
            String[] line4=new String[Envanter.Satir_Sayisi_Hesapla(Envanter.f_Deney_Ekipmanlari)+1];            
            sayac=0;
            str="";
            while ((line4[sayac] = bufferedReader4.readLine()) != null) {
                sayac++;
            }
            sayac=0;
            while (sayac<Envanter.Satir_Sayisi_Hesapla(Envanter.f_Deney_Ekipmanlari)){
                if(sayac!=Satir){
                   if(line4[sayac]!=null){
                        str+=line4[sayac]+"\n";   
                    }
                    sayac++;
                }
                else {                    
                    sayac++;
                }    
            }
            FileWriter fileWriter = new FileWriter(Envanter.f_Deney_Ekipmanlari);
            BufferedWriter bWriter = new BufferedWriter(fileWriter);
            bWriter.write(str);
            //bWriter.write("\n");
            bWriter.close();
            Bilgi.setVisible(true);
            Bilgi.setText("Ekipman başarıyla Eklendi!");
        }    
        bufferedReader1.close();
        bufferedReader2.close();
        bufferedReader3.close();
        bufferedReader4.close();               
    }
    
    @FXML
    private void Guncelle()throws IOException{
        int sayac=0;        
        BufferedReader bufferedReader1 = new BufferedReader(new FileReader(Envanter.f_Elementler));
        BufferedReader bufferedReader2 = new BufferedReader(new FileReader(Envanter.f_Bilesikler));
        BufferedReader bufferedReader3 = new BufferedReader(new FileReader(Envanter.f_Deney_Araclari));
        BufferedReader bufferedReader4 = new BufferedReader(new FileReader(Envanter.f_Deney_Ekipmanlari));
        String str="";
        if(EnvanteriDuzenleController.index==1){
            String[] line=new String[Envanter.Satir_Sayisi_Hesapla(Envanter.f_Elementler)+1];            
            str="";
            while ((line[sayac] = bufferedReader1.readLine()) != null) {
                sayac++;
            }
            sayac=0;
            while (sayac<=Envanter.Satir_Sayisi_Hesapla(Envanter.f_Elementler)){
                if(sayac!=Satir){
                    if(line[sayac]!=null){
                        str+=line[sayac]+"\n";   
                    }
                    sayac++;
                }
                else {
                    sayac++;
                }            
            }
            FileWriter fileWriter = new FileWriter(Envanter.f_Elementler);
            BufferedWriter bWriter = new BufferedWriter(fileWriter);
            bWriter.write(str);
            //bWriter.write("\n");
            bWriter.close();
            Elementler e=new Elementler();
            try {
                String[] arrSplit = line[Satir].split("\\s");
                e.setElement_Adi(arrSplit[0]);
                e.setElement_Sembolu(arrSplit[1]);
                if(Double.parseDouble(yeni_Sayi.getText())<0){
                    Bilgi.setText("Geçersiz miktar girişi!");
                    Bilgi.setVisible(true);                            
                }
                else{
                    e.setMiktar(Double.parseDouble(yeni_Sayi.getText()));
                    e.Envantere_Ekle(e);
                    Bilgi.setText("Element başarıyla güncellendi!");
                    Bilgi.setVisible(true);
                }
            }
            catch (NumberFormatException e1) {
                Bilgi.setText("Geçersiz miktar girişi!");
                Bilgi.setVisible(true);
            }
        }            
        else if(EnvanteriDuzenleController.index==2){
            String[] line2=new String[Envanter.Satir_Sayisi_Hesapla(Envanter.f_Bilesikler)+1];            
            sayac=0;
            str="";
            while ((line2[sayac] = bufferedReader2.readLine()) != null) {               
                sayac++;
            }
            sayac=0;
            while (sayac<=Envanter.Satir_Sayisi_Hesapla(Envanter.f_Bilesikler)){
                if(sayac!=Satir){
                    if(line2[sayac]!=null){
                        str+=line2[sayac]+"\n";   
                    }                     
                    sayac++;
                }
                else {
                    sayac++;
                }    
            }
            FileWriter fileWriter = new FileWriter(Envanter.f_Bilesikler);
            BufferedWriter bWriter = new BufferedWriter(fileWriter);
            bWriter.write(str);
            //bWriter.write("\n");
            bWriter.close();                    
            Bilesikler b=new Bilesikler();
            try {
                String[] arrSplit = line2[Satir].split("\\s");
                b.setYaygın_Ad(arrSplit[0]);
                b.setBilesik_Formulu(arrSplit[1]);
                if(Double.parseDouble(yeni_Sayi.getText())<0){
                    Bilgi.setText("Geçersiz miktar girişi!");
                    Bilgi.setVisible(true);                            
                }
                else{
                    b.setMiktar(Double.parseDouble(yeni_Sayi.getText()));
                    b.Envantere_Ekle(b);
                    Bilgi.setText("Bileşik başarıyla güncellendi!");
                    Bilgi.setVisible(true);
                }
            }
            catch (NumberFormatException e1) {
                Bilgi.setText("Geçersiz miktar girişi!");
                Bilgi.setVisible(true);
            }            
        }
        else if(EnvanteriDuzenleController.index==3){
            String[] line3=new String[Envanter.Satir_Sayisi_Hesapla(Envanter.f_Deney_Araclari)+1];            
            sayac=0;
            str="";            
            while ((line3[sayac] = bufferedReader3.readLine()) != null) {
                sayac++;
            }
            sayac=0;
            while (sayac<Envanter.Satir_Sayisi_Hesapla(Envanter.f_Deney_Araclari)){
                if(sayac!=Satir){
                    if(line3[sayac]!=null){
                        str+=line3[sayac]+"\n";   
                    }                   
                    sayac++;
                }
                else {
                    sayac++;
                }    
            }
        FileWriter fileWriter = new FileWriter(Envanter.f_Deney_Araclari);
        BufferedWriter bWriter = new BufferedWriter(fileWriter);
        bWriter.write(str);
        //bWriter.write("\n");
        bWriter.close();
        Deney_Araclari da=new Deney_Araclari();
        try {
            String[] arrSplit = line3[Satir].split("\\s");
            da.setAd(arrSplit[0]);
            da.setCins(arrSplit[1]);
            da.setHacim(Double.parseDouble(arrSplit[2]));
            if(Double.parseDouble(yeni_Sayi.getText())<0){
                Bilgi.setText("Geçersiz adet girişi!");
                Bilgi.setVisible(true);                            
            }
            else{
                da.setAdet(Integer.parseInt(yeni_Sayi.getText()));
                da.Envantere_Ekle(da);
                Bilgi.setText("Malzeme başarıyla güncellendi!");
                Bilgi.setVisible(true);
            }
        }
        catch (NumberFormatException e1) {
            Bilgi.setText("Geçersiz adet girişi!");
            Bilgi.setVisible(true);
        }            
        }
        else if(EnvanteriDuzenleController.index==4){
            String[] line4=new String[Envanter.Satir_Sayisi_Hesapla(Envanter.f_Deney_Ekipmanlari)+1];            
            sayac=0;
            str="";
            while ((line4[sayac] = bufferedReader4.readLine()) != null) {
                sayac++;
            }
            sayac=0;
            while (sayac<Envanter.Satir_Sayisi_Hesapla(Envanter.f_Deney_Ekipmanlari)){
                if(sayac!=Satir){
                   if(line4[sayac]!=null){
                        str+=line4[sayac]+"\n";   
                    }
                    sayac++;
                }
                else {                    
                    sayac++;
                }    
            }
            FileWriter fileWriter = new FileWriter(Envanter.f_Deney_Ekipmanlari);
            BufferedWriter bWriter = new BufferedWriter(fileWriter);
            bWriter.write(str);
            //bWriter.write("\n");
            bWriter.close();
            Deney_Ekipmanlari de=new Deney_Ekipmanlari();
            try {
                String[] arrSplit = line4[Satir].split("\\s");
                de.setEkipman_adi(arrSplit[0]);
                if(Double.parseDouble(yeni_Sayi.getText())<0){
                    Bilgi.setText("Geçersiz adet girişi!");
                    Bilgi.setVisible(true);                            
                }
                else{
                    de.setAdet(Integer.parseInt(yeni_Sayi.getText()));
                    de.Envantere_Ekle(de);
                    Bilgi.setText("Ekipman başarıyla güncellendi!");
                    Bilgi.setVisible(true);
                }
            }
            catch (NumberFormatException e1) {
                Bilgi.setText("Geçersiz adet girişi!");
                Bilgi.setVisible(true);
            }

        }    
        bufferedReader1.close();
        bufferedReader2.close();
        bufferedReader3.close();
        bufferedReader4.close();               
    }
  }
    
        
        
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

