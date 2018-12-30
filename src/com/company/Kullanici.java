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
    Kullanici(Kullanici obje){
        this.kategori_ismi=obje.kategori_ismi;
        this.kullanici_adi=obje.kullanici_adi;
        this.ust=null;
        this.sag=null;
        this.sol=null;
        this.kok=null;
        this.rezervasyon_kok=obje.rezervasyon_kok;
        this.derinlik=0;
        this.rezervasyon_sayisi=obje.rezervasyon_sayisi;
    }

}
