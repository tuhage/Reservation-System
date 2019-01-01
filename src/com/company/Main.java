package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    private final static Kategori kategoriKOK = new Kategori();


    public static void main(String[] args) throws IOException {

        String Dosyaismi="rezervasyon2";
        File file = new File("/home/tuhage/proje4/"+Dosyaismi+".txt");

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
                                   Kategoribilgileriyaz(tempkategori);

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
                                       if(kategorivarmi2(secimstring,tempkategori)!=null){
                                           System.out.println("\nGirdiğiniz kategori zaten mevcut. İşlem tamamlanamadı !");
                                       }else{
                                        KategoriEkle(secimstring,tempkategori);
                                           System.out.println("\nEkleme işlemi başarı ile tamamlandı.");
                                       }
                                                      }
                               else if (secimint == 2) {
                                   System.out.print("Silmek istediğiniz kategorinin ismini giriniz : ");
                                   secimstring=scan.nextLine();
                                   if(kategorivarmi2(secimstring,tempkategori)==null){
                                       System.out.println("\nGirdiğiniz kategori mevcut değil. İşlem tamamlanamadı !");
                                   }else{
                                       KategoriSil(kategorivarmi2(secimstring,tempkategori));
                                       System.out.println("\nSilme işlemi başarı ile tamamlandı.");
                                   }
                               }else if(secimint==3 )
                               break;
                               else
                                   System.out.println("\nGeçersiz bir giriş. Tekrar deneyin");
                           }
                           break;
                       }

                   }
                   else if(secimint==2){
                   while (true){


                       while (true) {
                           System.out.println("\nSecilen kategorinin altına yeni kullanıcı eklemek   için  : 1");
                           System.out.println("Bir kategorinin altından tüm kullanıcıları  silmek  için  : 2");
                           System.out.println("Secilen kategorinin altından bir kullanıcı  silmek  için  : 3");
                           System.out.println("Bir kullanıyı tüm kategorilerden            silmek  için  : 4");
                           System.out.println("                                       Geri gitmek  için  : 5");
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
                               if(kullanicivarmi(secimstring,tempkategori.kullanicikok)!=null){
                                   System.out.println("\nGirdiğiniz kullanıcı zaten mevcut. İşlem tamamlanamadı !");
                               }else{
                                   Kullaniciekle(secimstring,tempkategori);
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
                                   KullaniciSil1(tempkategori);
                                   System.out.println("\nSilme işlemi başarı ile tamamlandı.");
                               }
                           }else if (secimint == 3) {
                               System.out.print("Kullanıcı silmek istediğiniz kategorinin ismini giriniz : ");
                               secimstring=scan.nextLine();
                               if(kategorivarmi(secimstring,kategoriKOK)==null){
                                   System.out.println("\nGirdiğiniz kategori mevcut değil. İşlem tamamlanamadı !");
                               }else{
                                   tempkategori=kategorivarmi(secimstring,kategoriKOK);
                                   System.out.print("Hangi kullanıcıyı silmek istiyorsunuz :");
                                   if(KullaniciSil3(scan.nextLine(),tempkategori)!=0)
                                       System.out.println("\nSilme işlemi başarı ile tamamlandı.");
                                   else
                                       System.out.println("\nBu isimde bir kullanıcı bulunmamaktadır.");
                               }
                           }else if (secimint == 4) {
                               System.out.print("Tüm kategorilerden silmek istediğiniz kullanıcının ismini giriniz : ");
                               secimstring=scan.nextLine();

                               if(KullaniciSil3(secimstring,kategoriKOK)!=0)
                                   System.out.println("\nSilme işlemi başarı ile tamamlandı.");
                               else
                                   System.out.println("\nBu isimde bir kullanıcı bulunmamaktadır.");
                               }else if(secimint==5)break;
                           else
                           {
                               System.out.println("\nGeçersiz bir giriş. Tekrar deneyin");

                           }

                           }
                           break;
                       }

                   }
                   else if(secimint==3){
                   while (true){


                       while (true) {
                           System.out.println("\nKullanıcıya göre                  listeleme için : 1");
                           System.out.println("Kategoriye göre kullanıcı         listeleme için : 2");
                           System.out.println("Rezervasyon yerine göre kullanıcı listeleme için : 3");
                           System.out.println("Kullanıcıya göre rezervasyon      listeleme için : 4");
                           System.out.println("                               Geri gitmek  için : 5");
                           System.out.print("Lütfen bir secim yapınız : ");
                           try {
                               secimint = scan.nextInt();
                           } catch (InputMismatchException e1) {
                               scan.nextLine();
                               continue;
                           }
                           scan.nextLine();
                           if (secimint == 1) {
                               ArrayList<String> kategorisimleri=new ArrayList<String>(200);
                               System.out.print("Hangi kullanıcıyı ait kategorileri listelemek istiyorsunuz :");
                               String a=scan.nextLine();
                               System.out.println("\nKategoriler Gösteriliyor");
                               System.out.println("--------------------------");
                               listele1(a,kategoriKOK,kategorisimleri);
                               for (int i = 0; i <kategorisimleri.size() ; i++) {
                                   System.out.println(kategorisimleri.get(i));

                               }

                           }

                           else if (secimint == 2) {
                               ArrayList<String> kullanicisimleri=new ArrayList<String>(200);
                               System.out.print("Hangi kategoriye ait kullanıcıları listelemek istiyorsunuz :");
                               tempkategori=kategorivarmi(scan.nextLine(),kategoriKOK);
                               System.out.println("\nKullanıcılar Gösteriliyor");
                               System.out.println("--------------------------");
                               if(tempkategori!=null)
                               listele2(tempkategori,kullanicisimleri);
                               else{
                                   System.out.println("\nBöyle bir kategori mevcut değil");
                                   continue;
                               }
                               if(kullanicisimleri.size()==0){
                                   System.out.println("\nGirdiğiniz kategorinin altında kullanıcı bulunmamaktadır.");
                                   continue;
                               }
                               for (int i = 0; i <kullanicisimleri.size() ; i++) {
                                   System.out.println(kullanicisimleri.get(i));
                               }

                           }else if (secimint == 3) {
                               ArrayList<String> kullanicisimleri=new ArrayList<String>(200);
                               System.out.print("Hangi yerde rezervasyon yaptırmış kullanıcıları listelemek istiyorsunuz :");
                               String yer=scan.nextLine();
                               System.out.println("\nKullanıcılar Gösteriliyor");
                               System.out.println("--------------------------");
                               listele3(kullanicisimleri,yer,kategoriKOK);
                               if(kullanicisimleri.size()==0){
                                   System.out.println("\nGirdiğiniz yerde kullanıcı bulunmamaktadır.");
                                   continue;
                               }
                               for (int i = 0; i <kullanicisimleri.size() ; i++) {
                                   System.out.println(kullanicisimleri.get(i));
                               }

                           }else if (secimint == 4) {
                               ArrayList<Rezervasyon> rezervasyonlar=new ArrayList<>(200);
                               System.out.print("Hangi kullanıcıyı ait rezervasyonları listelemek istiyorsunuz :");
                               String kullanici=scan.nextLine();
                               System.out.println("\nRezervasyonlar Gösteriliyor");
                               System.out.println("-------------------------");
                               listele4(rezervasyonlar,kullanici,kategoriKOK);
                               for (int i = 0; i <rezervasyonlar.size() ; i++) {

                                   System.out.println("Yer id = "+rezervasyonlar.get(i).yer_id);
                                   System.out.println("Enlem  = "+rezervasyonlar.get(i).enlem);
                                   System.out.println("Boylam = "+rezervasyonlar.get(i).boylam);
                                   System.out.println("Sehir  = "+rezervasyonlar.get(i).sehir);
                                   System.out.println("Son rezervasyon zamani = "+rezervasyonlar.get(i).rezervasyon_zamani);
                                   System.out.println("-------------------------");
                               }

                           }else if(secimint==5)break;
                           else
                           {
                               System.out.println("\nGeçersiz bir giriş. Tekrar deneyin");

                           }

                       }
                       break;
                   }

               }else if(secimint==4)
                       break;
                   else
                       System.out.println("\nGeçersiz bir giriş. Tekrar deneyin");


               }
        System.out.println("\n\n******************");

       // kullanicilariYazdir(kategorivarmi("rezervasyon",kategoriKOK).kullanicikok);


    }

    private static void listele4( ArrayList<Rezervasyon> rezervasyonlar,String kullanici, Kategori temp) {
        if(temp.kullanicikok!=null) {

            if(kullanicivarmi(kullanici,temp.kullanicikok)!=null){

                kullaniciyagoreyer(rezervasyonlar,kullanici,kullanicivarmi(kullanici,temp.kullanicikok).rezervasyon_kok);
            }


        }

        if(temp.alt.size()!=0){

            for (int i = 0; i <temp.alt.size() ; i++) {


                if(temp.kullanicikok!=null)
                {
                    if(kullanicivarmi(kullanici,temp.alt.get(i).kullanicikok)!=null) {

                        kullaniciyagoreyer(rezervasyonlar, kullanici, kullanicivarmi(kullanici, temp.alt.get(i).kullanicikok).rezervasyon_kok);
                    }
                }


                listele4(rezervasyonlar,kullanici,temp.alt.get(i));


            }

        }
    }

    private static void kullaniciyagoreyer(ArrayList<Rezervasyon> rezervasyonlar, String kullanici, Rezervasyon rezervasyon_kok) {


        if(rezervasyon_kok==null)return;

        Rezervasyon temp=rezervasyon_kok;

        while(temp!=null){

        rezervasyonekle(rezervasyonlar,temp);
        temp=temp.sonraki;
        }

    }

    private static void rezervasyonekle(ArrayList<Rezervasyon> rezervasyonlar,Rezervasyon rezervasyon){
        for (int i = 0; i <rezervasyonlar.size() ; i++) {

            if(rezervasyonlar.get(i).yer_id.equals(rezervasyon.yer_id)){

               if(rezervasyonzamankarsilastir(rezervasyonlar.get(i).rezervasyon_zamani,rezervasyon.rezervasyon_zamani)){
                   rezervasyonlar.remove(i);
                   rezervasyonlar.add(rezervasyon);
                   return;

               }else
                   return;

            }
        }

        rezervasyonlar.add(rezervasyon);
    }

    private static boolean rezervasyonzamankarsilastir(String rezervasyon_zamani1, String rezervasyon_zamani2) {

        ArrayList<Integer> z1=new ArrayList<>(),z2=new ArrayList<>();String temp="";

        for (int i = 0; i <rezervasyon_zamani1.length() ; i++) {
            if(rezervasyon_zamani1.charAt(i)=='-'||rezervasyon_zamani1.charAt(i)=='T'||rezervasyon_zamani1.charAt(i)==':'){
                z1.add(Integer.parseInt(temp));
                temp="";
                continue;
            }
            temp+=rezervasyon_zamani1.charAt(i);
        }
        z1.add(Integer.parseInt(temp));
        temp="";

        for (int i = 0; i <rezervasyon_zamani2.length() ; i++) {
            if(rezervasyon_zamani2.charAt(i)=='-'||rezervasyon_zamani2.charAt(i)=='T'||rezervasyon_zamani2.charAt(i)==':'){
                z2.add(Integer.parseInt(temp));
                temp="";
                continue;
            }
            temp+=rezervasyon_zamani2.charAt(i);
        }
        z2.add(Integer.parseInt(temp));

        for (int i = 0; i <z1.size() ; i++) {

            if(z2.get(i)>z1.get(i))return true;

        }

return false;
    }

    private static void listele3(ArrayList<String> kullanicisimleri, String yer, Kategori temp) {

        if(temp.kullanicikok!=null) {

            yeregorekullanicikontrol(kullanicisimleri,temp.kullanicikok,yer);


        }

        if(temp.alt.size()!=0){

            for (int i = 0; i <temp.alt.size() ; i++) {


                if(temp.kullanicikok!=null)
                {
                    yeregorekullanicikontrol(kullanicisimleri,temp.alt.get(i).kullanicikok,yer);

                }


                listele3(kullanicisimleri,yer,temp.alt.get(i));


            }

        }

    }
    public static void listele2(Kategori temp,ArrayList<String> kullanicisimleri){

        if(temp.kullanicikok!=null)
        {

            listele22(temp,kullanicisimleri);

        }
        if(temp.alt.size()!=0){
            for (int i = 0; i <temp.alt.size() ; i++) {

                if(temp.alt.get(i).kullanicikok!=null)
                {

                   listele22(temp.alt.get(i),kullanicisimleri);

                }



                listele2(temp.alt.get(i),kullanicisimleri);


            }

        }


    }

    private static void listele22(Kategori temp,ArrayList<String> kullanicisimleri) {



            if(temp.kullanicikok!=null) {

                kullaniciAlistekle(kullanicisimleri,temp.kullanicikok);

            }

        if(temp.alt.size()!=0){

            for (int i = 0; i <temp.alt.size() ; i++) {


                    if(temp.alt.get(i).kullanicikok!=null)
                    {
                        kullaniciAlistekle(kullanicisimleri,temp.alt.get(i).kullanicikok);

                    }


                listele22(temp.alt.get(i),kullanicisimleri);


            }

        }

    }

    private static void listele1(String secimstring,Kategori temp,ArrayList<String> kategorisimleri) {

        int kontrol=0;

        if(kullanicivarmi(secimstring,temp.kullanicikok)!=null){
           if(!(kategorisimleri.contains(temp.kategori_ismi))) {

               kategorisimleri.add(temp.kategori_ismi);

           }

        }
        if(temp.alt.size()!=0){
            for (int i = 0; i <temp.alt.size() ; i++) {

                if(kullanicivarmi(secimstring,temp.alt.get(i).kullanicikok)!=null)
                {
                    if(!(kategorisimleri.contains(temp.alt.get(i).kategori_ismi))) {

                        kategorisimleri.add(temp.alt.get(i).kategori_ismi);

                    }
                }

                listele1(secimstring,temp.alt.get(i),kategorisimleri);


            }

        }

    }


    private static int KullaniciSil3(String secimstring,Kategori temp) {

       Kullanici temp3;int kontrol=0;
        if(kullanicivarmi(secimstring,temp.kullanicikok)!=null){
            temp3=kullanicivarmi(secimstring,temp.kullanicikok);
            KullaniciSil2(temp3,temp);
            kontrol++;
        }
        if(temp.alt.size()!=0){
            for (int i = 0; i <temp.alt.size() ; i++) {

                if(kullanicivarmi(secimstring,temp.alt.get(i).kullanicikok)!=null)
                {
                    temp3=kullanicivarmi(secimstring,temp.alt.get(i).kullanicikok);
                    KullaniciSil2(temp3,temp.alt.get(i));
                   kontrol++;
                }

                KullaniciSil3(secimstring,temp.alt.get(i));


            }

        }

        return kontrol;


    }


    public static void Kullanicisil(Kategori temp){


        if(temp.alt.size()!=0){
            for (int i = 0; i <temp.alt.size() ; i++) {

                if(temp.alt.get(i).kullanicikok!=null)
                {

                    temp.alt.get(i).rezervasyon_sayisi=0;
                    temp.alt.get(i).kullanici_sayisi=0;
                    temp.alt.get(i).kullanicikok=null;

                }



                    Kullanicisil(temp.alt.get(i));


            }

        }

    }
    private static void KullaniciSil1(Kategori tempkategori) {
        Kategori temp=tempkategori.ust;

        while (temp != null) {
            temp.kullanici_sayisi -= tempkategori.kullanici_sayisi;
            temp.rezervasyon_sayisi -= tempkategori.rezervasyon_sayisi;
            temp = temp.ust;
        }


       tempkategori.rezervasyon_sayisi=0;
       tempkategori.kullanici_sayisi=0;
       tempkategori.kullanicikok=null;

       Kullanicisil(tempkategori);

    }
    private static void KullaniciSil2(Kullanici tempkullanici,Kategori tempkategori) {
        Kullanici temp,temp2,temp3;
        Kategori temp4=tempkategori;
        while (true){

            temp4.kullanici_sayisi--;
            temp4.rezervasyon_sayisi-=tempkullanici.rezervasyon_sayisi;
            temp4=temp4.ust;
            if(temp4==null)break;
        }


    if(tempkullanici.ust==null){

        if(tempkullanici.sag==null&&tempkullanici.sol==null){

           tempkullanici.kok.kullanicikok=null;
            return;

        }else if(tempkullanici.sag==null){

           tempkullanici.kok.kullanicikok=tempkullanici.sol;
            return;
        }else if(tempkullanici.sol==null){

            tempkullanici.kok.kullanicikok=tempkullanici.sag;
            return;


        }




        if(tempkullanici.sag.rezervasyon_sayisi>tempkullanici.sol.rezervasyon_sayisi)
        {
            tempkullanici.sag.ust=null;
            tempkullanici.kok.kullanicikok=tempkullanici.sag;
            temp=tempkullanici.sol;
            tempkullanici=tempkullanici.kok.kullanicikok;
            if(tempkullanici.sol!=null)
            tempkullanici.derinlik-=tempkullanici.sol.derinlik;
            temp2=tempkullanici.sol;
            tempkullanici.sol=temp;
        }
        else
        {
            tempkullanici.sol.ust=null;
            tempkullanici.kok.kullanicikok=tempkullanici.sol;
            temp=tempkullanici.sag;
            tempkullanici=tempkullanici.kok.kullanicikok;
            if(tempkullanici.sag!=null)
            tempkullanici.derinlik-=tempkullanici.sag.derinlik;
            temp2=tempkullanici.sag;
            tempkullanici.sag=temp;
        }

        tempkullanici.derinlik+=temp.derinlik;

        if(temp2!=null) {
            temp3 = new Kullanici(temp2);
            yenikullanici_ekle(temp3, tempkategori.kullanicikok);

            kullaniciguncelle(temp3);
            Kullanicidugumunekle(tempkategori.kullanicikok, temp2);
        }


    }else{

        if(tempkullanici.sag==null&&tempkullanici.sol==null){

            if(tempkullanici.ust.sag==tempkullanici){
                tempkullanici.ust.sag=null;

            }else{
                tempkullanici.ust.sol=null;

            }
            return;

        }else if(tempkullanici.sag==null){

            if(tempkullanici.ust.sag==tempkullanici){
                tempkullanici.ust.sag=tempkullanici.sol;
                tempkullanici.sol.ust=tempkullanici.ust;

            }else{
                tempkullanici.ust.sol=tempkullanici.sol;
                tempkullanici.sol.ust=tempkullanici.ust;

            }
            return;
        }else if(tempkullanici.sol==null){

            if(tempkullanici.ust.sag==tempkullanici){
                tempkullanici.ust.sag=tempkullanici.sag;
                tempkullanici.sag.ust=tempkullanici.ust;

            }else{
                tempkullanici.ust.sol=tempkullanici.sag;
                tempkullanici.sag.ust=tempkullanici.ust;

            }
            return;

        }

        if(tempkullanici.sag.rezervasyon_sayisi>tempkullanici.sol.rezervasyon_sayisi)
        {
            tempkullanici.sag.ust=tempkullanici.ust;

            if(tempkullanici.ust.sag==tempkullanici)
            {
                tempkullanici.ust.sag=tempkullanici.sag;
                temp=tempkullanici.sol;
                tempkullanici= tempkullanici.ust.sag;
            }
            else
            {
                tempkullanici.ust.sol=tempkullanici.sag;
                temp=tempkullanici.sol;
                tempkullanici=tempkullanici.ust.sol;
            }

            if(tempkullanici.sol!=null)
            tempkullanici.derinlik-=tempkullanici.sol.derinlik;
            temp2=tempkullanici.sol;
            tempkullanici.sol=temp;
        }
        else
        {
            tempkullanici.sol.ust=tempkullanici.ust;

            if(tempkullanici.ust.sag==tempkullanici)
            {
                tempkullanici.ust.sag=tempkullanici.sol;
                temp=tempkullanici.sag;
                tempkullanici= tempkullanici.ust.sag;
            }
            else
            {
                tempkullanici.ust.sol=tempkullanici.sol;
                temp=tempkullanici.sag;
                tempkullanici=tempkullanici.ust.sol;
            }

            if(tempkullanici.sag!=null)
            tempkullanici.derinlik-=tempkullanici.sag.derinlik;
            temp2=tempkullanici.sag;
            tempkullanici.sag=temp;
        }

        tempkullanici.derinlik+=temp.derinlik;

        if(temp2!=null) {
            temp3 = new Kullanici(temp2);

            yenikullanici_ekle(temp3, tempkategori.kullanicikok);
            kullaniciguncelle(temp3);

            Kullanicidugumunekle(tempkategori.kullanicikok, temp2);

        }

    }

    }
    private static void Kullanicidugumunekle(Kullanici kok,Kullanici dugum){
        Kullanici temp;


        if(dugum==null)return;


        if(dugum.sag!=null) {
            temp = new Kullanici(dugum.sag);
            yenikullanici_ekle(temp, kok);
            kullaniciguncelle(temp);

        }
        if(dugum.sol!=null) {
            temp = new Kullanici(dugum.sol);
            yenikullanici_ekle(temp, kok);
            kullaniciguncelle(temp);

        }
        Kullanicidugumunekle(kok,dugum.sag);
        Kullanicidugumunekle(kok,dugum.sol);



    }
    private static void KategoriSil(Kategori tempkategori) {
        Kategori temp=tempkategori.ust;
        tempkategori.ust.alt.remove(tempkategori);
        for (int i = 0; i <tempkategori.alt.size() ; i++) {
            tempkategori.alt.get(i).derinlik--;
            tempkategori.alt.get(i).ust=tempkategori.ust;
            tempkategori.alt.get(i).kategori_yolu=tempkategori.alt.get(i).kategori_yolu.replaceAll(tempkategori.kategori_ismi+":","");
        }
        tempkategori.ust.alt.addAll(tempkategori.alt);
        tempkategori.ust.alt_kategori_sayisi+=(tempkategori.alt_kategori_sayisi-1);
        for (int i = 0; i <tempkategori.alt.size(); i++) {
            while(temp!=null)
            {
                temp.rezervasyon_sayisi+=tempkategori.alt.get(i).rezervasyon_sayisi;
                temp.kullanici_sayisi+=tempkategori.alt.get(i).kullanici_sayisi;
                temp=temp.ust;
            }
        }
        temp=tempkategori.ust;
        while(temp!=null)
        {

            temp.rezervasyon_sayisi-=tempkategori.rezervasyon_sayisi;
            temp.kullanici_sayisi-=tempkategori.kullanici_sayisi;

            temp=temp.ust;
        }


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

    private static void Kullaniciekle(String kullanicisim,Kategori kok){

        Kullanici yenikullanici = new Kullanici();
        yenikullanici.kullanici_adi = kullanicisim;
        yenikullanici.kategori_ismi=kok.kategori_ismi;
        kullanicisayisiarttir(kok);

        if (kok.kullanicikok == null){
            yenikullanici.kok = kok;
            kok.kullanicikok=yenikullanici;

        }

        else{

            yenikullanici_ekle(yenikullanici, kok.kullanicikok);

        }

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
        while (kok != null) {
            System.out.println("--------------------------------------");
            System.out.println("İsim = " + isim);
            System.out.println("Kategori = " + kategori);
            System.out.println("Sehir = " + kok.sehir);
            System.out.println("Enlem = " + kok.enlem);
            System.out.println("Boylam = " + kok.boylam);
            System.out.println("Zaman = " + kok.rezervasyon_zamani);
            System.out.println("Yer Id = " + kok.yer_id);
            System.out.println("--------------------------------------");

            kok = kok.sonraki;
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

        if(kullanici.ust==null){

            return;
        }
        while(true){

    if(kullanici.rezervasyon_sayisi>karsilastirma.rezervasyon_sayisi){

       kullaniciyerdegistir(kullanici,karsilastirma);
        kullanici=karsilastirma;
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
        if(kok.kullanici_adi.equalsIgnoreCase(kullanici)) return kok;


        if(kok.sag!=null){
        if(kok.sag.kullanici_adi.equalsIgnoreCase(kullanici))return kok.sag;
            temp=kullanicivarmi(kullanici,kok.sag);
            if(temp!=null)return temp;

        }
        if(kok.sol!=null){
            if(kok.sol.kullanici_adi.equalsIgnoreCase(kullanici))return kok.sol;
            temp=kullanicivarmi(kullanici,kok.sol);
            if(temp!=null)return temp;

        }

        return null;
    }
    private static boolean yerkontrol(Rezervasyon kok, String yerid){
        Rezervasyon temp=kok;
        while (temp != null) {
            if (temp.yer_id.equals(yerid)){
                return true;
            }

            temp = temp.sonraki;

        }
        return false;
    }
    private static void yeregorekullanicikontrol(ArrayList<String> kullanicilar, Kullanici kok, String yerid){

        if(kok==null)return;
        if(yerkontrol(kok.rezervasyon_kok,yerid)) {
            if (!kullanicilar.contains(kok.kullanici_adi)) {
                kullanicilar.add(kok.kullanici_adi);
            }
        }

        if(kok.sag!=null){
            if(yerkontrol(kok.sag.rezervasyon_kok,yerid)) {
                if (!kullanicilar.contains(kok.sag.kullanici_adi)) {

                    kullanicilar.add(kok.sag.kullanici_adi);
                }
            }
        }
        if(kok.sol!=null){
            if(yerkontrol(kok.sol.rezervasyon_kok,yerid)) {
                if (!kullanicilar.contains(kok.sol.kullanici_adi)) {

                    kullanicilar.add(kok.sol.kullanici_adi);
                }
            }
        }

        yeregorekullanicikontrol(kullanicilar,kok.sag,yerid);
        yeregorekullanicikontrol(kullanicilar,kok.sol,yerid);




    }
    public static void kullaniciAlistekle(ArrayList<String> kullanicilar,Kullanici kok){

        if(kok==null)return;
        if(!kullanicilar.contains(kok.kullanici_adi)){
            kullanicilar.add(kok.kullanici_adi);
        }


        if(kok.sag!=null){

            if(!kullanicilar.contains(kok.sag.kullanici_adi)){

                kullanicilar.add(kok.sag.kullanici_adi);
            }

        }
        if(kok.sol!=null){
            if(!kullanicilar.contains(kok.sol.kullanici_adi)){

                kullanicilar.add(kok.sol.kullanici_adi);
            }

        }

        kullaniciAlistekle(kullanicilar,kok.sag);
        kullaniciAlistekle(kullanicilar,kok.sol);



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
    public static Kategori kategorivarmi2(String kategori,Kategori temp){

            for (int i = 0; i <temp.alt.size() ; i++) {

                if(temp.alt.get(i).kategori_ismi.equalsIgnoreCase(kategori))
                    return temp.alt.get(i);
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
