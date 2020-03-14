package com.mandala.surveyor.data.db.models;

public class HistoryAbsenData {
    private int image;
    private String title;
    private String nama;
    private String nik;
    private String cabang;
    private String job;
    private String waktuAbsen;
    private int status;

    public HistoryAbsenData(int image, String title, String nama, String nik, String cabang, String job, String waktuAbsen, int status) {
        this.image = image;
        this.title = title;
        this.nama = nama;
        this.nik = nik;
        this.cabang = cabang;
        this.job = job;
        this.waktuAbsen = waktuAbsen;
        this.status = status;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getNama() {
        return nama;
    }

    public String getNik() {
        return nik;
    }

    public String getCabang() {
        return cabang;
    }

    public String getJob() {
        return job;
    }

    public String getWaktuAbsen() {
        return waktuAbsen;
    }

    public int getStatus() {
        return status;
    }
}
