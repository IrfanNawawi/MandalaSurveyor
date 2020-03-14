package com.mandala.surveyor.data.db.models;

public class OutboxSelesaiData {
    private int status;
    private String aplikasi;
    private String nama;
    private String kategori;
    private String alamat;
    private String kota;

    public OutboxSelesaiData(int status, String aplikasi, String nama, String kategori, String alamat, String kota) {
        this.status = status;
        this.aplikasi = aplikasi;
        this.nama = nama;
        this.kategori = kategori;
        this.alamat = alamat;
        this.kota = kota;
    }

    public int getStatus() {
        return status;
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

    public String getKota() {
        return kota;
    }
}
