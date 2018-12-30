package com.company;

public class Kullanici {

    public Kategori kok;
    public Kullanici ust;
    public Kullanici sag;
    public Kullanici sol;
    public Rezervasyon rezervasyon_kok;
    public String kullanici_adi;
    public String kategori_ismi;
    public int rezervasyon_sayisi;
    public int derinlik;

    Kullanici(){
        ust=null;
        sag=null;
        sol=null;
        kok=null;
        rezervasyon_kok=null;
        derinlik=0;
        rezervasyon_sayisi=0;
    }

}
