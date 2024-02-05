package com.mycompany.donem_projesi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;




public class PrimaryController {
    
    @FXML
    TextArea Elementler,Bilesikler,Deney_Arac,Deney_Ekipman;

    
    
    @FXML
    private void switchToEnvanteriDuzenle() throws IOException {
        App.setRoot("EnvanteriDuzenle");
    }
    
    @FXML
    private void switchToEnvantereEkle() throws IOException {
        App.setRoot("EnvantereEkle");
    }
    @FXML
    private void EnvanterOlustur()throws IOException {
        Envanter.Envanter.Envanteri_Sifirla();
        
    }
    @FXML
    private void EnvanteriGoruntule()throws IOException{
        BufferedReader bufferedReader1 = new BufferedReader(new FileReader(Envanter.Envanter.f_Elementler));
        BufferedReader bufferedReader2 = new BufferedReader(new FileReader(Envanter.Envanter.f_Bilesikler));
        BufferedReader bufferedReader3 = new BufferedReader(new FileReader(Envanter.Envanter.f_Deney_Araclari));
        BufferedReader bufferedReader4 = new BufferedReader(new FileReader(Envanter.Envanter.f_Deney_Ekipmanlari));
        String line;
        String line1 ="",line2 ="",line3 ="",line4 ="";

        
        
        while ((line = bufferedReader1.readLine()) != null) {
            line1+=line;
            line1+="\n";
        }
        while ((line = bufferedReader2.readLine()) != null) {
            line2+=line;
            line2+="\n";
        }        
        while ((line = bufferedReader3.readLine()) != null) {
            line3+=line;
            line3+="\n";
        }        
        while ((line = bufferedReader4.readLine()) != null) {
            line4+=line;
            line4+="\n";
        }        
        Elementler.setText(line1);
        Bilesikler.setText(line2);
        Deney_Arac.setText(line3);
        Deney_Ekipman.setText(line4);
        bufferedReader1.close();
        bufferedReader2.close();
        bufferedReader3.close();
        bufferedReader4.close();
        

    }


} 
