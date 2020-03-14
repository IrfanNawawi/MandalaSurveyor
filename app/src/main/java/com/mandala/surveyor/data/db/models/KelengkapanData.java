package com.mandala.surveyor.data.db.models;

public class KelengkapanData {
    private String booking;
    private String tanggal;
    private String nama;
    private String kategori;
    private String alamat;

    public KelengkapanData(String booking, String tanggal, String nama, String kategori, String alamat) {
        this.booking = booking;
        this.tanggal = tanggal;
        this.nama = nama;
        this.kategori = kategori;
        this.alamat = alamat;
    }

    public String getBooking() {
        return booking;
    }

    public String getTanggal() {
        return tanggal;
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
}
