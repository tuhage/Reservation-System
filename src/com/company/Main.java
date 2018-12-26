package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public final static Kategori kategoriKOK = new Kategori();


    public static void main(String[] args) throws IOException {

        File file = new File("/home/tuhage/proje4/rezervasyon.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st=br.readLine();
        while ((st = br.readLine()) != null)
            kategorileri_al(st);

         br.close();


         br = new BufferedReader(new FileReader(file));
         st=br.readLine();
         while ((st = br.readLine()) != null)
           kullanicilari_al(st);


kullanicilariYazdir(kategorivarmi("Airport",kategoriKOK).kullanicikok);


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


        String temp="";
        for (int i = 0; i <satir.length() ; i++) {

            if(satir.charAt(i)==','){

                    temp="";
                continue;
            }

            temp+=satir.charAt(i);


        }

        kategoriagac(temp.trim());

    }

    public static void kullaniciagac(String kullanici,String kategori){

        Kategori tempkategori=kategorivarmi(kategori,kategoriKOK);
        if(tempkategori!=null) {
            if (kullanicivarmi(kullanici, tempkategori.kullanicikok) == null) {

                Kullanici yenikullanici = new Kullanici();
                yenikullanici.kullanici_adi = kullanici;
                yenikullanici.kategori_ismi=kategori;
                yenikullanici.rezervasyon_sayisi++;



                if (tempkategori.kullanicikok == null){
                    yenikullanici.kok = tempkategori;
                    tempkategori.kullanicikok=yenikullanici;

                }

                else{

                    yenikullanici_ekle(yenikullanici, tempkategori.kullanicikok,kategori);

                }

            }else{

                kullanicivarmi(kullanici, tempkategori.kullanicikok).rezervasyon_sayisi++;
                kullaniciguncelle(kullanicivarmi(kullanici, tempkategori.kullanicikok),tempkategori.kullanicikok,kategori);
            }

        }
    }

    private static void kullaniciguncelle(Kullanici kullanici, Kullanici kok,String kategori) {
        Kullanici temp=new Kullanici();
        Kullanici karsilastirma=kullanici.ust;
        if(kullanici.ust==null)return;
        while(true){
    if(kullanici.rezervasyon_sayisi>karsilastirma.rezervasyon_sayisi){

       temp.rezervasyon_sayisi=kullanici.rezervasyon_sayisi;
       temp.kategori_ismi=kullanici.kategori_ismi;
       temp.kullanici_adi=kullanici.kullanici_adi;
       kullanici.kullanici_adi=karsilastirma.kullanici_adi;
       kullanici.rezervasyon_sayisi=karsilastirma.rezervasyon_sayisi;
       kullanici.kategori_ismi=karsilastirma.kategori_ismi;
       karsilastirma.kullanici_adi=temp.kullanici_adi;
       karsilastirma.rezervasyon_sayisi=temp.rezervasyon_sayisi;
       karsilastirma.kategori_ismi=temp.kategori_ismi;

        }
        karsilastirma=karsilastirma.ust;
    if(karsilastirma==null)break;
        }
    }



    private static void yenikullanici_ekle(Kullanici yenikullanici, Kullanici kok,String kategori) {



            if(yenikullanici.ust!=null)return ;


            if(kok.sag==null){

                yenikullanici.ust=kok;
                kok.sag=yenikullanici;
                while(kok!=null){
                    kok.derinlik++;
                    kok=kok.ust;
                }
                return ;
            }else if(kok.sol==null){

                yenikullanici.ust=kok;
                kok.sol=yenikullanici;
                while(kok!=null){
                    kok.derinlik++;
                    kok=kok.ust;
                }
                return ;
            }

            if( kok.sag.derinlik<kok.sol.derinlik)
                yenikullanici_ekle(yenikullanici,kok.sag,kategori);
            else
                yenikullanici_ekle(yenikullanici,kok.sol,kategori);

            }



    public static void kullanicilariYazdir(Kullanici kok){

        if(kok==null)return;

        System.out.println("\nbas-"+kok.kullanici_adi+"  "+kok.rezervasyon_sayisi);
        if(kok.sag!=null) System.out.print("sag - "+kok.sag.kullanici_adi+"  ");
        if(kok.sol!=null) System.out.println("sol - "+kok.sol.kullanici_adi);
        if(kok.sag==null &&kok.sol==null)return;
        kullanicilariYazdir(kok.sag);
        kullanicilariYazdir(kok.sol);

    }

    public static Kullanici kullanicivarmi(String kullanici,Kullanici kok){


        Kullanici temp=null;
        if(kok==null)return null;
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
        Kategori aranacak_kok= kategoriKOK;
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
        kategoriKOK.rezervasyon_sayisi++;

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
