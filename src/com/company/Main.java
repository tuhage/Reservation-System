package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public final static Kategori kok = new Kategori();
    public final static Kullanici kullanici_kok=new Kullanici();
    public static Kategori kategori_gosterge;

    public static void main(String[] args) throws IOException {

        File file = new File("/home/tuhage/proje4/rezervasyon.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st=br.readLine();
        while ((st = br.readLine()) != null)
            kategorileri_al(st);

         br.close();
//         br = new BufferedReader(new FileReader(file));
//         st=br.readLine();
//        while ((st = br.readLine()) != null)
//            kullanicilari_al(st);

        Kullanici k1=new Kullanici();
        Kullanici k2=new Kullanici();
        Kullanici k3=new Kullanici();


    }

    public static void kullanicilari_al(String satir){

        int k=0;
        String temp="";
        String isim="";
        String kategori="";
        for (int i = 0; i <satir.length() ; i++) {

            if(satir.charAt(i)==','){

                if(k==0){
                    isim=temp.trim();
                    temp="";
                }
                temp="";
                k++;
                continue;
            }

            temp+=satir.charAt(i);


        }
        kategori=temp.trim();

        while (kategori.contains(":")){
            kategori=kategori.substring(kategori.indexOf(":")+1);
        }

        kullaniciagac(isim,kategori);

    }



    public static void kategorileri_al(String satir){

        int k=0;
        int kategori=0;
        String temp="";
        for (int i = 0; i <satir.length() ; i++) {

            if(satir.charAt(i)==','){

                    temp="";
                    k++;
                continue;
            }

            temp+=satir.charAt(i);


        }

        kategoriagac(temp.trim());

    }

    public static void kullaniciagac(String kullanici,String kategori){

        System.out.println(kullanici+"  "+kategori);


    }
    public static Kullanici kullanicivarmi(String kullanici,Kullanici kok){


        Kullanici temp=null;
        if(kok.kullanici_adi.equals(kullanici)) return kok;


        if(kok.sag!=null){
        if(kok.sag.kullanici_adi.equals(kullanici))return kok.sag;
            temp=kullanicivarmi(kullanici,kok.sag);
            if(temp!=null)return temp;

        }
        if(kok.sol!=null){
            if(kok.sol.kullanici_adi.equals(kullanici))return kok.sol;
            temp=kullanicivarmi(kullanici,kok.sol);
            if(temp!=null)return temp;

        }

        return null;
    }

    public static void kategoriagac(String kategori){
        ArrayList<String> kategoriler=new ArrayList<String>();
        String temp="";
        Kategori aranacak_kok=kok;
        Kategori aranan_kok;
        String kategori_yolu="";
        for (int i = 0; i <kategori.length() ; i++) {
            if(kategori.charAt(i)==':'){
                kategoriler.add(temp);
                temp="";
                continue;
            }
            temp+=kategori.charAt(i);
        }
        kategoriler.add(temp);

        for (int i = 0; i <kategoriler.size() ; i++) {
            aranan_kok=kategorivarmi(kategoriler.get(i),aranacak_kok);
            if(aranan_kok==null){
                aranan_kok=new Kategori();
                kategori_yolu+=kategoriler.get(i);
                aranan_kok.kategori_ismi=kategoriler.get(i);
                aranan_kok.ust=aranacak_kok;
                aranan_kok.ust.alt.add(aranan_kok);
                if(i==0)
                    aranan_kok.kategori_yolu=aranan_kok.kategori_ismi;
                else
                    aranan_kok.kategori_yolu=aranan_kok.ust.kategori_yolu+":"+aranan_kok.kategori_ismi;
                aranan_kok.ust.alt_kategori_sayisi+=1;
                aranan_kok.rezervasyon_sayisi+=1;
                aranan_kok.derinlik=i+1;
                aranacak_kok=aranan_kok;

            }
            else{


                aranacak_kok=aranan_kok;
                aranan_kok.ust.alt_kategori_sayisi+=1;
                aranan_kok.rezervasyon_sayisi+=1;


            }



        }
        kok.rezervasyon_sayisi++;

    }
    public static Kategori kategorivarmi(String kategori,Kategori temp){
        Kategori temp2;
        if(temp.alt.size()!=0){
            for (int i = 0; i <temp.alt.size() ; i++) {

                if(temp.alt.get(i).kategori_ismi.equals(kategori))
                    return temp.alt.get(i);
                else{
                    temp2=kategorivarmi(kategori,temp.alt.get(i));
                    if(temp2!=null)return temp2;
                }

            }

        }
        return null;
    }

    public static void Yazdir(Kategori kok){



        for (int i = 0; i <kok.alt.size() ; i++) {
            System.out.print("   "+kok.alt.get(i).kategori_ismi);
        }


    }
}









/*




    public static void kullanicilari_al(String satir){

        int k=0;
        int kategori=0;
        String temp="";
        String isim="";
        String kat
        for (int i = 0; i <satir.length() ; i++) {

            if(satir.charAt(i)==','){

                if(k==0){
                    // System.out.println("isim = "+temp.trim());
                    temp="";
                }
                if(k==1){
                    //System.out.println("yer id = "+temp.trim());
                    temp="";
                }
                if(k==2){
                    // System.out.println("zaman = "+temp.trim());
                    temp="";
                }
                if(k==3){
                    // System.out.println("enlem = "+temp.trim());
                    temp="";
                }
                if(k==4){
                    //System.out.println("boylam = "+temp.trim());
                    temp="";
                }
                if(k==5){
                    //System.out.println("şehir = "+temp.trim());
                    temp="";
                }



                k++;
                continue;
            }

            temp+=satir.charAt(i);


        }
        kategoriagac(temp.trim());


    }
*/
