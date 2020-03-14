package com.mandala.surveyor.data.db.models;

public class LacakAplikasiData {
    private String tanggal;
    private String aplikasi;
    private String nama;
    private String kategori;
    private String alamat;
    private int status;

    public LacakAplikasiData(String tanggal, String aplikasi, String nama, String kategori, String alamat, int status) {
        this.tanggal = tanggal;
        this.aplikasi = aplikasi;
        this.nama = nama;
        this.kategori = kategori;
        this.alamat = alamat;
        this.status = status;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getAplikasi() {
        return aplikasi;
    }

    public String getNama() {
        return nama;
    }

    public String getKategori() {
        return kategori;
    }

    public String getAlamat() {
        return alamat;
    }

    public int getStatus() {
        return status;
    }
}
