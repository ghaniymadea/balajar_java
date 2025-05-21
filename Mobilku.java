package com.belajar;
public class Mobilku {
    String warna;
    int tahunProduksi;
    int nomorMesin; 
    int nomorRangka;

    void isi(String warna, int tahunProduksi, int nomorMesin, int nomorRangka){
        this.warna = warna;
        this.tahunProduksi = tahunProduksi;
        this.nomorMesin = nomorMesin;
        this.nomorRangka = nomorRangka;
    }

    String ambilWarna() {
        return warna;
    }

    int ambilTahunProduksi() {
        return tahunProduksi;
    }

    int ambilNomorMesin() {
        return nomorMesin;
    }

    int ambilNomorRangka() {
        return nomorRangka;
    }

    public static void main(String[] args) {
        Mobilku mobilNiaga = new Mobilku();
        mobilNiaga.isi("putih", 2018, 23456, 89567);
        System.out.println("Warna: " + mobilNiaga.ambilWarna());
        System.out.println("Tahun Produksi: " + mobilNiaga.ambilTahunProduksi());
        System.out.println("Nomor Mesin: " + mobilNiaga.ambilNomorMesin());
        System.out.println("Nomor Rangka: " + mobilNiaga.ambilNomorRangka());
    }
}