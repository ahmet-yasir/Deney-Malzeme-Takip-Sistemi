package Envanter;

import com.mycompany.donem_projesi.Bilesikler;
import com.mycompany.donem_projesi.Deney_Araclari;
import com.mycompany.donem_projesi.Deney_Ekipmanlari;
import com.mycompany.donem_projesi.Elementler;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Envanter {
    protected static ArrayList<Elementler> Element_takip=new ArrayList<>();
    protected static ArrayList<Bilesikler> Bilesik_takip=new ArrayList<>();
    protected static ArrayList<Deney_Araclari> Deney_Araclari_takip=new ArrayList<>();
    protected static ArrayList<Deney_Ekipmanlari> Deney_Ekipmanlari_takip=new ArrayList<>();
    public static File f_Elementler=new File("Elementler.txt");
    public static File f_Bilesikler=new File("Bilesikler.txt");
    public static File f_Deney_Araclari=new File("Deney_Araclari.txt");
    public static File f_Deney_Ekipmanlari=new File("Deney_Ekipmanlari.txt");
    
    public static void Envanter_Olustur() throws IOException{
        if(!Envanter.f_Elementler.exists()){
            Envanter.f_Elementler.createNewFile();
        }
        if(!Envanter.f_Bilesikler.exists()){
            Envanter.f_Bilesikler.createNewFile();
        }
        if(!Envanter.f_Deney_Araclari.exists()){
            Envanter.f_Deney_Araclari.createNewFile();
        }
        if(!Envanter.f_Deney_Ekipmanlari.exists()){
            Envanter.f_Deney_Ekipmanlari.createNewFile(); 
        }
       
    }

    public void Listele(){
        System.out.println("Envanter Listeleniyor...");
    }
    
    public static void Envanteri_Listele(){
        for (int i = 0; i < Element_takip.size();i++) { 		      
            System.out.println(Element_takip.get(i).getElement_Adi()+" ("+Element_takip.get(i).getElement_Sembolu()+") "+Element_takip.get(i).getMiktar()+" gr");
        }
        for (int i = 0; i < Bilesik_takip.size();i++) { 		      
            System.out.println(Bilesik_takip.get(i).getSistematik_Adi()+" ("+Bilesik_takip.get(i).getBilesik_Formulu()+") "+Bilesik_takip.get(i).getMiktar()+" ml/gr"); 		
        }
        for (int i = 0; i < Deney_Araclari_takip.size();i++) { 		      
            System.out.println(Deney_Araclari_takip.get(i).getAd()+" "+Deney_Araclari_takip.get(i).getCins()+" "+Deney_Araclari_takip.get(i).getHacim()+" ml "+Deney_Araclari_takip.get(i).getAdet()+" tane "); 		
        } 
        for (int i = 0; i < Deney_Ekipmanlari_takip.size();i++) { 		      
            System.out.println(Deney_Ekipmanlari_takip.get(i).getEkipman_adi()+" "+Deney_Ekipmanlari_takip.get(i).getAdet()+" tane "); 		
        }        
    }
    public static void Envanteri_Sifirla() throws IOException{
        Element_takip.clear();
        Bilesik_takip.clear();
        Deney_Araclari_takip.clear();
        Deney_Ekipmanlari_takip.clear();
        f_Elementler.delete();
        f_Bilesikler.delete();
        f_Deney_Araclari.delete();
        f_Deney_Ekipmanlari.delete();
        Envanter_Olustur();
        System.out.println("Envanter sifirlandi.");
    }
    public  static int Satir_Sayisi_Hesapla(File dosya) throws IOException { 
        int Satir_Sayisi = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(dosya));
            String satir = reader.readLine();
            while (satir!=null) {
                if(satir.length()>0){
                    Satir_Sayisi+=1;
              }
            satir = reader.readLine();                
            }    
        }
        catch(final IOException e){}
        return Satir_Sayisi; 
    }
    
            
}
