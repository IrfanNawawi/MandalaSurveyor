package com.mandala.surveyor.data.db.models;

public class OutboxDraftData {
    private String aplikasi;
    private String nama;
    private String kategori;
    private String alamat;
    private String kota;

    public OutboxDraftData(String aplikasi, String nama, String kategori, String alamat, String kota) {
        this.aplikasi = aplikasi;
        this.nama = nama;
        this.kategori = kategori;
        this.alamat = alamat;
        this.kota = kota;
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
