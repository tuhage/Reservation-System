package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public final static Kategori kategoriKOK = new Kategori();


    public static void main(String[] args) throws IOException {

        File file = new File("/home/tuhage/proje4/rezervasyon.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));
        Scanner scan=new Scanner(System.in);

        String st=br.readLine();
        while ((st = br.readLine()) != null)
            kategorileri_al(st);

         br.close();

         br = new BufferedReader(new FileReader(file));
         st=br.readLine();
         while ((st = br.readLine()) != null)
           kullanicilari_al(st);

         br = new BufferedReader(new FileReader(file));
         st=br.readLine();
         while ((st = br.readLine()) != null)
            rezervasyon_al(st);

        System.out.println("Txt dosyasindan bilgiler alındı....");
        int secimint;
        String secimstring;
        Kategori tempkategori=null;
        Kullanici tempkullanici=null;


        while (true){

               System.out.println("\nKategori           ile ilgili işlemler için : 1");
               System.out.println("Kullanıcı          ile ilgili işlemler için : 2");
               System.out.println("Sorgu ve listeleme ile ilgili işlemler için : 3");
               System.out.println("                                 Çıkış için : 4");
               System.out.print("Lütfen bir secim yapınız : ");

               try {
                   secimint=scan.nextInt();
               }catch (InputMismatchException e1){
                   scan.nextLine();
                   continue;
               }
                scan.nextLine();

               if(secimint==1){
                       while (true){
                           System.out.print("\nHangi kategori üzerinde işlem yapmak istiyorsunuz ? :");
                           secimstring=scan.nextLine();
                           tempkategori=kategorivarmi(secimstring,kategoriKOK);
                           if(tempkategori!=null){
                               while(true){
                                   Kategoribilgileriyaz(tempkategori);
                                   break;
                               }
                           }else{
                               System.out.println("Girdiğiniz kategori bulunamamıştır.");
                               continue;
                           }

                           while (true) {
                               System.out.println("\nSecilen kategorinin altına yeni kategori eklemek için : 1");
                               System.out.println("Secilen kategorinin altından    kategori silmek  için : 2");
                               System.out.println("                                     Geri gitmek için : 3");
                               System.out.print("Lütfen bir secim yapınız : ");
                               try {
                                   secimint = scan.nextInt();
                               } catch (InputMismatchException e1) {
                                   scan.nextLine();
                                   continue;
                               }
                               scan.nextLine();
                                   if (secimint == 1) {
                                       System.out.print("Eklemek istediğiniz kategorinin ismini giriniz : ");
                                       secimstring=scan.nextLine();
                                       if(kategorivarmi(secimstring,tempkategori)!=null){
                                           System.out.println("\nGirdiğiniz kategori zaten mevcut. İşlem tamamlanamadı !");
                                       }else{
                                        KategoriEkle(secimstring,tempkategori);
                                           System.out.println("\nEkleme işlemi başarı ile tamamlandı.");
                                       }
                                                      }
                               else if (secimint == 2) {
                                   System.out.print("Silmek istediğiniz kategorinin ismini giriniz : ");
                                   secimstring=scan.nextLine();
                                   if(kategorivarmi(secimstring,tempkategori)==null){
                                       System.out.println("\nGirdiğiniz kategori mevcut değil. İşlem tamamlanamadı !");
                                   }else{
                                       KategoriSil(kategorivarmi(secimstring,tempkategori));
                                       System.out.println("\nSilme işlemi başarı ile tamamlandı.");
                                   }
                               }
                               break;
                           }
                           break;
                       }

                   }
                   else if(secimint==2){
                   while (true){


                       while (true) {
                           System.out.println("\nSecilen kategorinin altına yeni kullanıcı eklemek   için : 1");
                           System.out.println("Bir kategorinin altından tüm kullanıcıları  silmek  için  : 2");
                           System.out.println("Secilen kategorinin altından bir kullanıcı  silmek  için  : 3");
                           System.out.println("Bir kullanıyı tüm kategorilerden            silmek  için  : 4");
                           System.out.println("                                      Geri  gitmek  için  : 5");
                             System.out.print("Lütfen bir secim yapınız : ");
                           try {
                               secimint = scan.nextInt();
                           } catch (InputMismatchException e1) {
                               scan.nextLine();
                               continue;
                           }
                           scan.nextLine();
                           if (secimint == 1) {
                               System.out.println("Hangi kategoriye ekleme yapmak istiyorsunuz? : ");
                               secimstring=scan.nextLine();
                               if(kategorivarmi(secimstring,kategoriKOK)==null){
                                   System.out.println("\nGirdiğiniz kategori mevcut değil. İşlem tamamlanamadı !");
                                   continue;
                               }else{
                                   tempkategori=kategorivarmi(secimstring,kategoriKOK);
                               }
                               System.out.print("Eklemek istediğiniz kullanıcının ismini giriniz : ");
                               secimstring=scan.nextLine();
                               if(kategorivarmi(secimstring,tempkategori)!=null){
                                   System.out.println("\nGirdiğiniz kullanıcı zaten mevcut. İşlem tamamlanamadı !");
                               }else{
                                   KategoriEkle(secimstring,tempkategori);
                                   System.out.println("\nEkleme işlemi başarı ile tamamlandı.");
                               }
                           }
                           else if (secimint == 2) {
                               System.out.print("Tüm kullanıcılarını silmek istediğiniz kategorinin ismini giriniz : ");
                               secimstring=scan.nextLine();
                               if(kategorivarmi(secimstring,kategoriKOK)==null){
                                   System.out.println("\nGirdiğiniz kategori mevcut değil. İşlem tamamlanamadı !");
                               }else{
                                   tempkategori=kategorivarmi(secimstring,kategoriKOK);
                                   if(tempkategori.kullanicikok==null){
                                       System.out.println("\nGirdiğiniz kategori içerisinde kullanıcı bulunmamaktadir. İşlem tamamlanamadı ! ");
                                       continue;
                                   }
                                   KullaniciSil1(tempkategori);
                                   System.out.println("\nSilme işlemi başarı ile tamamlandı.");
                               }
                           }else if (secimint == 3) {
                               System.out.print("Kullanıcı silmek istediğiniz kategorinin ismini giriniz : ");
                               secimstring=scan.nextLine();
                               if(kategorivarmi(secimstring,tempkategori)==null){
                                   System.out.println("\nGirdiğiniz kategori mevcut değil. İşlem tamamlanamadı !");
                               }else{
                                   System.out.print("Hangi kullanıcıyı simek istiyorsunuz :");
                                   tempkullanici=kullanicivarmi(scan.nextLine(),tempkategori.kullanicikok);
                                   if(tempkullanici==null){
                                       System.out.println("\nBu kategori altında böyle bir kullanıcı bulunmamaktadır !");
                                       break;
                                   }

                                   KullaniciSil2(tempkullanici,tempkategori);
                                   System.out.println("\nSilme işlemi başarı ile tamamlandı.");
                               }
                           }
                           break;
                       }
                       break;
                   }


               }
                   else if(secimint==3){
                       System.out.println("3");

                   }else if(secimint==4)break;
                   else
                       System.out.println("\nGeçersiz bir giriş. Tekrar deneyin");


               }




    }

    private static void KullaniciSil1(Kategori tempkategori) {
        Kategori temp=tempkategori.ust;
       while (true){
           if(temp.ust==null)break;
           temp.kullanici_sayisi-=tempkategori.kullanici_sayisi;
           temp.rezervasyon_sayisi-=tempkategori.rezervasyon_sayisi;
           temp=temp.ust;
       }
       tempkategori.rezervasyon_sayisi=0;
       tempkategori.kullanici_sayisi=0;
       tempkategori.kullanicikok=null;


    }
    private static void KullaniciSil2(Kullanici tempkullanici,Kategori tempkategori) {
        Kullanici temp,temp2;
        while (true){
            if(tempkategori.ust==null)break;
            tempkategori.kullanici_sayisi--;
            tempkategori.rezervasyon_sayisi-=tempkullanici.rezervasyon_sayisi;
            tempkategori=tempkategori.ust;
        }
    if(tempkullanici.ust==null){
        if(tempkullanici.sag.rezervasyon_sayisi>tempkullanici.sol.rezervasyon_sayisi)
        {
            tempkullanici.kok.kullanicikok=tempkullanici.sag;
            temp=tempkullanici.sol;
        }
        else
        {
            tempkullanici.kok.kullanicikok=tempkullanici.sol;
            temp=tempkullanici.sag;
        }


        tempkullanici=tempkullanici.kok.kullanicikok;
        tempkullanici.derinlik-=tempkullanici.sol.derinlik;
        temp2=tempkullanici.sol;
        tempkullanici.sol=temp;
        tempkullanici.derinlik+=temp.derinlik;

        yenikullanici_ekle(temp2,tempkategori.kullanicikok);
        kullaniciguncelle(temp2);
        Kullanicidugumunekle(tempkategori.kullanicikok,temp2);



    }

    }
    private static void Kullanicidugumunekle(Kullanici kok,Kullanici dugum){

        if(dugum==null)return;

        yenikullanici_ekle(dugum.sag,kok);
        kullaniciguncelle(dugum.sag);
        yenikullanici_ekle(dugum.sol,kok);
        kullaniciguncelle(dugum.sol);

        Kullanicidugumunekle(kok,dugum.sag);
        Kullanicidugumunekle(kok,dugum.sol);



    }
    private static void KategoriSil(Kategori tempkategori) {

        tempkategori.ust.alt.remove(tempkategori);
        for (int i = 0; i <tempkategori.alt.size() ; i++) {
            tempkategori.alt.get(i).derinlik--;
            tempkategori.alt.get(i).ust=tempkategori.ust;
            tempkategori.alt.get(i).kategori_yolu=tempkategori.alt.get(i).kategori_yolu.replaceAll(tempkategori.kategori_ismi+":","");
        }
        tempkategori.ust.alt.addAll(tempkategori.alt);
        tempkategori.ust.alt_kategori_sayisi+=(tempkategori.alt_kategori_sayisi-1);
        for (int i = 0; i <tempkategori.alt.size(); i++) {
            tempkategori.ust.rezervasyon_sayisi+=tempkategori.alt.get(i).rezervasyon_sayisi;
        }
        tempkategori.ust.rezervasyon_sayisi-=tempkategori.rezervasyon_sayisi;
        for (int i = 0; i <tempkategori.alt.size(); i++) {
            tempkategori.ust.kullanici_sayisi+=tempkategori.alt.get(i).kullanici_sayisi;
        }
        tempkategori.ust.kullanici_sayisi-=tempkategori.kullanici_sayisi;
        tempkategori.alt.clear();
        tempkategori=null;
    }

    private static void KategoriEkle(String kategorisim,Kategori kok){

        Kategori yenikategori=new Kategori();
        yenikategori.kategori_ismi=kategorisim;
        yenikategori.ust=kok;
        yenikategori.kullanici_sayisi=0;
        yenikategori.rezervasyon_sayisi=0;
        yenikategori.derinlik=kok.derinlik+1;
        yenikategori.kategori_yolu=kok.kategori_yolu+":"+kategorisim;
        kok.alt_kategori_sayisi++;
        kok.alt.add(yenikategori);

    }
    private static void Kategoribilgileriyaz(Kategori kategori){
        System.out.println("\n  Kategori Bilgileri");
        System.out.println("------------------------");
        System.out.println("Kategori ismi       : "+kategori.kategori_ismi);
        System.out.println("Alt kategori sayisi : "+kategori.alt_kategori_sayisi);
        System.out.println("Kullanici    sayisi : "+kategori.kullanici_sayisi);
        System.out.println("Rezervasyon  sayisi : "+kategori.rezervasyon_sayisi);
        System.out.println("Kategori       yolu : "+kategori.kategori_yolu);
        System.out.println("Derinlik            : "+kategori.derinlik);


    }

    private static void rezervasyonlari_yazdir(Rezervasyon kok){

        String isim=kok.kok.kullanici_adi;
        String kategori=kok.kok.kategori_ismi;
        while (true){
            if(kok==null)break;
            System.out.println("--------------------------------------");
            System.out.println("İsim = "+isim);
            System.out.println("Kategori = "+kategori);
            System.out.println("Sehir = "+kok.sehir);
            System.out.println("Enlem = "+kok.enlem);
            System.out.println("Boylam = "+kok.boylam);
            System.out.println("Zaman = "+kok.rezervasyon_zamani);
            System.out.println("Yer Id = "+kok.yer_id);
            System.out.println("--------------------------------------");

            kok=kok.sonraki;
        }





    }

    private static void rezervasyon_al(String st) {

        int k=0;
        String temp="";
        String isim="";
        String kategori="";
        String yerid="";
        String rezervasyonzamani="";
        String enlem="";
        String boylam="";
        String sehir="";

        for (int i = 0; i <st.length() ; i++) {

            if(st.charAt(i)==','){

                if(k==0){
                    isim=temp.trim();

                }
                if(k==1){

                    yerid=temp.trim();
                }
                if(k==2){

                    rezervasyonzamani=temp.trim();
                }
                if(k==3){

                    enlem=temp.trim();
                }
                if(k==4){

                   boylam=temp.trim();
                }
                if(k==5){

                    sehir=temp.trim();
                }
                temp="";
                k++;
                continue;
            }

            temp+=st.charAt(i);


        }
        kategori=temp.trim();

        while (kategori.contains(":")){
            kategori=kategori.substring(kategori.indexOf(":")+1);
        }

        rezervasyon_bagla(isim,kategori,yerid,rezervasyonzamani,enlem,boylam,sehir);

    }

    public static void rezervasyon_bagla(String isim,String kategori,String yerid, String rezervasyonzamani, String enlem, String boylam, String sehir){
        Rezervasyon yenirezervasyon=new Rezervasyon();
        yenirezervasyon.boylam=Double.parseDouble(boylam);
        yenirezervasyon.enlem=Double.parseDouble(enlem);
        yenirezervasyon.rezervasyon_zamani=rezervasyonzamani;
        yenirezervasyon.sehir=sehir;
        yenirezervasyon.yer_id=yerid;
        Kategori tempkategori=kategorivarmi(kategori,kategoriKOK);
        Kullanici tempkullanici=kullanicivarmi(isim,tempkategori.kullanicikok);
        yenirezervasyon.kok=tempkullanici;
        yenirezervasyon.sonraki=null;

        if(tempkullanici.rezervasyon_kok==null){
            yenirezervasyon.onceki=null;
            tempkullanici.rezervasyon_kok=yenirezervasyon;
        }else rezervasyon_ekle(tempkullanici.rezervasyon_kok, yenirezervasyon);

    }

    private static void rezervasyon_ekle(Rezervasyon rezervasyon_kok, Rezervasyon yenirezervasyon) {



    while (true){



       if(rezervasyon_kok.sonraki==null){
           rezervasyon_kok.sonraki=yenirezervasyon;
           yenirezervasyon.onceki=rezervasyon_kok;
           break;
       }

        rezervasyon_kok=rezervasyon_kok.sonraki;
    }

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

    public static void kullanicisayisiarttir(Kategori kategori){
        while (true){
            if(kategori==null)break;
            kategori.kullanici_sayisi++;
            kategori=kategori.ust;
        }
    }
    public static void kullaniciagac(String kullanici,String kategori){

        Kategori tempkategori=kategorivarmi(kategori,kategoriKOK);
        if(tempkategori!=null) {
            if (kullanicivarmi(kullanici, tempkategori.kullanicikok) == null) {

                Kullanici yenikullanici = new Kullanici();
                yenikullanici.kullanici_adi = kullanici;
                yenikullanici.kategori_ismi=kategori;
                yenikullanici.rezervasyon_sayisi++;
                kullanicisayisiarttir(tempkategori);


                if (tempkategori.kullanicikok == null){
                    yenikullanici.kok = tempkategori;
                    tempkategori.kullanicikok=yenikullanici;

                }

                else{

                    yenikullanici_ekle(yenikullanici, tempkategori.kullanicikok);

                }

            }else{

                kullanicivarmi(kullanici, tempkategori.kullanicikok).rezervasyon_sayisi++;
                kullaniciguncelle(kullanicivarmi(kullanici, tempkategori.kullanicikok));
            }

        }
    }

    private static void kullaniciguncelle(Kullanici kullanici) {
        Kullanici karsilastirma=kullanici.ust;
        if(kullanici.ust==null)return;
        while(true){
    if(kullanici.rezervasyon_sayisi>karsilastirma.rezervasyon_sayisi){

       kullaniciyerdegistir(kullanici,karsilastirma);

        }
        karsilastirma=karsilastirma.ust;
    if(karsilastirma==null)break;
        }
    }

    private static void kullaniciyerdegistir(Kullanici kullanici,Kullanici karsilastirma){
        Kullanici temp=new Kullanici();
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

    private static void yenikullanici_ekle(Kullanici yenikullanici, Kullanici kok) {



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
                yenikullanici_ekle(yenikullanici,kok.sag);
            else
                yenikullanici_ekle(yenikullanici,kok.sol);

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
                aranan_kok.ust.alt_kategori_sayisi++;
                aranan_kok.rezervasyon_sayisi++;
                aranan_kok.derinlik=i+1;
                aranacak_kok=aranan_kok;

            }
            else{


                aranacak_kok=aranan_kok;
                aranan_kok.rezervasyon_sayisi++;


            }



        }
        kategoriKOK.rezervasyon_sayisi++;

    }
    public static Kategori kategorivarmi(String kategori,Kategori temp){
        Kategori temp2;
        if(kategori.equalsIgnoreCase("Rezervasyon"))return kategoriKOK;
        if(temp.alt.size()!=0){
            for (int i = 0; i <temp.alt.size() ; i++) {

                if(temp.alt.get(i).kategori_ismi.equalsIgnoreCase(kategori))
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
            System.out.print("\n   "+kok.alt.get(i).kategori_ismi);
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
