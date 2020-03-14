package com.mandala.surveyor.data.db.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class SurveyData implements Parcelable {
    public static final Creator<SurveyData> CREATOR = new Creator<SurveyData>() {
        @Override
        public SurveyData createFromParcel(Parcel in) {
            return new SurveyData(in);
        }

        @Override
        public SurveyData[] newArray(int size) {
            return new SurveyData[size];
        }
    };
    @SerializedName("status")
    private int status;
    @SerializedName("jarak")
    private String jarak;
    @SerializedName("aplikasi")
    private String aplikasi;
    @SerializedName("nama")
    private String nama;
    @SerializedName("kategori")
    private String kategori;
    @SerializedName("alamat")
    private String alamat;
    @SerializedName("kelurahan")
    private String kelurahan;
    @SerializedName("kecamatan")
    private String kecamatan;
    @SerializedName("kota")
    private String kota;
    @SerializedName("provinsi")
    private String provinsi;
    @SerializedName("noHp")
    private String noHp;
    @SerializedName("noWA")
    private String noWA;
    @SerializedName("subProduk")
    private String subProduk;
    @SerializedName("jenisProduk")
    private String jenisProduk;
    @SerializedName("merk")
    private String merk;
    @SerializedName("type")
    private String type;
    @SerializedName("model")
    private String model;

    public SurveyData(int status, String jarak, String aplikasi, String nama, String kategori, String alamat, String kelurahan, String kecamatan, String kota, String provinsi, String noHp, String noWA, String subProduk, String jenisProduk, String merk, String type, String model) {
        this.status = status;
        this.jarak = jarak;
        this.aplikasi = aplikasi;
        this.nama = nama;
        this.kategori = kategori;
        this.alamat = alamat;
        this.kelurahan = kelurahan;
        this.kecamatan = kecamatan;
        this.kota = kota;
        this.provinsi = provinsi;
        this.noHp = noHp;
        this.noWA = noWA;
        this.subProduk = subProduk;
        this.jenisProduk = jenisProduk;
        this.merk = merk;
        this.type = type;
        this.model = model;
    }

    protected SurveyData(Parcel in) {
        status = in.readInt();
        jarak = in.readString();
        aplikasi = in.readString();
        nama = in.readString();
        kategori = in.readString();
        alamat = in.readString();
        kelurahan = in.readString();
        kecamatan = in.readString();
        kota = in.readString();
        provinsi = in.readString();
        noHp = in.readString();
        noWA = in.readString();
        subProduk = in.readString();
        jenisProduk = in.readString();
        merk = in.readString();
        type = in.readString();
        model = in.readString();
    }

    public SurveyData() {
    }

    public int getStatus() {
        return status;
    }

    public String getJarak() {
        return jarak;
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

    public String getKelurahan() {
        return kelurahan;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public String getKota() {
        return kota;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public String getNoHp() {
        return noHp;
    }

    public String getNoWA() {
        return noWA;
    }

    public String getSubProduk() {
        return subProduk;
    }

    public String getJenisProduk() {
        return jenisProduk;
    }

    public String getMerk() {
        return merk;
    }

    public String getType() {
        return type;
    }

    public String getModel() {
        return model;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(status);
        dest.writeString(jarak);
        dest.writeString(aplikasi);
        dest.writeString(nama);
        dest.writeString(kategori);
        dest.writeString(alamat);
        dest.writeString(kelurahan);
        dest.writeString(kecamatan);
        dest.writeString(kota);
        dest.writeString(provinsi);
        dest.writeString(noHp);
        dest.writeString(noWA);
        dest.writeString(subProduk);
        dest.writeString(jenisProduk);
        dest.writeString(merk);
        dest.writeString(type);
        dest.writeString(model);
    }
}
