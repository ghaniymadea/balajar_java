package com.belajar;
// latihan void method
public class Mobil {
    String warna;
    int tahunProduksi;
    int nomor_mesin;
    int numor_rangka;

    public static void main(String[] args) {
        Mobil mobilNiaga = new Mobil();
        //Pemanggilan mrthod void
        mobilNiaga.isi();
        mobilNiaga.tampil();
    }
    //Mengisi variabel instance
    void isi(){
        warna = "Merah";
        tahunProduksi = 2018;
        nomor_mesin = 12345;
        numor_rangka = 8967;
    }
    //Menampilkan isi variabel
    void tampil(){
        System.out.println("Warna : " + warna);
        System.out.println("Tahun Produksi :" + tahunProduksi);
        System.out.println("Nomor Mesin :" + nomor_mesin);
        System.out.println("Nmomor Rangka :" + numor_rangka);
    }
}
