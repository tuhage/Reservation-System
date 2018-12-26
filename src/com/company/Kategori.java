package com.company;

import java.util.ArrayList;

public class Kategori {
    public Kategori ust;
    public ArrayList<Kategori> alt;
    public Kullanici kullanicikok;

    public String kategori_ismi;
    public int alt_kategori_sayisi;
    public int kullanici_sayisi;
    public int rezervasyon_sayisi;
    public String kategori_yolu;
    public int derinlik;

    Kategori(){
        alt=new ArrayList<Kategori>();
        ust=null;
        kullanicikok=null;
        kategori_ismi="rezervasyon";
        kategori_yolu="";
        derinlik=0;
        rezervasyon_sayisi=0;
        kullanici_sayisi=0;
        alt_kategori_sayisi=0;
    }

}
